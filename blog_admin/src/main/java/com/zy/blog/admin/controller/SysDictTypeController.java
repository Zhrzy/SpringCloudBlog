package com.zy.blog.admin.controller;


import com.zy.blog.admin.annotation.OperationLogger.OperationLogger;
import com.zy.blog.service.service.SysDictTypeService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.*;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.SysDictTypeView;
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
import java.util.List;

/**
 * 字典类型 RestApi
 *
 *  @author 小章鱼
 * @date 2021年6月8日
 */
@RestController
@RequestMapping("/sysDictType")

@Api(value = "字典类型相关接口", tags = {"字典类型相关接口"})

@Slf4j
public class SysDictTypeController {

    @Autowired
    private SysDictTypeService sysDictTypeService;

    @ApiOperation(value = "获取字典类型列表", notes = "获取字典类型列表", response = String.class)
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody SysDictTypeView SysDictTypeView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("获取字典类型列表");
        return ResultUtil.successWithData(sysDictTypeService.getPageList(SysDictTypeView));
        
    }

    @OperationLogger(value = "增加字典类型")
    @ApiOperation(value = "增加字典类型", notes = "增加字典类型", response = String.class)
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody SysDictTypeView SysDictTypeView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return sysDictTypeService.addSysDictType(SysDictTypeView);
        
        
    }

    /*@AuthorityVerify
    @OperationLogger(value = "编辑字典类型")
    @ApiOperation(value = "编辑字典类型", notes = "编辑字典类型", response = String.class)*/
    @PostMapping("/edit")
    public String edit(HttpServletRequest request, @Validated({Update.class}) @RequestBody SysDictTypeView SysDictTypeView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return sysDictTypeService.editSysDictType(SysDictTypeView);
        
    }

   /* @AuthorityVerify
    @OperationLogger(value = "批量删除字典类型")
    @ApiOperation(value = "批量删除字典类型", notes = "批量删除字典类型", response = String.class)*/
    @PostMapping("/deleteBatch")
    public String delete(HttpServletRequest request, @Validated({Delete.class}) @RequestBody List<SysDictTypeView> sysDictTypeVoList, BindingResult result) {
        
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return sysDictTypeService.deleteBatchSysDictType(sysDictTypeVoList);
        
    }
}

