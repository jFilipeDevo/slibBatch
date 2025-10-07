package com.slib;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import java.util.Collections;

@Configuration
public class RetryConfig {
    @Value("${batch.processing.retry-limit}")
    private int retryLimit;

    @Value("${batch.processing.backoff-delay-ms}")
    private long backoffDelay;


    @Bean
    public RetryTemplate retryTemplate() {
        RetryPolicy retryPolicy = new SimpleRetryPolicy(
                retryLimit,
                Collections.singletonMap(Exception.class, true)
        );
        FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
        backOffPolicy.setBackOffPeriod(backoffDelay);
        RetryTemplate retryTemplate = new RetryTemplate();
        retryTemplate.setRetryPolicy(retryPolicy);
        retryTemplate.setBackOffPolicy(backOffPolicy);

        return retryTemplate;
    }
}