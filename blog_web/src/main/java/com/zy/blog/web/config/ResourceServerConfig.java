package com.zy.blog.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/*
* 资源服务器配置
*
* */
@Configuration
@EnableResourceServer
@RefreshScope
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    public static final String RESOURCE_ID="res1";

    @Autowired
    private TokenStore tokenStore;
    @Value("${blogconfig.cktokenurl}")
    private String ckTokenUrl;
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID)
                //.tokenServices(tokenService()) 调用了授权服务的校验token，这里不用了，改为下面一行的本地校验，并且注释[1]
                .tokenStore(tokenStore)//资源服务本地解析token
                .stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //.antMatchers("/test/login").hasAnyAuthority("admin")
                .antMatchers("/test/test1").permitAll()
                .antMatchers("/admin/**").permitAll()
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


    // [1] 资源服务令牌解析服务,使用的是授权服务器的校验，一般不使用，这里仅仅测试
    @Bean
    public ResourceServerTokenServices tokenService() {
        //使用远程服务请求授权服务器校验token,必须指定校验token 的url、client_id，client_secret
        //使用 DefaultTokenServices 在资源服务器本地配置令牌存储、解码、解析方式 使用 RemoteTokenServices
        // 资源服务器通过 HTTP 请求来解码令牌，每次都请求授权服务器端点 /oauth/check_token
        // 使用授权服务的 /oauth/check_token 端点你需要在授权服务将这个端点暴露出去，以便资源服务可以进行访问
        RemoteTokenServices service=new RemoteTokenServices(); //使用远程服务
        service.setCheckTokenEndpointUrl(ckTokenUrl);
        service.setClientId("c1");
        service.setClientSecret("secret");
        return service;
    }

}
