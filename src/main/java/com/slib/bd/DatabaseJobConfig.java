package com.slib.bd;

import javax.sql.DataSource;
import com.slib.CustomFixedBackOffPolicy;
import com.slib.bd.entity.*;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

@Configuration
public class DatabaseJobConfig {
    private static final int CHUNK_SIZE = 50;
    private final DataSource sourceCoreDataSource;
    private final DataSource sourceDashboardDataSource;
    private final DataSource targetDataSource;
    private final JobRepository jobDatabaseRepository;
    private final PlatformTransactionManager transactionManager;
    private final JobCompletionListener jobCompletionListener;
    @Value("${batch.processing.retry-limit}")
    private int retryLimit;

    // Restoring explicit injection via constructor
    public DatabaseJobConfig(
            @Qualifier("sourceCoreDataSource") DataSource sourceCoreDataSource,
            @Qualifier("sourceDashboardDataSource") DataSource sourceDashboardDataSource,
            @Qualifier("targetDataSource") DataSource targetDataSource,
            JobRepository jobDatabaseRepository,
            PlatformTransactionManager transactionManager,
            JobCompletionListener jobCompletionListener) {
        this.sourceCoreDataSource = sourceCoreDataSource;
        this.sourceDashboardDataSource = sourceDashboardDataSource;
        this.targetDataSource = targetDataSource;
        this.jobDatabaseRepository = jobDatabaseRepository;
        this.transactionManager = transactionManager;
        this.jobCompletionListener = jobCompletionListener;
    }

    @Bean
    public JdbcBatchItemWriter<ConnectorParamDTO> writerConnectorParam() {
        String[] sql = generateSql(ConnectorParamDTO.class, "connector_param");
        return new JdbcBatchItemWriterBuilder<ConnectorParamDTO>().dataSource(targetDataSource)
                .sql(sql[1]).beanMapped().assertUpdates(false).build();
    }

    @Bean
    public Step connectorParamStep(JdbcBatchItemWriter<ConnectorParamDTO> writerConnectorParam) {
        String[] sql = generateSql(ConnectorParamDTO.class, "connector_param");
        String selectSql = sql[0];
        JdbcCursorItemReader<ConnectorParamDTO> reader = new JdbcCursorItemReaderBuilder<ConnectorParamDTO>()
                .dataSource(sourceCoreDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(ConnectorParamDTO.class)).build();
        return new StepBuilder("connectorParamStep", jobDatabaseRepository)
                .<ConnectorParamDTO, ConnectorParamDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerConnectorParam).build();
    }

    @Bean
    public JdbcBatchItemWriter<CurrencyRefDTO> writerCurrencyRef() {
        String[] sql = generateSql(CurrencyRefDTO.class, "currency_ref");
        return new JdbcBatchItemWriterBuilder<CurrencyRefDTO>().dataSource(targetDataSource)
                .sql(sql[1]).beanMapped().assertUpdates(false).build();
    }

    @Bean
    public Step currencyRefStep(JdbcBatchItemWriter<CurrencyRefDTO> writerCurrencyRef) {
        String[] sql = generateSql(CurrencyRefDTO.class, "currency_ref");
        String selectSql = sql[0];
        JdbcCursorItemReader<CurrencyRefDTO> reader = new JdbcCursorItemReaderBuilder<CurrencyRefDTO>()
                .dataSource(sourceCoreDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(CurrencyRefDTO.class)).build();
        return new StepBuilder("currencyRefStep", jobDatabaseRepository)
                .<CurrencyRefDTO, CurrencyRefDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerCurrencyRef).build();
    }

    @Bean
    public JdbcBatchItemWriter<DsAccountDTO> writerDsAccountDatabase() {
        String[] sql = generateSql(DsAccountDTO.class, "ds_account");
        String insertSql = sql[1];
        return new JdbcBatchItemWriterBuilder<DsAccountDTO>().dataSource(targetDataSource)
                .sql(insertSql).beanMapped().assertUpdates(false).build();
    }

    @Bean
    public Step dsAccountStep(JdbcBatchItemWriter<DsAccountDTO> writerDsAccountDatabase) {
        String[] sql = generateSql(DsAccountDTO.class, "ds_account");
        String selectSql = sql[0];
        JdbcCursorItemReader<DsAccountDTO> reader = new JdbcCursorItemReaderBuilder<DsAccountDTO>()
                .dataSource(sourceDashboardDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(DsAccountDTO.class)).build();
        return new StepBuilder("dsAccountStep", jobDatabaseRepository)
                .<DsAccountDTO, DsAccountDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerDsAccountDatabase).build();
    }

    @Bean
    public JdbcBatchItemWriter<DsAccountToRiskDTO> writerDsAccountToRisk() {
        String[] sql = generateSql(DsAccountToRiskDTO.class, "ds_account_to_risk");
        return new JdbcBatchItemWriterBuilder<DsAccountToRiskDTO>().dataSource(targetDataSource)
                .sql(sql[1]).beanMapped().assertUpdates(false).build();
    }

    @Bean
    public Step dsAccountToRiskStep(JdbcBatchItemWriter<DsAccountToRiskDTO> writerDsAccountToRisk) {
        String[] sql = generateSql(DsAccountToRiskDTO.class, "ds_account_to_risk");
        String selectSql = sql[0];
        JdbcCursorItemReader<DsAccountToRiskDTO> reader = new JdbcCursorItemReaderBuilder<DsAccountToRiskDTO>()
                .dataSource(sourceDashboardDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(DsAccountToRiskDTO.class)).build();
        return new StepBuilder("dsAccountToRiskStep", jobDatabaseRepository)
                .<DsAccountToRiskDTO, DsAccountToRiskDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerDsAccountToRisk).build();
    }

    @Bean
    public JdbcBatchItemWriter<DsClientEntityDTO> writerDsClientEntity() {
        String[] sql = generateSql(DsClientEntityDTO.class, "ds_client_entity");
        return new JdbcBatchItemWriterBuilder<DsClientEntityDTO>().dataSource(targetDataSource)
                .sql(sql[1]).beanMapped().assertUpdates(false).build();
    }

    @Bean
    public Step dsClientEntityStep(JdbcBatchItemWriter<DsClientEntityDTO> writerDsClientEntity) {
        String[] sql = generateSql(DsClientEntityDTO.class, "ds_client_entity");
        String selectSql = sql[0];
        JdbcCursorItemReader<DsClientEntityDTO> reader = new JdbcCursorItemReaderBuilder<DsClientEntityDTO>()
                .dataSource(sourceDashboardDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(DsClientEntityDTO.class)).build();
        return new StepBuilder("dsClientEntityStep", jobDatabaseRepository)
                .<DsClientEntityDTO, DsClientEntityDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerDsClientEntity).build();
    }

    @Bean
    public JdbcBatchItemWriter<DsPortfolioDTO> writerDsPortfolio() {
        String[] sql = generateSql(DsPortfolioDTO.class, "ds_portfolio");
        return new JdbcBatchItemWriterBuilder<DsPortfolioDTO>().dataSource(targetDataSource)
                .sql(sql[1]).beanMapped().assertUpdates(false).build();
    }

    @Bean
    public Step dsPortfolioStep(JdbcBatchItemWriter<DsPortfolioDTO> writerDsPortfolio) {
        String[] sql = generateSql(DsPortfolioDTO.class, "ds_portfolio");
        String selectSql = sql[0];
        JdbcCursorItemReader<DsPortfolioDTO> reader = new JdbcCursorItemReaderBuilder<DsPortfolioDTO>()
                .dataSource(sourceDashboardDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(DsPortfolioDTO.class)).build();
        return new StepBuilder("dsPortfolioStep", jobDatabaseRepository)
                .<DsPortfolioDTO, DsPortfolioDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerDsPortfolio).build();
    }

    @Bean
    public JdbcBatchItemWriter<DsPortfolioToRiskDTO> writerDsPortfolioToRisk() {
        String[] sql = generateSql(DsPortfolioToRiskDTO.class, "ds_portfolio_to_risk");
        return new JdbcBatchItemWriterBuilder<DsPortfolioToRiskDTO>().dataSource(targetDataSource)
                .sql(sql[1]).beanMapped().assertUpdates(false).build();
    }

    @Bean
    public Step dsPortfolioToRiskStep(JdbcBatchItemWriter<DsPortfolioToRiskDTO> writerDsPortfolioToRisk) {
        String[] sql = generateSql(DsPortfolioToRiskDTO.class, "ds_portfolio_to_risk");
        String selectSql = sql[0];
        JdbcCursorItemReader<DsPortfolioToRiskDTO> reader = new JdbcCursorItemReaderBuilder<DsPortfolioToRiskDTO>()
                .dataSource(sourceDashboardDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(DsPortfolioToRiskDTO.class)).build();
        return new StepBuilder("dsPortfolioToRiskStep", jobDatabaseRepository)
                .<DsPortfolioToRiskDTO, DsPortfolioToRiskDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerDsPortfolioToRisk).build();
    }

    @Bean
    public JdbcBatchItemWriter<DsRiskUnitDTO> writerDsRiskUnit() {
        String[] sql = generateSql(DsRiskUnitDTO.class, "ds_risk_unit");
        return new JdbcBatchItemWriterBuilder<DsRiskUnitDTO>().dataSource(targetDataSource)
                .sql(sql[1]).beanMapped().assertUpdates(false).build();
    }

    @Bean
    public Step dsRiskUnitStep(JdbcBatchItemWriter<DsRiskUnitDTO> writerDsRiskUnit) {
        String[] sql = generateSql(DsRiskUnitDTO.class, "ds_risk_unit");
        String selectSql = sql[0];
        JdbcCursorItemReader<DsRiskUnitDTO> reader = new JdbcCursorItemReaderBuilder<DsRiskUnitDTO>()
                .dataSource(sourceDashboardDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(DsRiskUnitDTO.class)).build();
        return new StepBuilder("dsRiskUnitStep", jobDatabaseRepository)
                .<DsRiskUnitDTO, DsRiskUnitDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerDsRiskUnit).build();
    }

    @Bean
    public JdbcBatchItemWriter<ExpositionVacationDTO> writerExpositionVacation() {
        String[] sql = generateSql(ExpositionVacationDTO.class, "exposition_vacation");
        return new JdbcBatchItemWriterBuilder<ExpositionVacationDTO>().dataSource(targetDataSource)
                .sql(sql[1]).beanMapped().assertUpdates(false).build();
    }

    @Bean
    public Step expositionVacationStep(JdbcBatchItemWriter<ExpositionVacationDTO> writerExpositionVacation) {
        String[] sql = generateSql(ExpositionVacationDTO.class, "exposition_vacation");
        String selectSql = sql[0];
        JdbcCursorItemReader<ExpositionVacationDTO> reader = new JdbcCursorItemReaderBuilder<ExpositionVacationDTO>()
                .dataSource(sourceDashboardDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(ExpositionVacationDTO.class)).build();
        return new StepBuilder("expositionVacationStep", jobDatabaseRepository)
                .<ExpositionVacationDTO, ExpositionVacationDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerExpositionVacation).build();
    }

    @Bean
    public JdbcBatchItemWriter<DsAlgoExternalResultsDTO> writerDsAlgoExternalResults() {
        String[] sql = generateSql(DsAlgoExternalResultsDTO.class, "ds_algo_external_results");
        return new JdbcBatchItemWriterBuilder<DsAlgoExternalResultsDTO>().dataSource(targetDataSource)
                .sql(sql[1]).beanMapped().assertUpdates(false).build();
    }

    @Bean
    public Step dsAlgoExternalResultsStep(JdbcBatchItemWriter<DsAlgoExternalResultsDTO> writerDsAlgoExternalResults) {
        String[] sql = generateSql(DsAlgoExternalResultsDTO.class, "ds_algo_external_results");
        String selectSql = sql[0];
        JdbcCursorItemReader<DsAlgoExternalResultsDTO> reader = new JdbcCursorItemReaderBuilder<DsAlgoExternalResultsDTO>()
                .dataSource(sourceDashboardDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(DsAlgoExternalResultsDTO.class)).build();
        return new StepBuilder("dsAlgoExternalResultsStep", jobDatabaseRepository)
                .<DsAlgoExternalResultsDTO, DsAlgoExternalResultsDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerDsAlgoExternalResults).build();
    }

    @Bean
    public Job dailyDatabaseJob(JobRepository jobDatabaseRepository,
                                @Qualifier("connectorParamStep") Step connectorParamStep,
                                @Qualifier("currencyRefStep") Step currencyRefStep,
                                @Qualifier("dsAccountStep") Step dsAccountStep,
                                @Qualifier("dsAccountToRiskStep") Step dsAccountToRiskStep,
                                @Qualifier("dsClientEntityStep") Step dsClientEntityStep,
                                @Qualifier("dsPortfolioStep") Step dsPortfolioStep,
                                @Qualifier("dsPortfolioToRiskStep") Step dsPortfolioToRiskStep,
                                @Qualifier("dsRiskUnitStep") Step dsRiskUnitStep,
                                @Qualifier("expositionVacationStep") Step expositionVacationStep,
                                @Qualifier("dsAlgoExternalResultsStep") Step dsAlgoExternalResultsStep) {
        return new JobBuilder("dailyDatabaseJob", jobDatabaseRepository)
                .listener(jobCompletionListener)
                .start(connectorParamStep).next(currencyRefStep)
                .next(dsAccountStep).next(dsAccountToRiskStep).next(dsClientEntityStep)
                .next(dsPortfolioStep).next(dsPortfolioToRiskStep).next(dsRiskUnitStep)
                .next(expositionVacationStep).next(dsAlgoExternalResultsStep).build();
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
                ") VALUES (" + valueList + ") ON CONFLICT (id) DO NOTHING";
        return new String[]{selectSql, insertSql};
    }
}