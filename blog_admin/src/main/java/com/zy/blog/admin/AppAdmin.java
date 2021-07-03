package com.zy.blog.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author zy 1716457206@qq.com
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AppAdmin {
    public static void main(String[] args) {
        SpringApplication.run(AppAdmin.class, args);
    }
}
