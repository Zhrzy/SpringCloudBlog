package com.zy.blog;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2021/06/01
 **/
@EnableScheduling
@EnableTransactionManagement
@SpringBootApplication
@EnableOpenApi
@EnableDiscoveryClient
@EnableAsync
@EnableFeignClients("com.zy.blog.commons.feign")
@ComponentScan(basePackages = {
        "com.zy.blog.commons",
        "com.zy.blog.utils",
        "com.zy.blog.utils.annotion",
        "com.zy.blog.web",
        "com.zy.blog.service",
        "com.zy.blog.service.mapper"
})
public class WebApplication {
    //https://blog.csdn.net/Saintmm/article/details/118656380
    //网关限流 https://github.com/alibaba/Sentinel/wiki/%E7%BD%91%E5%85%B3%E9%99%90%E6%B5%81
    public static void main(String[] args) {
        //TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(WebApplication.class, args);
    }
}
