package com.atguigu.spring6.autowired.controller;


import com.atguigu.spring6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    //注入service
    //第一种方式 属性注入
//    @Autowired //autowired注解会根据类型找到对应的对象，完成注入
//    private UserService userService;

    //第二种方式 set方法注入
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    //第三种方式 构造器注入
//    private UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    //第四种方式 形参上注入
    private UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    //第五种方式 只有一个有参数构造器，可以省略注解
//    private UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    //第六种方式 使用两个注解，根据名称进行注入
//    @Autowired
//    @Qualifier(value = "UserService")
//    private UserService userService;

    public void add(){
        System.out.println("controller");
        userService.add();
    }

}
