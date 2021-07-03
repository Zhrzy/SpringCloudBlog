package com.zy.blog.admin.controller;

import com.zy.blog.admin.feign.OauthFeignService;
import com.zy.blog.entity.Admin;
import com.zy.blog.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class OauthController {

    @Autowired
    private OauthFeignService oauthFeignService;

    @PostMapping("/login")
    public Object login(@RequestParam( value = "username")String username, @RequestParam("password")String password){
        String uname=username;
        String pword=password;
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("username", uname);
        multiValueMap.add("password", pword);
        multiValueMap.add("grant_type", "password");
        multiValueMap.add("client_id", "c1");
        multiValueMap.add("client_secret", "secret");
        Object tokenInfo =oauthFeignService.oauthToken(multiValueMap);
        return ResultUtil.result("success","成功",tokenInfo);

    }
}
