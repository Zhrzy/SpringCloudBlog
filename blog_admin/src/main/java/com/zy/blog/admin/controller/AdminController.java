package com.zy.blog.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.zy.blog.admin.annotation.OperationLogger.OperationLogger;
import com.zy.blog.service.service.AdminService;
import com.zy.blog.service.service.MenuService;
import com.zy.blog.utils.annotion.validator.group.*;
import com.zy.blog.entity.Menu;
import com.zy.blog.utils.JsonUtils;
import com.zy.blog.utils.ResultUtil1;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.Insert;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.view.AdminView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private MenuService menuService;

    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody AdminView AdminView, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return adminService.getList(AdminView);
    }

    @PostMapping ("/getRouter")
    public Object getRouter(){
        List list = (List) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        Object  userinfo = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        JSONObject jsonObject = JsonUtils.strToJson(JsonUtils.objectToJson(userinfo));
        log.info("A:"+jsonObject.toJSONString());
        //String userid= jsonObject.getJSONObject("userName").getString("uid");
        String userid= jsonObject.getString("uid");
        List<Menu> routerList = menuService.getRouterList(userid);
        Map map = new HashMap<String,Object>();
        map.put("routers",routerList);
        return ResultUtil1.result(SysConf.SUCCESS,"成功",map);

    }


    @OperationLogger(value = "新增管理员")
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody AdminView AdminView, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return adminService.addAdmin(AdminView);
    }


    @OperationLogger(value = "重置用户密码")
    @PostMapping("/restPwd")
    public String restPwd(@Validated({Update.class}) @RequestBody AdminView AdminView, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return adminService.resetPwd(AdminView);
    }



    @OperationLogger(value = "更新管理员")
    @PostMapping("/edit")
    public String edit(@Validated({Update.class}) @RequestBody AdminView AdminView, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return adminService.editAdmin(AdminView);
    }


//    @AuthorityVerify
//    @OperationLogger(value = "批量删除管理员")
//    @ApiOperation(value = "批量删除管理员", notes = "批量删除管理员")
    @PostMapping("/delete")
    public String delete(/*@ApiParam(name = "adminUids", value = "管理员uid集合", required = true)*/ @RequestParam(name = "adminUids", required = true) List<String> adminUids) {
        return adminService.deleteBatchAdmin(adminUids);
    }

//    @AuthorityVerify
//    @ApiOperation(value = "获取在线管理员列表", notes = "获取在线管理员列表", response = String.class)
    @PostMapping(value = "/getOnlineAdminList")
    public String getOnlineAdminList(@Validated({GetList.class}) @RequestBody AdminView AdminView, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return adminService.getOnlineAdminList(AdminView);
    }

    /*@AuthorityVerify
    @OperationLogger(value = "强退用户")
    @ApiOperation(value = "强退用户", notes = "强退用户", response = String.class)*/
    @PostMapping(value = "/forceLogout")
    public String forceLogout(/*@ApiParam(name = "tokenUidList", value = "tokenList", required = false) */@RequestBody List<String> tokenUidList) {
        return adminService.forceLogout(tokenUidList);
    }







}
