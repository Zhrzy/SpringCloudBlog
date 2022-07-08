package com.zy.blog.utils.annotion.validator.validator;


import com.zy.blog.utils.annotion.validator.annotion.NotBlank;
import com.zy.blog.utils.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description: 判断是否为空字符串【校验器】
 * @author: 小章鱼
 * @date: 2021/9/29 9:29
 **/
public class StringValidator implements ConstraintValidator<NotBlank, String> {
    @Override
    public void initialize(NotBlank constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || StringUtils.isBlank(value) || StringUtils.isEmpty(value.trim())) {
            return false;
        }
        return true;
    }
}
