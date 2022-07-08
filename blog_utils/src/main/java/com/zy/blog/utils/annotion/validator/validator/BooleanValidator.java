package com.zy.blog.utils.annotion.validator.validator;

import com.zy.blog.utils.annotion.validator.annotion.BooleanNotNULL;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * @description: 判断Boolean类型是否为空【校验器】
 * @author: 小章鱼
 * @date: 2021/9/29 11:21
 **/
public class BooleanValidator implements ConstraintValidator<BooleanNotNULL, Boolean> {

    @Override
    public void initialize(BooleanNotNULL constraintAnnotation) {

    }

    @Override
    public boolean isValid(Boolean value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return true;
    }
}
