package com.zy.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@SpringBootApplication
/*@EnableOpenApi*/
@EnableDiscoveryClient
@EnableFeignClients("com.zy.blog.commons")
@ComponentScan(basePackages = {
        "com.zy.blog.commons",
        "com.zy.blog.utils",
        "com.zy.blog.picture",})
public class PictureApplication {

    public static void main(String[] args) {
        SpringApplication.run(PictureApplication.class, args);
    }
}
