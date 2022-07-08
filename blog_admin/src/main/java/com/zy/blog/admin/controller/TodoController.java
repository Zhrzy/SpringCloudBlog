package com.zy.blog.admin.controller;


import com.zy.blog.admin.annotation.OperationLogger.OperationLogger;
import com.zy.blog.service.service.TodoService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.*;

import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.TodoView;
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

import javax.servlet.http.HttpServletRequest;

/**
 * 待办事项表 RestApi
 *
 *  @author 小章鱼
 * @date 2022年12月18日
 */
@RestController
@Api(value = "待办事项相关接口", tags = {"待办事项相关接口"})
@RequestMapping("/todo")
@Slf4j
public class TodoController {

    @Autowired
    private TodoService todoService;

    @ApiOperation(value = "获取代办事项列表", notes = "获取代办事项列表", response = String.class)
    @PostMapping("/getList")
    public String getList(HttpServletRequest request, @Validated({GetList.class}) @RequestBody TodoView TodoView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("执行获取代办事项列表");
        return ResultUtil.result(SysConf.SUCCESS, todoService.getPageList(TodoView));
        
    }

    @OperationLogger(value = "增加代办事项")
    @ApiOperation(value = "增加代办事项", notes = "增加代办事项", response = String.class)
    @PostMapping("/add")
    public String add(HttpServletRequest request, @Validated({Insert.class}) @RequestBody TodoView TodoView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return todoService.addTodo(TodoView);
        
    }

    @OperationLogger(value = "编辑代办事项")
    @ApiOperation(value = "编辑代办事项", notes = "编辑代办事项", response = String.class)
    @PostMapping("/edit")
    public String edit(HttpServletRequest request, @Validated({Update.class}) @RequestBody TodoView TodoView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return todoService.editTodo(TodoView);
        
    }

    @OperationLogger(value = "删除代办事项")
    @ApiOperation(value = "删除代办事项", notes = "删除代办事项", response = String.class)
    @PostMapping("/delete")
    public String delete(HttpServletRequest request, @Validated({Delete.class}) @RequestBody TodoView TodoView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return todoService.deleteTodo(TodoView);
        
    }

    @OperationLogger(value = "批量编辑代办事项")
    @ApiOperation(value = "批量编辑代办事项", notes = "批量编辑代办事项", response = String.class)
    @PostMapping("/toggleAll")
    public String toggleAll(HttpServletRequest request, @Validated({GetOne.class}) @RequestBody TodoView TodoView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return todoService.editBatchTodo(TodoView);
        
    }


}

