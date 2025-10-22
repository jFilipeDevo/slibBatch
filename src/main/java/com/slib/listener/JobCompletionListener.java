package com.slib.listener;

import com.slib.FileMover;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JobCompletionListener implements JobExecutionListener {
    private static final Logger log = LoggerFactory.getLogger(JobCompletionListener.class);
    @Value("${batch.job.json.success.dir}")
    private String successDir;
    @Value("${batch.job.json.failure.dir}")
    private String failureDir;
    private final Resource inputResource;
    private ChunkLoggingListener chunkLoggingListener;
    private boolean fileMover = false;

    public JobCompletionListener(@Value("${batch.job.json.file}") Resource inputResource) {
        this.inputResource = inputResource;
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Job {} started. Status: {}", jobExecution.getJobInstance().getJobName(), jobExecution.getStatus());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        try {
            BatchStatus status = jobExecution.getStatus();
            chunkLoggingListener.setCount(0);
            if (status == BatchStatus.COMPLETED) {
                log.info("Job {} ended successfully. Status: {}. Total written records: {}",
                        jobExecution.getJobInstance().getJobName(),
                        jobExecution.getStatus(), jobExecution.getStepExecutions().stream()
                                .mapToInt(e -> Math.toIntExact(e.getWriteCount()))
                                .sum());
                if (fileMover) {
                    FileMover.move(inputResource, successDir);
                    log.info("Json file moved successfully to: {}", successDir);
                }
            } else if (status.isUnsuccessful()) {
                log.error("Job {} ended with error. Status: {}. Total written records: {}",
                        jobExecution.getJobInstance().getJobName(),
                        jobExecution.getStatus(), jobExecution.getStepExecutions().stream()
                                .mapToInt(e -> Math.toIntExact(e.getWriteCount()))
                                .sum());
                if (fileMover) {
                    FileMover.move(inputResource, failureDir);
                    log.error("Job Fail! Json file moved successfully to: {}", failureDir);
                }
            }
        } catch (IOException e) {
            log.error("Cannot move json to archive directory: {}. Trace: {}",
                    inputResource.getFilename(), e.getMessage(), e);
        }
    }

    public void setFileMover(boolean fileMover) {
        this.fileMover = fileMover;
    }

    public void setChunkLoggingListener(ChunkLoggingListener chunkLoggingListener) {
        this.chunkLoggingListener = chunkLoggingListener;
    }

    public ChunkLoggingListener getChunkLoggingListener() {
        return chunkLoggingListener;
    }
}