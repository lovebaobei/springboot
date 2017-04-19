package com.ljf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * Created by happy on 2017/4/19.
 */
@Service
public class EnviromentService {
    @Autowired
    @Qualifier("enviromentClient")
    private Properties properties;

    public String getConfig(String key){
        return properties.getProperty(key);
    }
}
