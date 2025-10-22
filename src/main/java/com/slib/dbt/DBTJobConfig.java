package com.slib.dbt;

import com.slib.listener.JobCompletionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
public class DBTJobConfig {
    private static final Logger log = LoggerFactory.getLogger(DBTJobConfig.class);
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final JobCompletionListener jobCompletionListener;
    private final RetryTemplate retryTemplate;
    @Value("${batch.job.dbt.url}")
    private String bdtURL;

    public DBTJobConfig(JobRepository jobRepository,
                        PlatformTransactionManager transactionManager,
                        JobCompletionListener jobCompletionListener) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.jobCompletionListener = jobCompletionListener;
        jobCompletionListener.setFileMover(false);
        retryTemplate =  new RetryTemplate();
    }

    @Bean
    public Step dbtBronzeStep() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        List<String> bodies = List.of(
                "dbt snapshot -s kpi_config --vars \"{load_from_date = ' "+now.format(formatter)+"' }\"",
                "dbt run -s currency_ref",
                "dbt run -s ds_account_to_risk",
                "dbt run -s ds_account",
                "dbt run -s connector_param",
                "dbt run -s ds_client_entity",
                "dbt run -s ds_exposition_vacation",
                "dbt run -s ds_portfolio",
                "dbt run -s ds_portfolio_to_risk",
                "dbt run -s ds_risk_unit",
                "dbt run -s ds_super_client",
                "dbt run -s portfolio_mr_ccp"
        );
        return new StepBuilder("dbtBronzeStep", jobRepository)
                .tasklet(dbtTasklet(bodies), transactionManager).build();
    }

    @Bean
    public Job dailyJobDBTBronze(@Qualifier("dbtBronzeStep")  Step dbtBronzeStep) {
        return new JobBuilder("dailyJobDBTBronzeJob", jobRepository)
                .listener(jobCompletionListener)
                .start(dbtBronzeStep).build();
    }

    @Bean
    public Step dbtSilverStep() {
        List<String> bodies = List.of(
                " dbt run -s slv_dim_client",
                "dbt run -s slv_dim_currency",
                "dbt run -s slv_dim_portfolio",
                "dbt run -s slv_dim_portfolio_risk_unit",
                "dbt run -s slv_dim_risk_unit",
                "dbt run -s slv_fct_portfolio_margin_eod_ccp",
                "dbt run -s slv_fct_portfolio_margin_eod_rms",
                "dbt run -s slv_fct_portfolio_margin_eod",
                "dbt run -s slv_param_alert_config",
                "dbt run -s slv_kpi_04_mr_discrepancy",
                "dbt run -s slv_kpi_05_mr_rollingavg",
                "dbt run -s slv_kpi_06_mr_rollingavg_py",
                "dbt run -s slv_kpi_09_mr_observ_exceed",
                "dbt run -s slv_kpi_10_mr_zscore",
                "dbt run -s slv_fct_portfolio_alert_events",
                "dbt run -s slv_dim_ccp"
        );
        return new StepBuilder("dbtSilverStep", jobRepository)
                .tasklet(dbtTasklet(bodies), transactionManager).build();
    }

    @Bean
    public Job dailyJobDBTSilver(@Qualifier("dbtSilverStep") Step dbtSilverStep) {
        return new JobBuilder("dailyJobDBTSilverJob", jobRepository)
                .listener(jobCompletionListener)
                .start(dbtSilverStep).build();
    }

    @Bean
    public Step dbtGoldStep() {
        List<String> bodies = List.of(
                "dbt run -s gld_dim_client",
                "dbt run -s gld_dim_currency",
                "dbt run -s gld_dim_portfolio",
                "dbt run -s gld_dim_portfolio_risk_unit",
                "dbt run -s gld_dim_risk_unit",
                "dbt run -s gld_fct_portfolio_margin_eod",
                "dbt run -s gld_fct_portfolio_margin_eod_ccp",
                "dbt run -s gld_dim_ccp",
                "dbt run -s gld_fct_portfolio_alert_events"
        );
        return new StepBuilder("dbtGoldStep", jobRepository)
                .tasklet(dbtTasklet(bodies), transactionManager).build();
    }

    @Bean
    public Job dailyJobDBTGold(@Qualifier("dbtGoldStep") Step dbtGoldStep) {
        return new JobBuilder("dailyJobDBTGoldJob", jobRepository)
                .listener(jobCompletionListener)
                .start(dbtGoldStep).build();
    }

    private Tasklet dbtTasklet(List<String>  bodies) {
        return (contribution, chunkContext) -> {
            RestTemplate restTemplate = new RestTemplate();
            for (String body : bodies) {
                log.info("Calling DBT: {}", bdtURL);
                retryTemplate.execute(context -> {
                    ResponseEntity<String> response = null;
                    try {
                        response = restTemplate.postForEntity(bdtURL, body, String.class);
                        log.info("Calling DBT successfully: {}", response);
                    } catch (Exception e) {
                        log.error("DBT call failed: {}", e.getMessage(), e);
                        throw e;
                    }
                    return null;
                });
            }
            return RepeatStatus.FINISHED;
        };
    }
}