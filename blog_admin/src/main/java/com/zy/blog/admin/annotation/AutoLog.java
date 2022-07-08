package com.zy.blog.admin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 日志记录注解
 * @author 小章鱼
 * @date 2020年12月31日
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoLog {

    /**
    * 是否记录耗时
    * */
    boolean recordTime() default false;
}
