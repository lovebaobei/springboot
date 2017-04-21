package com.ljf.controller;

import com.ljf.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by happy on 2017/4/20.
 */
@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String sayHello(String name, ModelMap modelMap){
        modelMap.put("name",helloService.hello(name));
        return "index";
    }

    @RequestMapping("/find")
    @ResponseBody
    public String find(){
        List<Map<String, Object>> users = helloService.find();
        System.out.println(users);
        return "index";
    }
}
