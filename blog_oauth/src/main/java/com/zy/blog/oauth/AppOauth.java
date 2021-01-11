package com.zy.blog.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppOauth {
    public static void main(String[] args) {
        SpringApplication.run(AppOauth.class, args);
    }
}
