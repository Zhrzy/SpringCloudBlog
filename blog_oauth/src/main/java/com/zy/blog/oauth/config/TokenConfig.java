package com.zy.blog.oauth.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
/*
* TokenStore三种：
*   InMemoryTokenStore：内存中
*   JdbcTokenStore：这是一个基于JDBC的实现版本，令牌会被保存进关系型数据库。
*   JwtTokenStore：这个版本的全称是 JSON Web Token（JWT），它可以把令牌相关的数据进行编码
* */
@Configuration
public class TokenConfig {

    @Bean
    public TokenStore tokenStore(){

        /*TokenStore 这个接口有一个默认的实现，它就是 InMemoryTokenStore*/
        return new InMemoryTokenStore();

    }
}
