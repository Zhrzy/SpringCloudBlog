package com.zy.blog.admin.config;

import com.zy.blog.admin.filter.JwtAuthenticationTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public JwtAuthenticationTokenFilter getJwtAuthenticationTokenFilterBean(){
        return new JwtAuthenticationTokenFilter();
    }
    /*
    资源服务的安全拦截配置
    * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                //.antMatchers("/test/login").hasAuthority("admin")
                //.antMatchers("/r/r2").hasAuthority("p2")
                .anyRequest().permitAll()//除了/r/**，其它的请求可以访问
        ;
        // 添加JWT filter
        http.addFilterBefore(getJwtAuthenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
        // 禁用缓存
        http.headers().cacheControl();
    }
}
