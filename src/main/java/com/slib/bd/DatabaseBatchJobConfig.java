package com.slib.bd;

import javax.sql.DataSource;

import com.slib.bd.entity.DsAccountDTO;
import com.slib.bd.entity.DsPortfolioDTO;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

@Configuration
public class DatabaseBatchJobConfig {
    private final DataSource sourceDataSource;
    private final DataSource targetDataSource;
    private final JobRepository jobDatabaseRepository;
    private final PlatformTransactionManager transactionManager;

    // Restoring explicit injection via constructor
    public DatabaseBatchJobConfig(
            @Qualifier("sourceDataSource") DataSource sourceDataSource,
            @Qualifier("targetDataSource") DataSource targetDataSource,
            JobRepository jobDatabaseRepository,
            PlatformTransactionManager transactionManager) {
        this.sourceDataSource = sourceDataSource;
        this.targetDataSource = targetDataSource;
        this.jobDatabaseRepository = jobDatabaseRepository;
        this.transactionManager = transactionManager;
    }

    // --- UTILITY/FACTORY METHODS ---

    /**
     * Generates dynamic SQL strings (SELECT and INSERT value list) based on DTO fields.
     */
    private <T> String[] generateSql(Class<T> dtoClass, String schemaAndTableName) {
        // Collect field names from the DTO, converting camelCase to snake_case for DB columns
        String columnList = Arrays.stream(dtoClass.getDeclaredFields())
                .map(Field::getName)
                .map(name -> name.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase())
                .collect(Collectors.joining(","));

        // Collect parameter names for the INSERT (must match DTO camelCase field names)
        String valueList = Arrays.stream(dtoClass.getDeclaredFields())
                .map(Field::getName)
                .map(name -> ":" + name)
                .collect(Collectors.joining(","));

        String selectSql = "SELECT " + columnList + " FROM " + schemaAndTableName;

        // Using ON CONFLICT on the assumption that ds_id and id form a primary key,
        // as typically seen in these data source (ds_) tables.
        String insertSql = "INSERT INTO " + schemaAndTableName + " (" + columnList +
                ") VALUES (" + valueList + ") ON CONFLICT (ds_id, id) DO NOTHING";

        return new String[]{selectSql, insertSql};
    }

    // ----------------------------------------------------
    // 1. GENERIC FACTORY FOR STEPS, READERS, AND WRITERS
    // ----------------------------------------------------

    public <T> Step createMigrationStep(String stepName, String tableName, Class<T> dtoClass) {
        // Generate SQL based on the DTO fields
        String[] sql = generateSql(dtoClass, "rmt_dashboards." + tableName);
        String selectSql = sql[0];
        String insertSql = sql[1];

        // 1. Create Reader
        JdbcCursorItemReader<T> reader = new JdbcCursorItemReaderBuilder<T>()
                .dataSource(sourceDataSource)
                .name(stepName + "Reader")
                .sql(selectSql)
                .rowMapper(new BeanPropertyRowMapper<>(dtoClass))
                .build();

        // 2. Create Writer (Disabling assertUpdates to avoid warnings on ON CONFLICT DO NOTHING)
        JdbcBatchItemWriter<T> writer = new JdbcBatchItemWriterBuilder<T>()
                .dataSource(targetDataSource).sql(insertSql).beanMapped().assertUpdates(false).build();

        // 3. Create Step
        return new StepBuilder(stepName, jobDatabaseRepository)
                .<T, T>chunk(50, transactionManager)
                .reader(reader).writer(writer).build();
    }

    @Bean
    public Step migrateDsPortfolioStep() {
        return createMigrationStep("migrateDsPortfolioStep", "ds_portfolio", DsPortfolioDTO.class);
    }

    @Bean
    public Step migrateDsAccountStep() {
        return createMigrationStep("migrateDsAccountStep", "ds_account", DsAccountDTO.class);
    }

    @Bean
    public Job dailyDatabaseJob(
            @Qualifier("migrateDsPortfolioStep") Step portfolioStep,
            @Qualifier("migrateDsAccountStep") Step accountStep) {
        return new JobBuilder("dailyDatabaseJob", jobDatabaseRepository)
                .start(portfolioStep)
                .next(accountStep)
                //.next(clientStep)
                .build();
    }
}