package com.zy.blog.admin.config;

import com.zy.blog.admin.filter.UserInfoHandlerInterceptorAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * @author 小章鱼
 * @date 2021年01月2日
 **/


@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private UserInfoHandlerInterceptorAdapter userInfoHandlerInterceptorAdapter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则/**表示拦截所有
        registry.addInterceptor(userInfoHandlerInterceptorAdapter).addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);

    }

   /* @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**").allowedOrigins("*")
                .allowedHeaders("*").allowedMethods("*").allowCredentials(true)
                .maxAge(100000);
        WebMvcConfigurer.super.addCorsMappings(registry);
    }*/
}
