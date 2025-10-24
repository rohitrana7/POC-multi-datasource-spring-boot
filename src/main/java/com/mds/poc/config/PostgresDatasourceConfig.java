package com.mds.poc.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class PostgresDatasourceConfig {

    @ConfigurationProperties("spring.datasource.pg")
    @Bean
    public DataSourceProperties pgDatasourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource pgDatasource() {
        return  pgDatasourceProperties().initializeDataSourceBuilder().build();
    }

//    Manual way
//    @Bean
//    public DataSource pgDatasource() {
//        DriverManagerDataSource datasource = new DriverManagerDataSource();
//        datasource.setUsername(pgDatasourceProperties().getUsername());
//        datasource.setPassword(pgDatasourceProperties().getPassword());
//        datasource.setUrl(pgDatasourceProperties().getUrl());
//        datasource.setDriverClassName(pgDatasourceProperties().getDriverClassName());
//        return  datasource;
//    }
}
