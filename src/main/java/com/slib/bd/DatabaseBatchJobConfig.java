package com.slib.bd;

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
public class DatabaseBatchJobConfig {
    private final DataSource sourceDataSource;
    private final DataSource targetDataSource;
    private final JobRepository jobDatabaseRepository;
    private final PlatformTransactionManager transactionManager;

    // Inject the named DataSources
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
    public JdbcCursorItemReader<DataRecord> readerDatabase(@Qualifier("sourceDataSource") DataSource sourceDataSource) {
        return new JdbcCursorItemReaderBuilder<DataRecord>().dataSource(sourceDataSource).name("jdbcReader")
                .sql("SELECT id, name FROM ds_portfolio")
                .rowMapper(new BeanPropertyRowMapper<>(DataRecord.class)).build();
    }

    @Bean
    public JdbcBatchItemWriter<DataRecord> writerDatabase(@Qualifier("targetDataSource") DataSource targetDataSource) {
        return new JdbcBatchItemWriterBuilder<DataRecord>().dataSource(targetDataSource)
                .sql("INSERT INTO ds_portfolio_new (id, name) VALUES (:id, :name) ON CONFLICT (id) DO NOTHING")
                .beanMapped().build();
    }

    @Bean
    public Step migrationStepDatabase(JobRepository jobDatabaseRepository,
                               PlatformTransactionManager transactionManager,
                               JdbcCursorItemReader<DataRecord> readerDatabase,
                               JdbcBatchItemWriter<DataRecord> writerDatabase) {
        return new StepBuilder("migrationStepDatabase", jobDatabaseRepository)
                .<DataRecord, DataRecord>chunk(50, transactionManager)
                .reader(readerDatabase).writer(writerDatabase).build();
    }

    @Bean
    public Job dailyBatchJob(JobRepository jobDatabaseRepository,
                             @Qualifier("migrationStepDatabase") Step migrationStepDatabase) {
        return new JobBuilder("migrationJobDatabase", jobDatabaseRepository).start(migrationStepDatabase).build();
    }
}