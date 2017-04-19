package com.ljf.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by happy on 2017/4/19.
 */
@RestController
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping
    public String home(){
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleController.class,args);
    }
}
