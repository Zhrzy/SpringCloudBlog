package com.zy.blog.oauth.exception;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.oauth2.common.exceptions.BadClientCredentialsException;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenEndpointFilter;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * 重写filter实现客户端自定义异常处理
 */
public class CustomClientCredentialsTokenEndpointFilter extends ClientCredentialsTokenEndpointFilter {

    private final AuthorizationServerSecurityConfigurer configurer;

    private AuthenticationEntryPoint authenticationEntryPoint;

    /**
     * 构造方法
     * @param configurer AuthorizationServerSecurityConfigurer对昂
     * @param authenticationEntryPoint 自定义的AuthenticationEntryPoint
     */
    public CustomClientCredentialsTokenEndpointFilter(AuthorizationServerSecurityConfigurer configurer, AuthenticationEntryPoint authenticationEntryPoint) {
        this.configurer = configurer;
        this.authenticationEntryPoint=authenticationEntryPoint;
    }

    @Override
    public void setAuthenticationEntryPoint(AuthenticationEntryPoint authenticationEntryPoint) {
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    /**
     * 需要重写这个方法，返回AuthenticationManager
     */
    @Override
    protected AuthenticationManager getAuthenticationManager() {
        return configurer.and().getSharedObject(AuthenticationManager.class);
    }

    /**
     * 设置AuthenticationEntryPoint主要逻辑
     */
    @Override
    public void afterPropertiesSet() {
        //TODO 定制认证失败处理器，开发中可以自己修改
        setAuthenticationFailureHandler((request, response, exception) -> {
            if (exception instanceof BadCredentialsException) {
                exception = new BadCredentialsException(exception.getMessage(), new BadClientCredentialsException());
            }
            authenticationEntryPoint.commence(request, response, exception);
        });
        //成功处理器，和父类相同，为空即可。
        setAuthenticationSuccessHandler((request, response, authentication) -> {
        });
    }
}
