package com.zy.blog.admin.controller;

import cn.hutool.json.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zy.blog.admin.service.AdminService;
import com.zy.blog.admin.service.MenuService;
import com.zy.blog.entity.Admin;
import com.zy.blog.entity.Menu;
import com.zy.blog.utils.JsonUtils;
import com.zy.blog.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private MenuService menuService;

    @PostMapping ("/getRouter")
    public Object getRouter(){
        List list = (List) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        Object  userinfo = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        JSONObject jsonObject = JsonUtils.strToJson(JsonUtils.objectToJson(userinfo));
        String userid= jsonObject.getJSONObject("userName").getString("uid");
        List<Menu> routerList = menuService.getRouterList(userid);

        Map map = new HashMap<String,Object>();
        map.put("routers",routerList);
        return ResultUtil.result("success","成功",map);

    }







}
