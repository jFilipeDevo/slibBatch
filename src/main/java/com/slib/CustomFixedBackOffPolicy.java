package com.slib;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.FixedBackOffPolicy;

@Configuration
public class CustomFixedBackOffPolicy extends FixedBackOffPolicy {

    @Value("${batch.processing.backoff-delay-ms}")
    private long backoffDelay;

    public CustomFixedBackOffPolicy(){
        super.setBackOffPeriod(backoffDelay);
    }
}