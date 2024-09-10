package com.atguigu.spring6.iocxml.dimap;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStu {

    @Test
    public void testStu(){
        ApplicationContext contest = new ClassPathXmlApplicationContext("bean-diref.xml");

        Student student = contest.getBean("studentp", Student.class);
        student.run();

    }
}
