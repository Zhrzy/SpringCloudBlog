package com.zy.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * @author zy 1716457206@qq.com
 * 授权服务器配置类
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    /** @Author zy
     * @Description //TODO
     * AuthorizationServerSecurityConfigurer:用来配置令牌（token）的访问端点和令牌服务(token
     * services)。
     * @Param
     * @return

     **/
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }


    /** @Author zy
     * @Description //TODO
     * ClientDetailsServiceConfigurer:用来配置客户端详情服务（ClientDetailsService），客户端详情信息在
     * 这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
     * @Param
     * @return
     **/
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        super.configure(clients);
    }

    /** @Author zy
     * @Description //TODO
     * AuthorizationServerEndpointsConfigurer:用来配置令牌（token）的访问端点和令牌服务(token
     * services)。
     * @Param
     * @return
     **/
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);
    }
}
