package com.zy.blog.utils.annotion.validator.validator;


import com.zy.blog.utils.annotion.validator.annotion.IdValid;
import com.zy.blog.utils.StringUtils;
import com.zy.blog.utils.constant.Constants;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description: ID校验器，主要判断是否为空，并且长度是否为32
 * @author: 小章鱼
 * @date: 2021/9/29 11:22
 **/
public class IdValidator implements ConstraintValidator<IdValid, String> {


    @Override
    public void initialize(IdValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || StringUtils.isBlank(value) || StringUtils.isEmpty(value.trim()) || value.length() != Constants.THIRTY_TWO) {
            return false;
        }
        return true;
    }
}
