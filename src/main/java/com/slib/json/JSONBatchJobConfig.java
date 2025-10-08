package com.slib.json;

import org.springframework.core.io.Resource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class JSONBatchJobConfig {
    private final DataSource targetDataSource;
    private final JobRepository jobJSONRepository;
    private final PlatformTransactionManager transactionManager;
    @Value("file:C:/Users/joao.simoes.filipe/Desktop/slibJSON/products.json")
    private Resource inputResource;

    public JSONBatchJobConfig(
            @Qualifier("targetDataSource") DataSource targetDataSource,
            JobRepository jobJSONRepository,
            PlatformTransactionManager transactionManager) {
        this.targetDataSource = targetDataSource;
        this.jobJSONRepository = jobJSONRepository;
        this.transactionManager = transactionManager;
    }

    @Bean
    public JsonItemReader<Product> readerJSON() {
        return new JsonItemReader<>(this.inputResource, new JacksonJsonObjectReader<>(Product.class));
    }

    @Bean
    public JdbcBatchItemWriter<Product> writerJSON(@Qualifier("targetDataSource") DataSource targetDataSource) {
        return new JdbcBatchItemWriterBuilder<Product>().dataSource(targetDataSource)
                .sql("INSERT INTO json_new (id, name) VALUES (:id, :name) ON CONFLICT (id) DO NOTHING")
                .beanMapped().build();
    }

    @Bean
    public Step migrationStepJSON(JobRepository jobJSONRepository,
                               PlatformTransactionManager transactionManager,
                              JsonItemReader<Product> readerJSON,
                               JdbcBatchItemWriter<Product> writerJSON) {
        return new StepBuilder("migrationStepJSON", jobJSONRepository)
                .<Product, Product>chunk(50, transactionManager)
                .reader(readerJSON).writer(writerJSON).build();
    }

    @Bean
    public Job dailyBatchJobJSON(JobRepository jobJSONRepository,
                                 @Qualifier("migrationStepJSON") Step migrationStepJSON) {
        return new JobBuilder("migrationJobJSON", jobJSONRepository).start(migrationStepJSON).build();
    }
}