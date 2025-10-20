package com.slib.bd;

import javax.sql.DataSource;

import com.slib.bd.entity.DsAccountDTO;
import com.slib.bd.entity.DsPortfolioDTO;
import com.slib.listener.ChunkLoggingListener;
import com.slib.listener.JobCompletionListener;
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
    private static final int CHUNK_SIZE = 50;
    private final DataSource sourceDataSource;
    private final DataSource targetDataSource;
    private final JobRepository jobDatabaseRepository;
    private final PlatformTransactionManager transactionManager;
    private final JobCompletionListener jobCompletionListener;

    // Restoring explicit injection via constructor
    public DatabaseBatchJobConfig(
            @Qualifier("sourceDataSource") DataSource sourceDataSource,
            @Qualifier("targetDataSource") DataSource targetDataSource,
            JobRepository jobDatabaseRepository,
            PlatformTransactionManager transactionManager,
            JobCompletionListener jobCompletionListener) {
        this.sourceDataSource = sourceDataSource;
        this.targetDataSource = targetDataSource;
        this.jobDatabaseRepository = jobDatabaseRepository;
        this.transactionManager = transactionManager;
        this.jobCompletionListener = jobCompletionListener;
    }

    @Bean
    public JdbcBatchItemWriter<DsPortfolioDTO> writerDsPortfolio() {
        String[] sql = generateSql(DsPortfolioDTO.class, "ds_portfolio");
        String insertSql = sql[1];
        return new JdbcBatchItemWriterBuilder<DsPortfolioDTO>().dataSource(targetDataSource)
                .sql(insertSql).beanMapped().build();
    }

    @Bean
    public Step dsPortfolioStep(JdbcBatchItemWriter<DsPortfolioDTO> writerDsPortfolio) {
        String[] sql = generateSql(DsPortfolioDTO.class, "ds_portfolio");
        String selectSql = sql[0];
        JdbcCursorItemReader<DsPortfolioDTO> reader = new JdbcCursorItemReaderBuilder<DsPortfolioDTO>()
                .dataSource(sourceDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(DsPortfolioDTO.class)).build();
        return new StepBuilder("ds_portfolioStep", jobDatabaseRepository)
                .<DsPortfolioDTO, DsPortfolioDTO>chunk(CHUNK_SIZE, transactionManager)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerDsPortfolio).build();
    }

    @Bean
    public JdbcBatchItemWriter<DsAccountDTO> writerAccountDatabase() {
        String[] sql = generateSql(DsAccountDTO.class, "ds_account");
        String insertSql = sql[1];
        return new JdbcBatchItemWriterBuilder<DsAccountDTO>().dataSource(targetDataSource)
                .sql(insertSql).beanMapped().build();
    }

    @Bean
    public Step dsAccountStep(JdbcBatchItemWriter<DsAccountDTO> writerAccountDatabase) {
        String[] sql = generateSql(DsAccountDTO.class, "ds_account");
        String selectSql = sql[0];
        JdbcCursorItemReader<DsAccountDTO> reader = new JdbcCursorItemReaderBuilder<DsAccountDTO>()
                .dataSource(sourceDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(DsAccountDTO.class)).build();
        return new StepBuilder("ds_accountStep", jobDatabaseRepository)
                .<DsAccountDTO, DsAccountDTO>chunk(CHUNK_SIZE, transactionManager)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerAccountDatabase).build();
    }

    @Bean
    public Job dailyDatabaseJob(JobRepository jobDatabaseRepository,
                             @Qualifier("dsPortfolioStep") Step dsPortfolioStep,
                                @Qualifier("dsAccountStep") Step dsAccountStep) {
        return new JobBuilder("migrationJobDatabase", jobDatabaseRepository)
                .listener(jobCompletionListener)
                .start(dsPortfolioStep)
                .next(dsAccountStep).build();
    }

    private <T> String[] generateSql(Class<T> dtoClass, String schemaAndTableName) {
        String columnList = Arrays.stream(dtoClass.getDeclaredFields())
                .map(Field::getName)
                .map(name -> name.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase())
                .collect(Collectors.joining(","));
        String valueList = Arrays.stream(dtoClass.getDeclaredFields())
                .map(Field::getName).map(name -> ":" + name).collect(Collectors.joining(","));
        String selectSql = "SELECT " + columnList + " FROM " + schemaAndTableName;
        String insertSql = "INSERT INTO " + schemaAndTableName + " (" + columnList +
                ") VALUES (" + valueList + ") ON CONFLICT (ds_id) DO NOTHING";
        return new String[]{selectSql, insertSql};
    }
}