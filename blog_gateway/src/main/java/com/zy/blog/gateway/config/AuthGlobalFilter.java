package com.zy.blog.gateway.config;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.nimbusds.jose.JWSObject;
import org.apache.logging.log4j.util.Strings;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * 黑名单token过滤器
 */
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (StrUtil.isBlank(token)) {
            return chain.filter(exchange);
        }
        Map<String,Object> jsonToken = new HashMap<>();
        String  tokensimple = token.replace("Bearer ", Strings.EMPTY);
        try {
            JWSObject  jwsObject = JWSObject.parse(tokensimple);
            String payload = jwsObject.getPayload().toString();
            JSONObject jsonObject = JSONUtil.parseObj(payload);
            String authorities = jsonObject.getStr("authorities");
            String userInfo =jsonObject.getStr("user_name");
            jsonToken.put("principal",userInfo);
            jsonToken.put("authorities",authorities);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /*
        // 针对token(登出、修改密码)校验
        JSONObject jsonObject = JSONUtil.parseObj(payload);
        String jti = jsonObject.getStr("jti"); // JWT唯一标识

        Boolean isBlack = redisTemplate.hasKey(AuthConstants.TOKEN_BLACKLIST_PREFIX + jti);
        if (isBlack) {
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.OK);
            response.getHeaders().set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            response.getHeaders().set("Access-Control-Allow-Origin", "*");
            response.getHeaders().set("Cache-Control", "no-cache");
            String body = JSONUtil.toJsonStr(Result.failed(ResultCode.TOKEN_INVALID_OR_EXPIRED));
            DataBuffer buffer = response.bufferFactory().wrap(body.getBytes(Charset.forName("UTF-8")));
            return response.writeWith(Mono.just(buffer));
        }
        */
        ServerHttpRequest request = exchange.getRequest().mutate()
                .header("json_token", JSON.toJSONString(jsonToken))
                .build();
        exchange = exchange.mutate().request(request).build();
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
