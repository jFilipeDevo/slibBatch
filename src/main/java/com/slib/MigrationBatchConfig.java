package com.slib;

import javax.sql.DataSource;
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

@Configuration
public class MigrationBatchConfig {

    private final DataSource sourceDataSource;
    private final DataSource targetDataSource;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    // Inject the named DataSources
    public MigrationBatchConfig(
            @Qualifier("sourceDataSource") DataSource sourceDataSource,
            @Qualifier("targetDataSource") DataSource targetDataSource,
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager) {
        this.sourceDataSource = sourceDataSource;
        this.targetDataSource = targetDataSource;
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    public static class DataRecord {
        private Long id;
        private String name;

        public DataRecord() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Bean
    public JdbcCursorItemReader<DataRecord> reader(@Qualifier("sourceDataSource") DataSource sourceDataSource) {
        return new JdbcCursorItemReaderBuilder<DataRecord>()
                .dataSource(sourceDataSource)
                .name("jdbcReader")
                .sql("SELECT id, name FROM ds_portfolio")
                .rowMapper(new BeanPropertyRowMapper<>(DataRecord.class))
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<DataRecord> writer(@Qualifier("targetDataSource") DataSource targetDataSource) {
        return new JdbcBatchItemWriterBuilder<DataRecord>()
                .dataSource(targetDataSource)
                .sql("INSERT INTO ds_portfolio_new (id, name) VALUES (:id, :name) ON CONFLICT (id) DO NOTHING")
                .beanMapped()
                .build();
    }

    @Bean
    public Step migrationStep(JobRepository jobRepository, 
                               PlatformTransactionManager transactionManager,
                               JdbcCursorItemReader<DataRecord> reader,
                               JdbcBatchItemWriter<DataRecord> writer) {
        return new StepBuilder("migrationStep", jobRepository)
                .<DataRecord, DataRecord>chunk(50, transactionManager)
                .reader(reader)
                .writer(writer)
                .build();
    }

    @Bean
    public Job dailyBatchJob(JobRepository jobRepository, Step migrationStep) {
        return new JobBuilder("dbMigrationJob", jobRepository)
                .start(migrationStep)
                .build();
    }
}