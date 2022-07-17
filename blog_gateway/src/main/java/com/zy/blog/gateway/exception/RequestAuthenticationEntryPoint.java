package com.zy.blog.gateway.exception;

import cn.hutool.json.JSONUtil;
import com.zy.blog.gateway.model.ResultCode;
import com.zy.blog.gateway.model.ResultMsg;
import com.zy.blog.utils.util.ResultUtil;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;

/**
 * @description: 自定义token无效处理器 用于处理没有登录或token过期时的自定义返回结果
 * @author: 小章鱼
 * @date: 2022/6/22 23:56
 **/
@Component
public class RequestAuthenticationEntryPoint implements ServerAuthenticationEntryPoint {
    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException e) {
        Mono<Void> mono = Mono.defer(() -> Mono.just(exchange.getResponse()))
                .flatMap(response -> {
                    response.setStatusCode(HttpStatus.OK);
                    response.getHeaders().set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                    response.getHeaders().set("Access-Control-Allow-Origin", "*");
                    response.getHeaders().set("Cache-Control", "no-cache");
                    String body= JSONUtil.toJsonStr(new ResultMsg(ResultCode.TOKEN_INVALID.getStatus(),ResultCode.TOKEN_INVALID.getMessage(),null));
                    DataBuffer buffer = response.bufferFactory().wrap(body.getBytes(Charset.forName("UTF-8")));
                    return response
                            .writeWith(Mono.just(buffer))
                            .doOnError(error -> DataBufferUtils.release(buffer));
                });
        return mono;

    }
}
