package com.atguigu.dao.impl;

import com.atguigu.annotation.Bean;
import com.atguigu.dao.UserDao;
import org.springframework.stereotype.Repository;

@Bean
public class UserDaoImpl implements UserDao {

    public void add(){
        System.out.println("dao add()");
    }
}
