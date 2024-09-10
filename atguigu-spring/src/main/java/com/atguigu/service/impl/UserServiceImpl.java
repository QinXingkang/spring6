package com.atguigu.service.impl;

import com.atguigu.annotation.Bean;
import com.atguigu.annotation.Di;
import com.atguigu.dao.UserDao;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Bean
public class UserServiceImpl implements UserService {

    @Di
    private UserDao userDao;

    public void add(){
        System.out.println("service add()");
        userDao.add();
        //调用dao的方法
    }

}
