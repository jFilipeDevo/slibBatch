package com.slib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailyJobScheduler {
    private static final Logger log = LoggerFactory.getLogger(DailyJobScheduler.class);

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job dailyBatchJob;
    @Autowired
    private Job dailyBatchJobJSON;

    @Scheduled(cron = "${batch.job.cron.bd}")
    public void runDailyJobDatabase() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("timestamp", System.currentTimeMillis()).toJobParameters();
        log.info("Launching database job at {}", new java.util.Date());
        jobLauncher.run(dailyBatchJob, jobParameters);
    }

    @Scheduled(cron = "${batch.job.cron.json}")
    public void runDailyJobJSON() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("timestamp", System.currentTimeMillis()).toJobParameters();
        log.info("Launching JSON job at {}", new java.util.Date());
        jobLauncher.run(dailyBatchJobJSON, jobParameters);
    }
}