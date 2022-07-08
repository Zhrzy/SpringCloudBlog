package com.zy.blog.web.annotion.requestLimit;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * Request请求次数拦截 自定义注解
 *
 * @author 小章鱼
 * @date 2021年3月6日18:58:12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface RequestLimit {

    /**
     * 允许访问的次数，默认值100
     */
    int amount() default 100;

    /**
     * 时间段，单位为毫秒，默认值一分钟
     */
    long time() default 60000;
}