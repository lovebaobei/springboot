package com.ljf.service;

import com.ljf.bean.User;
import com.ljf.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by happy on 2017/4/20.
 */
@Service
public class HelloService {
    @Autowired
    private UserDao userDao;

    public String hello(String name){
        return "hello:" + name;
    }

    public List<Map<String, Object>> find(){
        List<Map<String, Object>> users = userDao.findAll();
        return users;
    }
}
