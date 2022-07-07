package com.zy.blog.oauth.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.*;

import java.security.KeyPair;

/*
* TokenStore三种：
*   InMemoryTokenStore：内存中
*   JdbcTokenStore：这是一个基于JDBC的实现版本，令牌会被保存进关系型数据库。
*   JwtTokenStore：这个版本的全称是 JSON Web Token（JWT），它可以把令牌相关的数据进行编码
* */
@Configuration
public class TokenConfig {

    private String SIGNING_KEY = "oauthTokenKey";
    @Bean
    public TokenStore tokenStore(){
        /*方式1：TokenStore 这个接口有一个默认的实现，它就是 InMemoryTokenStore*/
        //return new InMemoryTokenStore();
        /*方式2*/
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenEnhancer();
        //converter.setSigningKey(SIGNING_KEY); //对称秘钥，资源服务器使用该秘钥来验证
        converter.setKeyPair(keyPair());
        return  converter;
    }

    /**
     * 从classpath下的密钥库中获取密钥对(公钥+私钥)
     */
    @Bean
    public KeyPair keyPair() {
        KeyStoreKeyFactory factory = new KeyStoreKeyFactory(new ClassPathResource("youlai.jks"), "123456".toCharArray());
        KeyPair keyPair = factory.getKeyPair("youlai", "123456".toCharArray());
        return keyPair;
    }


}
