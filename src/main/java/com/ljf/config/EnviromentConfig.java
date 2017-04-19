package com.ljf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by happy on 2017/4/19.
 */
@Configuration
@PropertySource("classpath:enviroment.properties")
public class EnviromentConfig {
    @Value("${current.enviroment}")
    private String enviroment;

    @Bean
    public Properties enviromentClient(){
        Properties prop = new Properties();
        InputStream inputStream;
        if(enviroment.equals("dev")){
            inputStream = this.getClass().getResourceAsStream("/enviroment/dev.properties");
        }else {
            inputStream = this.getClass().getResourceAsStream("/enviroment/prod.properties");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        try {
            prop.load(br);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
