package com.zy.blog.oauth.global;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 认证服务重构
 * @author: 小章鱼
 * @date: 2022/6/6 23:40
 **/
@Configuration
public class GlobalExceptionConfig {
    @Bean
    public HandlerExceptionResolver getHandlerExceptionResolver() {
        return new HandlerExceptionResolver();
    }
}
