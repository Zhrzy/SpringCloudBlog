package com.zy.blog.utils.annotion.validator.validator;

import com.zy.blog.utils.annotion.validator.annotion.LongNotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description: 判断Long是否为空【校验器】
 * @author: 小章鱼
 * @date: 2021/9/29 9:29
 **/
public class LongValidator implements ConstraintValidator<LongNotNull, Long> {


    @Override
    public void initialize(LongNotNull constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return true;
    }
}
