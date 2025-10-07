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

        // 2. Define the Backoff Policy (the delay between retries)
        // Here, we use a fixed delay based on the injected property
        FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
        backOffPolicy.setBackOffPeriod(backoffDelay); // Set the delay in milliseconds

        // 3. Assemble the RetryTemplate
        RetryTemplate retryTemplate = new RetryTemplate();
        retryTemplate.setRetryPolicy(retryPolicy);
        retryTemplate.setBackOffPolicy(backOffPolicy);

        return retryTemplate;
    }
}