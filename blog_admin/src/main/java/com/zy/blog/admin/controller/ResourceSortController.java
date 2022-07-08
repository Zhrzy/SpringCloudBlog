package com.zy.blog.admin.controller;



import com.zy.blog.admin.annotation.OperationLogger.OperationLogger;
import com.zy.blog.service.service.ResourceSortService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.Delete;
import com.zy.blog.utils.annotion.validator.group.GetList;
import com.zy.blog.utils.annotion.validator.group.Insert;
import com.zy.blog.utils.annotion.validator.group.Update;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.ResourceSortView;

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
 * 资源分类表 RestApi
 *
 *  @author 小章鱼
 * @date 2021年9月2日
 */
@Api(value = "资源分类相关接口", tags = {"资源分类相关接口"})
@RestController
@RequestMapping("/resourceSort")
@Slf4j
public class ResourceSortController {

    @Autowired
    private ResourceSortService resourceSortService;

    @ApiOperation(value = "获取资源分类列表", notes = "获取资源分类列表", response = String.class)
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody ResourceSortView ResourceSortView, BindingResult result) {

        ThrowableUtils.checkParamArgument(result);
        log.info("获取资源分类列表:{}", ResourceSortView);
        return ResultUtil.successWithData(resourceSortService.getPageList(ResourceSortView));
        
    }

    @OperationLogger(value = "增加资源分类")
    @ApiOperation(value = "增加资源分类", notes = "增加资源分类", response = String.class)
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody ResourceSortView ResourceSortView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("增加资源分类:{}", ResourceSortView);
        return resourceSortService.addResourceSort(ResourceSortView);
        
    }

    @OperationLogger(value = "编辑资源分类")
    @ApiOperation(value = "编辑资源分类", notes = "编辑资源分类", response = String.class)
    @PostMapping("/edit")
    public String edit(@Validated({Update.class}) @RequestBody ResourceSortView ResourceSortView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("编辑资源分类:{}", ResourceSortView);
        return resourceSortService.editResourceSort(ResourceSortView);
        
    }

    @OperationLogger(value = "批量删除资源分类")
    @ApiOperation(value = "批量删除资源分类", notes = "批量删除资源分类", response = String.class)
    @PostMapping("/deleteBatch")
    public String delete(@Validated({Delete.class}) @RequestBody List<ResourceSortView> resourceSortVOList, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("批量删除资源分类:{}", resourceSortVOList);
        return resourceSortService.deleteBatchResourceSort(resourceSortVOList);
        
    }

    @OperationLogger(value = "置顶资源分类")
    @ApiOperation(value = "置顶分类", notes = "置顶分类", response = String.class)
    @PostMapping("/stick")
    public String stick(@Validated({Delete.class}) @RequestBody ResourceSortView ResourceSortView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("置顶分类:{}", ResourceSortView);
        return resourceSortService.stickResourceSort(ResourceSortView);
        
    }
}

