package com.zy.blog.uuagateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class AppUuaGateWay {
    public static void main(String[] args) {
        SpringApplication.run(AppUuaGateWay.class,args);
    }
}
