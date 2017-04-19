package com.ljf.config;

import com.ljf.service.EnviromentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by happy on 2017/4/19.
 */
@Configuration
@ComponentScan(basePackages = "com.ljf.service")
public class JDBCConfig {
    @Autowired
    private EnviromentService enviromentService;

    @Bean
    public DriverManagerDataSource jdbcDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(enviromentService.getConfig("driverClassName"));
        dataSource.setPassword(enviromentService.getConfig("password"));
        dataSource.setUsername(enviromentService.getConfig("username"));
        return dataSource;
    }
}
