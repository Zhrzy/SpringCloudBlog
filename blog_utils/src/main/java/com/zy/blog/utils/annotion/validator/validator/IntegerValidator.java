package com.zy.blog.utils.annotion.validator.validator;


import com.zy.blog.utils.annotion.validator.annotion.IntegerNotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * @description: 判断Integer是否为空【校验器】
 * @author: 小章鱼
 * @date: 2021/9/29 9:29
 **/
public class IntegerValidator implements ConstraintValidator<IntegerNotNull, Integer> {

    @Override
    public void initialize(IntegerNotNull constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return true;
    }
}
