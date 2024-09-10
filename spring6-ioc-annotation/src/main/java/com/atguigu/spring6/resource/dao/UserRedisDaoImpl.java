package com.atguigu.spring6.resource.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "myUserRedisDao")
public class UserRedisDaoImpl implements UserDao {

    public void add(){
        System.out.println("dao redis");
    }
}
