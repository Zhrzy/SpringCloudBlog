package com.zy.blog.utils.annotion.validator.validator;


import com.zy.blog.utils.annotion.validator.annotion.Numeric;
import com.zy.blog.utils.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description: 判断是否为数字【校验器】
 * @author: 小章鱼
 * @date: 2021/9/29 9:29
 **/
public class NumericValidator implements ConstraintValidator<Numeric, String> {
    @Override
    public void initialize(Numeric constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || StringUtils.isBlank(value)) {
            return false;
        }
        if (!StringUtils.isNumeric(value)) {
            return false;
        }
        return true;
    }
}
