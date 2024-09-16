package com.atguigu.spring6.validator.one;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

//校验测试
public class TestPerson {

    public static void main(String[] args) {
        //创建person对象
        Person person = new Person();
        person.setAge(300);
        person.setName("lucy");

        //创建person对应dataBinder
        DataBinder dataBinder = new DataBinder(person);

        //设置校验器
        dataBinder.setValidator(new PersonValidator());

        //调用方法执行校验
        dataBinder.validate();

        //输出校验结果
        BindingResult result = dataBinder.getBindingResult();
        System.out.println(result.getAllErrors());
    }
}
