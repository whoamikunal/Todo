package com.demo.todo.config;

import com.zaxxer.hikari.*;
import org.springframework.context.annotation.*;

import javax.sql.*;

@Configuration
public class DataSourceConfig {
    @Bean
    @Profile(com.demo.todo.common.Profile.DEV_PROFILE)
    public DataSource dataSourceConfigurationForLocal() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:h2:mem:testdb");
        config.setUsername("sa");
        config.setPassword("sa");
        config.setDriverClassName("org.h2.Driver");

        return new HikariDataSource(config);
    }
}
