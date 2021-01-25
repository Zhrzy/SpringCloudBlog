package com.zy.blog.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;


@SpringBootApplication
@EnableDiscoveryClient
public class AppGateway {

    public static void main(String[] args) {
        SpringApplication.run(AppGateway.class, args);
    }
}
