package com.zy.blog.gateway.config;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.json.JSONUtil;
import com.zy.blog.gateway.exception.RequestAccessDeniedHandler;
import com.zy.blog.utils.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import reactor.core.publisher.Mono;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.core.convert.converter.Converter;

import java.nio.charset.Charset;

/**
 * @author  小章鱼 1716457206@qq.com
 */
@Configuration
@EnableWebFluxSecurity
public class ResourceServerConfig {
    @Autowired
    private AuthorizationManager authorizationManager;
    @Autowired
    private WhiteListConfig whiteListConfig;


    @Autowired
    private ServerAuthenticationEntryPoint serverAuthenticationEntryPoint;

    /**
     * 权限不足的异常处理
     */
    @Autowired
    private RequestAccessDeniedHandler requestAccessDeniedHandler;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http.oauth2ResourceServer().jwt()

                .jwtAuthenticationConverter(jwtAuthenticationConverter());
        http.oauth2ResourceServer().authenticationEntryPoint(serverAuthenticationEntryPoint);
        http.authorizeExchange()
                .pathMatchers(ArrayUtil.toArray(whiteListConfig.getUrls(), String.class)).permitAll()
                .anyExchange().access(authorizationManager)
                .and()
                .exceptionHandling()
                .accessDeniedHandler(requestAccessDeniedHandler) // 处理未授权
                .authenticationEntryPoint(serverAuthenticationEntryPoint) //处理未认证
                .and().csrf().disable();
        return http.build();
    }

    /**
     * 未授权
     *
     * @return
     */
//    @Bean
//    ServerAccessDeniedHandler accessDeniedHandler() {
//        return (exchange, denied) -> {
//            Mono<Void> mono = Mono.defer(() -> Mono.just(exchange.getResponse()))
//                    .flatMap(response -> {
//                        response.setStatusCode(HttpStatus.OK);
//                        response.getHeaders().set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//                        response.getHeaders().set("Access-Control-Allow-Origin", "*");
//                        response.getHeaders().set("Cache-Control", "no-cache");
//                        String body = ResultUtil.errorWithData("未认证");
//                        DataBuffer buffer = response.bufferFactory().wrap(body.getBytes(Charset.forName("UTF-8")));
//                        return response.writeWith(Mono.just(buffer))
//                                .doOnError(error -> DataBufferUtils.release(buffer));
//                    });
//            return mono;
//        };
//    }


    /**
     * @return
     *
     * ServerHttpSecurity没有将jwt中authorities的负载部分当做Authentication
     * 需要把jwt的Claim中的authorities加入
     * 方案：重新定义R 权限管理器，默认转换器JwtGrantedAuthoritiesConverter
     */
    @Bean
    public Converter<Jwt, ? extends Mono<? extends AbstractAuthenticationToken>> jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        jwtGrantedAuthoritiesConverter.setAuthorityPrefix("role_");
        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("authorities");
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
        return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
    }
}
