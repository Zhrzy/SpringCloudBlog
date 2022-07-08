package com.zy.blog.utils.annotion.validator.annotion;

import com.zy.blog.utils.annotion.validator.Messages;
import com.zy.blog.utils.annotion.validator.validator.BooleanValidator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @description: boolean校验器
 * @author: 小章鱼
 * @date: 2021/9/29 8:26
 **/
@Target({TYPE, ANNOTATION_TYPE, FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {BooleanValidator.class})
public @interface BooleanNotNULL {

    boolean required() default true;

    String message() default Messages.CK_NOT_NULL_DEFAULT;

    String value() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
