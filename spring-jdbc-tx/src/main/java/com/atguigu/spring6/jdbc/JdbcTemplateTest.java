package com.atguigu.spring6.jdbc;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate(){
        //1 添加操作
        //第一步 编写sql语句
        String sql = "insert into t_emp values(NULL,?,?,?)";

        //第二步 调用jdbcTemplate的方法，传入相关参数
        int update = jdbcTemplate.update(sql,"东方不败",20,"女");
        System.out.println(update);

    }
}
