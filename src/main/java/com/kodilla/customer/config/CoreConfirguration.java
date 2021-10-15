package com.kodilla.customer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class CoreConfirguration {


    @Value("${customer.datasource.driverClassName}")
    private String driver;

    @Value("${customer.datasource.url}")
    private String url;

    @Value("${customer.datasource.username}")
    private String username;

    @Value("${customer.datasource.password}")
    private String password;

    @Bean
    public DataSource getDataSource() {

        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();

    }
}
