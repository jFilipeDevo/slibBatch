package com.slib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
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

    public ManualJobController(JobLauncher jobLauncher, Job dailyBatchJob) {
        this.jobLauncher = jobLauncher;
        this.dailyBatchJob = dailyBatchJob;
    }

    /**
     * Endpoint to manually launch the shell script job.
     * This is the manual override the client can use.
     */
    @PostMapping("/runJob")
    public ResponseEntity<String> runJobManually() {
        // Use a unique JobParameter to ensure the job can always be launched (even if it completed successfully before)
        JobParameters params = new JobParametersBuilder()
                .addString("ManualTriggerTime", String.valueOf(System.currentTimeMillis()))
                .addString("Source", "Manual_Client_Override")
                .toJobParameters();

        try {
            // Launch the job using the injected JobLauncher
            jobLauncher.run(dailyBatchJob, params);

            return ResponseEntity.ok("Job launched successfully!");
        } catch (Exception e) {
            // Log the error and return an appropriate HTTP status
            System.err.println("Failed to launch job manually: " + e.getMessage());
            return ResponseEntity.internalServerError().body("Failed to launch job: " + e.getMessage());
        }
    }
}