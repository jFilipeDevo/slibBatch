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
    private final DataSource sourceDataSource;
    private final DataSource targetDataSource;
    private final JobRepository jobDatabaseRepository;
    private final PlatformTransactionManager transactionManager;
    private final JobCompletionListener jobCompletionListener;
    @Value("${batch.processing.retry-limit}")
    private int retryLimit;

    // Restoring explicit injection via constructor
    public DatabaseJobConfig(
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
    public JdbcBatchItemWriter<AccountDTO> writerAccount() {
        String[] sql = generateSql(AccountDTO.class, "account");
        String insertSql = sql[1];
        return new JdbcBatchItemWriterBuilder<AccountDTO>().dataSource(targetDataSource)
                .sql(insertSql).beanMapped().assertUpdates(false).build();
    }

    @Bean
    public Step accountStep(JdbcBatchItemWriter<AccountDTO> writerAccount) {
        String[] sql = generateSql(AccountDTO.class, "account");
        String selectSql = sql[0];
        JdbcCursorItemReader<AccountDTO> reader = new JdbcCursorItemReaderBuilder<AccountDTO>()
                .dataSource(sourceDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(AccountDTO.class)).build();
        return new StepBuilder("accountStep", jobDatabaseRepository)
                .<AccountDTO, AccountDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerAccount).build();
    }

    @Bean
    public JdbcBatchItemWriter<ClientEntityDTO> writerClientEntity() {
        String[] sql = generateSql(ClientEntityDTO.class, "client_entity");
        return new JdbcBatchItemWriterBuilder<ClientEntityDTO>().dataSource(targetDataSource)
                .sql(sql[1]).beanMapped().assertUpdates(false).build();
    }

    @Bean
    public Step clientEntityStep(JdbcBatchItemWriter<ClientEntityDTO> writerClientEntity) {
        String[] sql = generateSql(ClientEntityDTO.class, "client_entity");
        String selectSql = sql[0];
        JdbcCursorItemReader<ClientEntityDTO> reader = new JdbcCursorItemReaderBuilder<ClientEntityDTO>()
                .dataSource(sourceDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(ClientEntityDTO.class)).build();
        return new StepBuilder("clientEntityStep", jobDatabaseRepository)
                .<ClientEntityDTO, ClientEntityDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerClientEntity).build();
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
                .dataSource(sourceDataSource).name("jdbcReader")
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
                .dataSource(sourceDataSource).name("jdbcReader")
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
                .dataSource(sourceDataSource).name("jdbcReader")
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
                .dataSource(sourceDataSource).name("jdbcReader")
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
                .dataSource(sourceDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(DsClientEntityDTO.class)).build();
        return new StepBuilder("dsClientEntityStep", jobDatabaseRepository)
                .<DsClientEntityDTO, DsClientEntityDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerDsClientEntity).build();
    }

    @Bean
    public JdbcBatchItemWriter<DsExpositionVacationDTO> writerDsExpositionVacation() {
        String[] sql = generateSql(DsExpositionVacationDTO.class, "ds_exposition_vacation");
        return new JdbcBatchItemWriterBuilder<DsExpositionVacationDTO>().dataSource(targetDataSource)
                .sql(sql[1]).beanMapped().assertUpdates(false).build();
    }

    @Bean
    public Step dsExpositionVacationStep(JdbcBatchItemWriter<DsExpositionVacationDTO> writerDsExpositionVacation) {
        String[] sql = generateSql(DsExpositionVacationDTO.class, "ds_exposition_vacation");
        String selectSql = sql[0];
        JdbcCursorItemReader<DsExpositionVacationDTO> reader = new JdbcCursorItemReaderBuilder<DsExpositionVacationDTO>()
                .dataSource(sourceDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(DsExpositionVacationDTO.class)).build();
        return new StepBuilder("dsExpositionVacationStep", jobDatabaseRepository)
                .<DsExpositionVacationDTO, DsExpositionVacationDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerDsExpositionVacation).build();
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
                .dataSource(sourceDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(DsPortfolioDTO.class)).build();
        return new StepBuilder("dsPortfolioStep", jobDatabaseRepository)
                .<DsPortfolioDTO, DsPortfolioDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerDsPortfolio).build();
    }

    @Bean
    public JdbcBatchItemWriter<DsPortfolioMrCcpDTO> writerDsPortfolioMrCcp() {
        String[] sql = generateSql(DsPortfolioMrCcpDTO.class, "ds_portfolio_mr_ccp");
        return new JdbcBatchItemWriterBuilder<DsPortfolioMrCcpDTO>().dataSource(targetDataSource)
                .sql(sql[1]).beanMapped().assertUpdates(false).build();
    }

    @Bean
    public Step dsPortfolioMrCcpStep(JdbcBatchItemWriter<DsPortfolioMrCcpDTO> writerDsPortfolioMrCcp) {
        String[] sql = generateSql(DsPortfolioMrCcpDTO.class, "ds_portfolio_mr_ccp");
        String selectSql = sql[0];
        JdbcCursorItemReader<DsPortfolioMrCcpDTO> reader = new JdbcCursorItemReaderBuilder<DsPortfolioMrCcpDTO>()
                .dataSource(sourceDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(DsPortfolioMrCcpDTO.class)).build();
        return new StepBuilder("dsPortfolioMrCcpStep", jobDatabaseRepository)
                .<DsPortfolioMrCcpDTO, DsPortfolioMrCcpDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerDsPortfolioMrCcp).build();
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
                .dataSource(sourceDataSource).name("jdbcReader")
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
                .dataSource(sourceDataSource).name("jdbcReader")
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
                .dataSource(sourceDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(ExpositionVacationDTO.class)).build();
        return new StepBuilder("expositionVacationStep", jobDatabaseRepository)
                .<ExpositionVacationDTO, ExpositionVacationDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerExpositionVacation).build();
    }

    @Bean
    public JdbcBatchItemWriter<PortfolioDTO> writerPortfolio() {
        String[] sql = generateSql(PortfolioDTO.class, "portfolio");
        return new JdbcBatchItemWriterBuilder<PortfolioDTO>().dataSource(targetDataSource)
                .sql(sql[1]).beanMapped().assertUpdates(false).build();
    }

    @Bean
    public Step portfolioStep(JdbcBatchItemWriter<PortfolioDTO> writerPortfolio) {
        String[] sql = generateSql(PortfolioDTO.class, "portfolio");
        String selectSql = sql[0];
        JdbcCursorItemReader<PortfolioDTO> reader = new JdbcCursorItemReaderBuilder<PortfolioDTO>()
                .dataSource(sourceDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(PortfolioDTO.class)).build();
        return new StepBuilder("portfolioStep", jobDatabaseRepository)
                .<PortfolioDTO, PortfolioDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerPortfolio).build();
    }

    @Bean
    public JdbcBatchItemWriter<PortfolioToRiskDTO> writerPortfolioToRisk() {
        String[] sql = generateSql(PortfolioToRiskDTO.class, "portfolio_to_risk");
        return new JdbcBatchItemWriterBuilder<PortfolioToRiskDTO>().dataSource(targetDataSource)
                .sql(sql[1]).beanMapped().assertUpdates(false).build();
    }

    @Bean
    public Step portfolioToRiskStep(JdbcBatchItemWriter<PortfolioToRiskDTO> writerPortfolioToRisk) {
        String[] sql = generateSql(PortfolioToRiskDTO.class, "portfolio_to_risk");
        String selectSql = sql[0];
        JdbcCursorItemReader<PortfolioToRiskDTO> reader = new JdbcCursorItemReaderBuilder<PortfolioToRiskDTO>()
                .dataSource(sourceDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(PortfolioToRiskDTO.class)).build();
        return new StepBuilder("portfolioToRiskStep", jobDatabaseRepository)
                .<PortfolioToRiskDTO, PortfolioToRiskDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerPortfolioToRisk).build();
    }

    @Bean
    public JdbcBatchItemWriter<RiskUnitDTO> writerRiskUnit() {
        String[] sql = generateSql(RiskUnitDTO.class, "risk_unit");
        return new JdbcBatchItemWriterBuilder<RiskUnitDTO>().dataSource(targetDataSource)
                .sql(sql[1]).beanMapped().assertUpdates(false).build();
    }

    @Bean
    public Step riskUnitStep(JdbcBatchItemWriter<RiskUnitDTO> writerRiskUnit) {
        String[] sql = generateSql(RiskUnitDTO.class, "risk_unit");
        String selectSql = sql[0];
        JdbcCursorItemReader<RiskUnitDTO> reader = new JdbcCursorItemReaderBuilder<RiskUnitDTO>()
                .dataSource(sourceDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(RiskUnitDTO.class)).build();
        return new StepBuilder("riskUnitStep", jobDatabaseRepository)
                .<RiskUnitDTO, RiskUnitDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerRiskUnit).build();
    }

    @Bean
    public JdbcBatchItemWriter<SuperClientDTO> writerSuperClient() {
        String[] sql = generateSql(SuperClientDTO.class, "super_client");
        return new JdbcBatchItemWriterBuilder<SuperClientDTO>().dataSource(targetDataSource)
                .sql(sql[1]).beanMapped().assertUpdates(false).build();
    }

    @Bean
    public Step superClientStep(JdbcBatchItemWriter<SuperClientDTO> writerSuperClient) {
        String[] sql = generateSql(SuperClientDTO.class, "super_client");
        String selectSql = sql[0];
        JdbcCursorItemReader<SuperClientDTO> reader = new JdbcCursorItemReaderBuilder<SuperClientDTO>()
                .dataSource(sourceDataSource).name("jdbcReader")
                .sql(selectSql).rowMapper(new BeanPropertyRowMapper<>(SuperClientDTO.class)).build();
        return new StepBuilder("superClientStep", jobDatabaseRepository)
                .<SuperClientDTO, SuperClientDTO>chunk(CHUNK_SIZE, transactionManager)
                .faultTolerant().retryLimit(retryLimit)
                .backOffPolicy(new CustomFixedBackOffPolicy()).retry(Exception.class)
                .listener(new ChunkLoggingListener(CHUNK_SIZE))
                .reader(reader).writer(writerSuperClient).build();
    }

    @Bean
    public Job dailyDatabaseJob(JobRepository jobDatabaseRepository,
                                @Qualifier("accountStep") Step accountStep,
                                @Qualifier("clientEntityStep") Step clientEntityStep,
                                @Qualifier("connectorParamStep") Step connectorParamStep,
                                @Qualifier("currencyRefStep") Step currencyRefStep,
                                @Qualifier("dsAccountStep") Step dsAccountStep,
                                @Qualifier("dsAccountToRiskStep") Step dsAccountToRiskStep,
                                @Qualifier("dsClientEntityStep") Step dsClientEntityStep,
                                @Qualifier("dsExpositionVacationStep") Step dsExpositionVacationStep,
                                @Qualifier("dsPortfolioStep") Step dsPortfolioStep,
                                @Qualifier("dsPortfolioMrCcpStep") Step dsPortfolioMrCcpStep,
                                @Qualifier("dsPortfolioToRiskStep") Step dsPortfolioToRiskStep,
                                @Qualifier("dsRiskUnitStep") Step dsRiskUnitStep,
                                @Qualifier("expositionVacationStep") Step expositionVacationStep,
                                @Qualifier("portfolioStep") Step portfolioStep,
                                @Qualifier("portfolioToRiskStep") Step portfolioToRiskStep,
                                @Qualifier("riskUnitStep") Step riskUnitStep,
                                @Qualifier("superClientStep") Step superClientStep) {
        return new JobBuilder("dailyDatabaseJob", jobDatabaseRepository)
                .listener(jobCompletionListener)
                .start(accountStep).next(clientEntityStep).next(connectorParamStep).next(currencyRefStep)
                .next(dsAccountStep).next(dsAccountToRiskStep).next(dsClientEntityStep).next(dsExpositionVacationStep)
                .next(dsPortfolioStep).next(dsPortfolioMrCcpStep).next(dsPortfolioToRiskStep).next(dsRiskUnitStep)
                .next(expositionVacationStep).next(portfolioStep).next(portfolioToRiskStep)
                .next(riskUnitStep).next(superClientStep).build();
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