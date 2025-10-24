package com.mds.poc.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class MysqlDatasourceConfig {

    @ConfigurationProperties("spring.datasource.mysql")
    @Bean
    public DataSourceProperties mysqlDatasouceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource mysqlDatasource() {
        return  mysqlDatasouceProperties().initializeDataSourceBuilder().build();
    }

//    Manual way
//    @Bean
//    public DataSource mysqlDatasource() {
//        DriverManagerDataSource datasource = new DriverManagerDataSource();
//        datasource.setUsername(mysqlDatasouceProperties().getUsername());
//        datasource.setPassword(mysqlDatasouceProperties().getPassword());
//        datasource.setUrl(mysqlDatasouceProperties().getUrl());
//        datasource.setDriverClassName(mysqlDatasouceProperties().getDriverClassName());
//        return  datasource;
//    }
}
