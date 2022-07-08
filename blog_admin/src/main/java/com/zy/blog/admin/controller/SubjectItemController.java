package com.zy.blog.admin.controller;


import com.zy.blog.admin.annotation.OperationLogger.OperationLogger;
import com.zy.blog.service.service.SubjectItemService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.authorityverify.AuthorityVerify;
import com.zy.blog.utils.annotion.validator.group.*;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.SubjectItemView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 专题Item表 RestApi
 *
 *  @author 小章鱼
 * @date 2021年4月6日
 */
@Api(value = "专题Item相关接口", tags = {"专题Item相关接口"})
@RestController
@RequestMapping("/subjectItem")
@Slf4j
public class SubjectItemController {

    @Autowired
    private SubjectItemService subjectItemService;

    @ApiOperation(value = "获取专题Item列表", notes = "获取专题Item列表", response = String.class)
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody SubjectItemView SubjectItemView, BindingResult result) {
        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.successWithData(subjectItemService.getPageList(SubjectItemView));
        
    }

    @AuthorityVerify
    @OperationLogger(value = "增加专题Item")
    @ApiOperation(value = "增加专题Item", notes = "增加专题Item", response = String.class)
    @PostMapping("/add")
    public String add(@RequestBody List<SubjectItemView> subjectItemVOList, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return subjectItemService.addSubjectItemList(subjectItemVOList);
        
    }

    @OperationLogger(value = "编辑专题Item")
    @ApiOperation(value = "编辑专题Item", notes = "编辑专题Item", response = String.class)
    @PostMapping("/edit")
    public String edit(@RequestBody List<SubjectItemView> subjectItemVOList, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return subjectItemService.editSubjectItemList(subjectItemVOList);
        
    }

    @OperationLogger(value = "批量删除专题Item")
    @ApiOperation(value = "批量删除专题Item", notes = "批量删除专题Item", response = String.class)
    @PostMapping("/deleteBatch")
    public String delete(@RequestBody List<SubjectItemView> subjectItemVOList, BindingResult result) {
       // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return subjectItemService.deleteBatchSubjectItem(subjectItemVOList);
        
    }

    @OperationLogger(value = "通过创建时间排序专题列表")
    @ApiOperation(value = "通过创建时间排序专题列表", notes = "通过创建时间排序专题列表", response = String.class)
    @PostMapping("/sortByCreateTime")
    public String sortByCreateTime( @RequestParam(name = "subjectUid", required = true) String subjectUid,
                                   @RequestParam(name = "isDesc", required = false, defaultValue = "false") Boolean isDesc) {
        log.info("通过点击量排序博客分类");
        return subjectItemService.sortByCreateTime(subjectUid, isDesc);
        
    }
}

