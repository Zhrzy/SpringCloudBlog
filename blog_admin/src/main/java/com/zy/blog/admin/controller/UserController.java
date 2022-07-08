package com.zy.blog.admin.controller;

import com.zy.blog.admin.annotation.OperationLogger.OperationLogger;
import com.zy.blog.service.service.UserService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.*;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.UserView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户表 RestApi
 *
 * @author 小章鱼
 * @date 2021年1月4日21:29:09
 */
@RestController
@Api(value = "用户相关接口", tags = {"用户相关接口"})
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表", response = String.class)
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody UserView UserView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("获取用户列表: {}", UserView);
        return ResultUtil.successWithData(userService.getPageList(UserView));
        
    }
    
    @OperationLogger(value = "新增用户")
    @ApiOperation(value = "新增用户", notes = "新增用户", response = String.class)
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody UserView UserView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("新增用户: {}", UserView);
        return userService.addUser(UserView);
        
    }

    @OperationLogger(value = "编辑用户")
    @ApiOperation(value = "编辑用户", notes = "编辑用户", response = String.class)
    @PostMapping("/edit")
    public String edit(@Validated({Update.class}) @RequestBody UserView UserView, BindingResult result) {
        // 参数校验
       ThrowableUtils.checkParamArgument(result);
        log.info("编辑用户: {}", UserView);
        return userService.editUser(UserView);
        
    }

    @OperationLogger(value = "删除用户")
    @ApiOperation(value = "删除用户", notes = "删除用户", response = String.class)
    @PostMapping("/delete")
    public String delete(@Validated({Delete.class}) @RequestBody UserView UserView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("删除用户: {}", UserView);
        return userService.deleteUser(UserView);
        
    }

    @OperationLogger(value = "重置用户密码")
    @ApiOperation(value = "重置用户密码", notes = "重置用户密码", response = String.class)
    @PostMapping("/resetUserPassword")
    public String resetUserPassword(@Validated({Delete.class}) @RequestBody UserView UserView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("重置用户密码: {}", UserView);
        return userService.resetUserPassword(UserView);
        
    }
}