package com.slib.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class ChunkLoggingListener implements ChunkListener {
    private static final Logger log = LoggerFactory.getLogger(ChunkLoggingListener.class);
    private final int chunkSize;
    private int count = 0;

    public ChunkLoggingListener(int chunkSize) {
        this.chunkSize = chunkSize;
    }

    @Override
    public void afterChunk(ChunkContext context) {
        count++;
        long end = context.getStepContext().getStepExecution().getWriteCount();
        long start = count;
        if (count > 1) {
            start = (long) (count - 1) * chunkSize;
            start++;
        }
        if (start == end) {
            log.info("Record {} successfully processed.", start);
        } else{
            log.info("Records from {} to {} successfully processed.", start, end);
        }
    }

    @Override
    public void beforeChunk(ChunkContext context) {}

    @Override
    public void afterChunkError(ChunkContext context) {
        log.error("Error on processing chunk.");
    }
}