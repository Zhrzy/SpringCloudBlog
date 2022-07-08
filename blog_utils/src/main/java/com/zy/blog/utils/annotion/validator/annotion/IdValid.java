package com.zy.blog.utils.annotion.validator.annotion;

import com.zy.blog.utils.annotion.validator.Messages;
import com.zy.blog.utils.annotion.validator.validator.IdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @description: id校验器
 * @author: 小章鱼
 * @date: 2021/9/29 8:27
 **/
@Target({TYPE, ANNOTATION_TYPE, FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IdValidator.class})
public @interface IdValid {

    boolean required() default true;

    String message() default Messages.ID_LENGTH_THIRTY_TWO;

    String value() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}