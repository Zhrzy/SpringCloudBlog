package com.zy.blog.gateway.config;

import com.zy.blog.utils.util.cache.LRUCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author: 小章鱼
 * @description:
 * @date: 2022/7/11 22:17
 **/
@Configuration
public class LRUCacheConfig {

    @Bean
    public LRUCache<String, Map<String,String>> perCache(){
      return new LRUCache<>(10) ;
    }

}
