package com.slib.json;

import com.slib.listener.ChunkLoggingListener;
import com.slib.listener.JobCompletionListener;
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
    private static final int CHUNK_SIZE = 50;
    private final DataSource targetDataSource;
    private final JobRepository jobJSONRepository;
    private final JobCompletionListener jobCompletionListener;
    private final PlatformTransactionManager transactionManager;
    @Value("${batch.job.json.file}")
    private Resource inputResource;

    public JSONBatchJobConfig(
            @Qualifier("targetDataSource") DataSource targetDataSource,
            JobCompletionListener jobCompletionListener,
            JobRepository jobJSONRepository,
            PlatformTransactionManager transactionManager) {
        this.targetDataSource = targetDataSource;
        this.jobCompletionListener = jobCompletionListener;
        this.jobJSONRepository = jobJSONRepository;
        this.transactionManager = transactionManager;
    }

    @Bean
    public JsonItemReader<kpiConfig> readerJSON() {
        return new JsonItemReader<>(this.inputResource, new JacksonJsonObjectReader<>(kpiConfig.class));
    }

    @Bean
    public JdbcBatchItemWriter<kpiConfig> writerJSON(@Qualifier("targetDataSource") DataSource targetDataSource) {
        return new JdbcBatchItemWriterBuilder<kpiConfig>().dataSource(targetDataSource)
                .sql("INSERT INTO kpi_config (kpi_id, kpi_name, threshold_upper_value," +
                        "threshold_lower_value,target_field_window_values,target_field_window_unit,severity," +
                        "priority,breach_on,evaluation_frequency,created_at_utc)" +
                        " VALUES (:kpiId, :kpiName, :thresholdUpperValue, :thresholdLowerValue," +
                        ":targetFieldWindowValues, :targetFieldWindowUnit, :severity," +
                        ":priority, :breachOn, :evaluationFrequency, NOW()) ON CONFLICT (kpi_id) DO NOTHING")
                .beanMapped().build();
    }

    @Bean
    public Step migrationStepJSON(JobRepository jobJSONRepository,
                               PlatformTransactionManager transactionManager,
                              JsonItemReader<kpiConfig> readerJSON,
                               JdbcBatchItemWriter<kpiConfig> writerJSON) {
        return new StepBuilder("migrationStepJSON", jobJSONRepository)
                .<kpiConfig, kpiConfig>chunk(CHUNK_SIZE, transactionManager)
                .listener(new ChunkLoggingListener(CHUNK_SIZE)).reader(readerJSON).writer(writerJSON).build();

    }

    @Bean
    public Job dailyBatchJobJSON(JobRepository jobJSONRepository,
                                 @Qualifier("migrationStepJSON") Step migrationStepJSON) {
        return new JobBuilder("migrationJobJSON", jobJSONRepository).listener(jobCompletionListener).
                start(migrationStepJSON).build();
    }
}