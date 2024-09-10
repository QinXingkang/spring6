package com.atguigu.spring6.iocxml.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {

    //set方法注入测试
    @Test
    public void testSet(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beandi.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    //构造器注入
    @Test
    public void testConstructor(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beandi.xml");
        Book book = context.getBean("bookConstructor", Book.class);
        System.out.println(book);
    }
}
