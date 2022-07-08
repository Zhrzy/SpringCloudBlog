package com.zy.blog.admin.controller;



import com.zy.blog.admin.annotation.OperationLogger.OperationLogger;
import com.zy.blog.service.service.SubjectService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.*;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.SubjectView;
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

import java.util.List;

/**
 * 专题表 RestApi
 *
 *  @author 小章鱼
 * @date 2021年12月16日
 */
@Api(value = "专题相关接口", tags = {"专题相关接口"})
@RestController
@RequestMapping("/subject")
@Slf4j
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @ApiOperation(value = "获取专题列表", notes = "获取专题列表", response = String.class)
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody SubjectView SubjectView, BindingResult result) {

        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.successWithData(subjectService.getPageList(SubjectView));
        
    }

    @OperationLogger(value = "增加专题")
    @ApiOperation(value = "增加专题", notes = "增加专题", response = String.class)
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody SubjectView SubjectView, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return subjectService.addSubject(SubjectView);
        
    }

    @OperationLogger(value = "编辑专题")
    @ApiOperation(value = "编辑专题", notes = "编辑专题", response = String.class)
    @PostMapping("/edit")
    public String edit(@Validated({Update.class}) @RequestBody SubjectView SubjectView, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return subjectService.editSubject(SubjectView);
        
    }

    @OperationLogger(value = "批量删除专题")
    @ApiOperation(value = "批量删除专题", notes = "批量删除专题", response = String.class)
    @PostMapping("/deleteBatch")
    public String delete(@Validated({Delete.class}) @RequestBody List<SubjectView> subjectVOList, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return subjectService.deleteBatchSubject(subjectVOList);
        
    }
}

