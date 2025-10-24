package com.slib;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource h2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sourceCoreDataSource")
    @ConfigurationProperties(prefix = "source.core.datasource")
    public DataSource sourceCoreDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sourceDashboardDataSource")
    @ConfigurationProperties(prefix = "source.dashboard.datasource")
    public DataSource sourceDashboardDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "targetDataSource")
    @ConfigurationProperties(prefix = "target.datasource")
    public DataSource targetDataSource() {
        return DataSourceBuilder.create().build();
    }
}
