package com.zy.blog.admin.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "blog-oauth")
public interface OauthFeignService {

    @RequestMapping(method = RequestMethod.POST, value = "/oauth/token")
    public Object oauthToken(@RequestBody MultiValueMap<String, String> map);
}
