package com.atguigu.spring6.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration //表示本类未配置类
@ComponentScan("com.atguigu.spring6") //开启组件扫描
public class SpringConfig {
}
