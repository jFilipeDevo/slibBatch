package com.slib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/batch")
public class ManualJobController {
    private static final Logger log = LoggerFactory.getLogger(ManualJobController.class);

    private final JobLauncher jobLauncher;
    private final Job dailyBatchJob;
    private final Job dailyBatchJobJSON;

    public ManualJobController(JobLauncher jobLauncher,
                               @Qualifier("dailyBatchJob") Job dailyBatchJob,
                               @Qualifier("dailyBatchJobJSON") Job dailyBatchJobJSON) {
        this.jobLauncher = jobLauncher;
        this.dailyBatchJob = dailyBatchJob;
        this.dailyBatchJobJSON = dailyBatchJobJSON;
    }

    /**
     * Endpoint to manually launch the shell script job.
     * This is the manual override the client can use.
     */
    @PostMapping("/runJobDatabase")
    public ResponseEntity<String> runJobManually() {
        JobParameters params = new JobParametersBuilder()
                .addString("ManualTriggerTime", String.valueOf(System.currentTimeMillis()))
                .addString("Source", "Manual_Client_Override").toJobParameters();
        try {
            jobLauncher.run(dailyBatchJob, params);
            return ResponseEntity.ok("Job launched successfully!");
        } catch (Exception e) {
            log.error("Failed to launch job manually: {}", e.getMessage());
            return ResponseEntity.internalServerError().body("Failed to launch job: " + e.getMessage());
        }
    }

    @PostMapping("/runJobJSON")
    public ResponseEntity<String> runJobManuallyJSON() {
        JobParameters params = new JobParametersBuilder()
                .addString("ManualTriggerTime", String.valueOf(System.currentTimeMillis()))
                .addString("Source", "Manual_Client_Override").toJobParameters();
        try {
            jobLauncher.run(dailyBatchJobJSON, params);
            return ResponseEntity.ok("Job launched successfully!");
        } catch (Exception e) {
            log.error("Failed to launch job manually: {}", e.getMessage());
            return ResponseEntity.internalServerError().body("Failed to launch job: " + e.getMessage());
        }
    }
}