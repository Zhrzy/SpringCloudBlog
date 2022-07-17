package com.zy.blog.gateway.exception;

import cn.hutool.json.JSONUtil;
import com.zy.blog.gateway.model.ResultCode;
import com.zy.blog.gateway.model.ResultMsg;
import com.zy.blog.utils.util.ResultUtil;
import lombok.val;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;

/**
 * @description: 自定义返回结果：没有权限访问时
 * @author: 小章鱼
 * @date: 2022/6/23 0:05
 **/

@Component
public class RequestAccessDeniedHandler implements ServerAccessDeniedHandler {
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, AccessDeniedException denied) {
//        ServerHttpResponse response = exchange.getResponse();
//        response.setStatusCode(HttpStatus.OK);
//        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//        String body= JSONUtil.toJsonStr(new ResultMsg(ResultCode.NO_PERMISSION.getStatus(),ResultCode.NO_PERMISSION.getMessage(),null));
//        DataBuffer buffer =  response.bufferFactory().wrap(body.getBytes(Charset.forName("UTF-8")));
//        return response.writeWith(Mono.just(buffer));
        Mono<Void> mono = Mono.defer(() -> Mono.just(exchange.getResponse()))
                .flatMap(response -> {
                    response.setStatusCode(HttpStatus.OK);
                    response.getHeaders().set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                    response.getHeaders().set("Access-Control-Allow-Origin", "*");
                    response.getHeaders().set("Cache-Control", "no-cache");
                    String body= JSONUtil.toJsonStr(new ResultMsg(ResultCode.NO_PERMISSION.getStatus(),ResultCode.NO_PERMISSION.getMessage(),null));
                    DataBuffer buffer = response.bufferFactory().wrap(body.getBytes(Charset.forName("UTF-8")));
                    return response.writeWith(Mono.just(buffer))
                            .doOnError(error -> DataBufferUtils.release(buffer));
                });

        return mono;
    }
}
