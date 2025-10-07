package com.slib;

import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class MigrationBatchConfig {

    private final DataSource sourceDataSource;
    private final DataSource targetDataSource;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    // Inject the named DataSources
    public MigrationBatchConfig(
            DataSource sourceDataSource,
            DataSource targetDataSource,
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager) {
        this.sourceDataSource = sourceDataSource;
        this.targetDataSource = targetDataSource;
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    // Define the data model class (e.g., a simple record/POJO)
    // You need to create a class named 'DataRecord' with matching fields.
    public static class DataRecord {
        // Example fields matching your source SELECT and target INSERT
        private Long id;
        private String name;
        // ... getters/setters/constructors
    }

    /**
     * ItemReader: Reads data from the Source Database (Database A).
     */
    @Bean
    public JdbcCursorItemReader<DataRecord> reader() {
        return new JdbcCursorItemReaderBuilder<DataRecord>()
                .dataSource(sourceDataSource).name("jdbcReader")
                .sql("SELECT id, name FROM ds_portfolio")
                .rowMapper(new BeanPropertyRowMapper<>(DataRecord.class)).build();
    }

    /**
     * ItemWriter: Writes data to the Target Database (Database B).
     */
    @Bean
    public JdbcBatchItemWriter<DataRecord> writer() {
        return new JdbcBatchItemWriterBuilder<DataRecord>()
                .dataSource(targetDataSource)
                .sql("INSERT INTO ds_portfolio_new (id, name, migrated_at) VALUES (:id, :name, NOW())") // Your INSERT query
                .beanMapped().build();
    }

    /**
     * Step: Executes the R-P-W logic in chunks.
     */
    @Bean
    public Step migrationStep() {
        return new StepBuilder("migrationStep", jobRepository)
                .<DataRecord, DataRecord>chunk(50, transactionManager) // Process 50 records per transaction
                .reader(reader())
                // .processor(processor()) // Optional: uncomment if you add a processor
                .writer(writer())
                .build();
    }

    /**
     * Job: Defines the entire migration process.
     */
    @Bean
    public Job migrationJob() {
        return new JobBuilder("dbMigrationJob", jobRepository).start(migrationStep()).build();
    }
}