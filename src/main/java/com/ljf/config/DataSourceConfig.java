package com.ljf.config;

import com.ljf.service.EnviromentService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.beans.PropertyVetoException;

/**
 * Created by happy on 2017/4/19.
 * 配置数据源
 */
@Configuration
@ComponentScan(basePackages = "com.ljf")
public class DataSourceConfig {
    @Autowired
    private EnviromentService enviromentService;

    /**
     * jdbc连接池
     * @return
     */
    /*@Bean(name = "dataSource")
    public DriverManagerDataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(enviromentService.getConfig("driverClassName"));
        dataSource.setUrl(enviromentService.getConfig("url"));
        dataSource.setPassword(enviromentService.getConfig("password"));
        dataSource.setUsername(enviromentService.getConfig("username"));
        return dataSource;
    }*/

    /**
     * dbcp连接池
     * @return
     */
    /*@Bean("dataSourceByDBCP")
    public BasicDataSource dbcpDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(enviromentService.getConfig("driverClassName"));
        dataSource.setUrl(enviromentService.getConfig("url"));
        dataSource.setPassword(enviromentService.getConfig("password"));
        dataSource.setUsername(enviromentService.getConfig("username"));
        dataSource.setMaxIdle(50);
        dataSource.setMinIdle(10);
        return dataSource;
    }*/

    /**
     * c3p0比dbcp更为灵活
     * @return
     */
    @Bean(name="dataSourceByC3P0",destroyMethod = "close")
    public ComboPooledDataSource c3p0DataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(enviromentService.getConfig("driverClassName"));
            dataSource.setJdbcUrl(enviromentService.getConfig("url"));
            dataSource.setPassword(enviromentService.getConfig("password"));
            dataSource.setUser(enviromentService.getConfig("username"));
            dataSource.setMaxPoolSize(50);
            dataSource.setMinPoolSize(10);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
