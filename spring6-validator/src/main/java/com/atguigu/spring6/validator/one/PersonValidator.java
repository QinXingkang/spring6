package com.atguigu.spring6.validator.one;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

    //校验规则
    @Override
    public void validate(Object target, Errors errors) {
        //判断name不为空
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty","name is null");

        //age不能小于0.不能大于200
        Person p =(Person) target;
        if(p.getAge() < 0 || p.getAge() > 200){
            errors.rejectValue("age", "age.invalid","age must be between 0 and 200");
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }
}
