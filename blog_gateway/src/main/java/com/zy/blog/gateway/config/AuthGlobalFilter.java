package com.zy.blog.gateway.config;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.nimbusds.jose.JWSObject;
import com.zy.blog.utils.constant.AuthConstants;
import com.zy.blog.utils.ResultUtil1;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;


/**
 * 黑名单token过滤器
 * @author  小章鱼 1716457206@qq.com
 */

@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst(AuthConstants.JWT_AUTHORIZATION);
        if (StrUtil.isBlank(token)) {
            return chain.filter(exchange);
        }
        String payload="";
        String jti="";
        if (token.startsWith(AuthConstants.JWT_Bear)){
            String  tokensimple = token.replace(AuthConstants.JWT_Bear, Strings.EMPTY);
            try {
                JWSObject  jwsObject = JWSObject.parse(tokensimple);
                payload = jwsObject.getPayload().toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // 针对token(登出、修改密码)校验
            JSONObject jsonObject = JSONUtil.parseObj(payload);
            jti= jsonObject.getStr(AuthConstants.JWT_JTI); // JWT唯一标识
        }
        Boolean hadLogout =redisTemplate.hasKey(AuthConstants.Token_black_prefix+ jti);
        if(hadLogout){
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.OK);
            response.getHeaders().set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            response.getHeaders().set("Access-Control-Allow-Origin", "*");
            response.getHeaders().set("Cache-Control", "no-cache");
            String body = JSONUtil.toJsonStr(ResultUtil1.result("200","该账号已退出登录！请重新登录！","非法token"));
            DataBuffer buffer = response.bufferFactory().wrap(body.getBytes(Charset.forName("UTF-8")));
            return response.writeWith(Mono.just(buffer));
        }
        if (token.startsWith(AuthConstants.JWT_Bear)){
            ServerHttpRequest request = exchange.getRequest().mutate()
                    .header("json_token", payload)
                    .build();
            exchange = exchange.mutate().request(request).build();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
