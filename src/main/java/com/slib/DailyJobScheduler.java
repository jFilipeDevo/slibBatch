package com.slib;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailyJobScheduler {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job dailyBatchJob;

    @Scheduled(cron = "${batch.job.schedule.cron}")
    public void runDailyJob() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("timestamp", System.currentTimeMillis())
                .toJobParameters();
        System.out.println("Launching Spring Batch Job 1: dailyBatchJob at " + new java.util.Date());
        jobLauncher.run(dailyBatchJob, jobParameters);
    }
}