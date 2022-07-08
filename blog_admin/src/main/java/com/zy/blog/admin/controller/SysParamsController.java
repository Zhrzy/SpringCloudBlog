package com.zy.blog.admin.controller;



import com.zy.blog.service.service.SysParamsService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.GetList;
import com.zy.blog.utils.annotion.validator.group.*;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.SysParamsView;
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
 * 参数配置 RestApi
 *
 *  @author 小章鱼
 * @date 2021年9月18日
 */
@RestController
@RequestMapping("/sysParams")
/*@Api(value = "参数配置相关接口", tags = {"参数配置相关接口"})*/
@Slf4j
public class SysParamsController {

    @Autowired
    private SysParamsService sysParamsService;

   /* @AuthorityVerify
    @ApiOperation(value = "获取参数配置列表", notes = "获取参数配置列表", response = String.class)*/
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody SysParamsView SysParamsView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("获取参数配置列表");
        return ResultUtil.successWithData(sysParamsService.getPageList(SysParamsView));
        
    }

  /*  @AvoidRepeatableCommit
    @AuthorityVerify
    @OperationLogger(value = "增加参数配置")
    @ApiOperation(value = "增加参数配置", notes = "增加参数配置", response = String.class)*/
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody SysParamsView SysParamsView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return sysParamsService.addSysParams(SysParamsView);

        
    }

    /*@AuthorityVerify
    @OperationLogger(value = "编辑参数配置")
    @ApiOperation(value = "编辑参数配置", notes = "编辑参数配置", response = String.class)*/
    @PostMapping("/edit")
    public String edit(HttpServletRequest request, @Validated({Update.class}) @RequestBody SysParamsView SysParamsView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return sysParamsService.editSysParams(SysParamsView);

        
    }

    /*@AuthorityVerify
    @OperationLogger(value = "批量删除参数配置")
    @ApiOperation(value = "批量删除参数配置", notes = "批量删除参数配置", response = String.class)*/
    @PostMapping("/deleteBatch")
    public String delete(@RequestBody List<SysParamsView> SysParamsVoList, BindingResult result) {

        return sysParamsService.deleteBatchSysParams(SysParamsVoList);

        
    }
}

