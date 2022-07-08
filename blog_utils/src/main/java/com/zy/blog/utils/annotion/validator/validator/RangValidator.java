package com.zy.blog.utils.annotion.validator.validator;


import com.zy.blog.utils.annotion.validator.annotion.Range;
import com.zy.blog.utils.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * @description: 判符串范围约束，限制长度【校验器】
 * @author: 小章鱼
 * @date: 2021/9/29 9:29
 **/
public class RangValidator implements ConstraintValidator<Range, String> {
    private long min;
    private long max;

    @Override
    public void initialize(Range constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (null == value || StringUtils.isBlank(value)) {
            return min == 0;
        }
        return value.length() >= min && value.length() <= max;
    }
}
