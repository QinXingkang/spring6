package com.atguigu.spring6.validator.four;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Validation;

public class CannotBlankValidation implements ConstraintValidator<CannotBlank, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value != null && value.contains(" ")){

            return false;
        }
        return false;
    }
}

