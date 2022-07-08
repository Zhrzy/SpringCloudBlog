package com.zy.blog.serach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchRestClientProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 小章鱼
 * @date 2021年1月10日21:08:23
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.zy.blog.commons.feign")
@ComponentScan(basePackages = {
        "com.zy.blog.commons.feign",
        //"com.zy.blog.utils",
        //"com.zy.blog.utils.annotion",
        "com.zy.blog.serach",
})
public class SearchApplication {
    public static void main(String[] args) {
//        /**
//         * Springboot整合Elasticsearch 在项目启动前设置一下的属性，防止报错
//         * 解决netty冲突后初始化client时还会抛出异常
//         * java.lang.IllegalStateException: availableProcessors is already set to [4], rejecting [4]
//         */
//        System.setProperty("es.set.netty.runtime.available.processors", "false");
        //ElasticsearchRestClientProperties
        SpringApplication.run(SearchApplication.class, args);
    }
}



