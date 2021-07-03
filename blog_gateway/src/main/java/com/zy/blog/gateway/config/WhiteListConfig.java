package com.zy.blog.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zy 1716457206@qq.com
 */
@Configuration
//@ConfigurationProperties(prefix = "whitelist")
public class WhiteListConfig {
    private List<String> urls=new ArrayList<>();
    public WhiteListConfig()  {
        urls.add("/admin/login");
    }
    public List<String> getUrls() {

        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
