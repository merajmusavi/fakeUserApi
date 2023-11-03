package com.example.demo.database;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataBase {
    @Bean
    @ConfigurationProperties("app.database")
public HikariDataSource dataSource(){
    return DataSourceBuilder
            .create()
            .type(HikariDataSource.class)
            .build();
}
}
