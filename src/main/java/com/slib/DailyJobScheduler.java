package com.slib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailyJobScheduler {
    private static final Logger log = LoggerFactory.getLogger(DailyJobScheduler.class);
    private final JobLauncher jobLauncher;
    private final Job dailyDatabaseJob;
    private final Job dailyJSONJob;
    private final Job dailyJobDBTBronze;
    private final Job dailyJobDBTSilver;
    private final Job dailyJobDBTGold;


    public DailyJobScheduler(JobLauncher jobLauncher,
                               @Qualifier("dailyDatabaseJob") Job dailyDatabaseJob,
                               @Qualifier("dailyJSONJob") Job dailyJSONJob,
                               @Qualifier("dailyJobDBTBronze") Job dailyJobDBTBronze,
                               @Qualifier("dailyJobDBTSilver") Job dailyJobDBTSilver,
                               @Qualifier("dailyJobDBTGold") Job dailyJobDBTGold) {
        this.jobLauncher = jobLauncher;
        this.dailyDatabaseJob = dailyDatabaseJob;
        this.dailyJSONJob = dailyJSONJob;
        this.dailyJobDBTBronze = dailyJobDBTBronze;
        this.dailyJobDBTSilver = dailyJobDBTSilver;
        this.dailyJobDBTGold = dailyJobDBTGold;
    }

    @Scheduled(cron = "${batch.job.cron.bd}")
    public void runDailyJobDatabase() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("timestamp", System.currentTimeMillis()).toJobParameters();
        log.info("Launching database job at {}", new java.util.Date());
        jobLauncher.run(dailyDatabaseJob, jobParameters);
    }

    @Scheduled(cron = "${batch.job.cron.json}")
    public void runDailyJobJSON() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("timestamp", System.currentTimeMillis()).toJobParameters();
        log.info("Launching JSON job at {}", new java.util.Date());
        jobLauncher.run(dailyJSONJob, jobParameters);
    }

    @Scheduled(cron = "${batch.job.cron.dbt.bronze}")
    public void runDailyJobDBTBronze() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("timestamp", System.currentTimeMillis()).toJobParameters();
        log.info("Launching dbt bronze job at {}", new java.util.Date());
        jobLauncher.run(dailyJobDBTBronze, jobParameters);
    }

    @Scheduled(cron = "${batch.job.cron.dbt.silver}")
    public void runDailyJobDBTSilver() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("timestamp", System.currentTimeMillis()).toJobParameters();
        log.info("Launching dbt silver job at {}", new java.util.Date());
        jobLauncher.run(dailyJobDBTSilver, jobParameters);
    }

    @Scheduled(cron = "${batch.job.cron.dbt.gold}")
    public void runDailyJobDBTGold() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("timestamp", System.currentTimeMillis()).toJobParameters();
        log.info("Launching dbt gold job at {}", new java.util.Date());
        jobLauncher.run(dailyJobDBTGold, jobParameters);
    }
}