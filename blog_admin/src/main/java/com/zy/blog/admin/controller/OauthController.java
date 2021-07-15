package com.zy.blog.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.zy.blog.admin.feign.OauthFeignService;
import com.zy.blog.entity.Admin;
import com.zy.blog.utils.JsonUtils;
import com.zy.blog.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
@PostMapping("/getInfo")
    public Object getInfo(@RequestParam( value = "token")String token){
        String tokenStr = token;
        String tokenInfo=oauthFeignService.getTokenInfo(tokenStr);
        Map<String,Object> map = new HashMap<String,Object>();
        if(tokenInfo!=null){
            JSONObject jsonObject = JsonUtils.strToJson(tokenInfo);
            map.put("name",jsonObject.getJSONObject("user_name").get("userName"));
            map.put("roles",jsonObject.get("authorities"));
            map.put("avatar",jsonObject.getJSONObject("user_name").get("avatar"));
        }
        System.out.println(tokenInfo.toString());
        return ResultUtil.result("success","成功",map);
    }
}
