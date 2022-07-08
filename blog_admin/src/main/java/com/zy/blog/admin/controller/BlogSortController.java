package com.zy.blog.admin.controller;


import com.zy.blog.admin.annotation.OperationLogger.OperationLogger;
import com.zy.blog.service.service.BlogSortService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.*;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.BlogSortView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 *  @author 小章鱼
 * @date 2021年02月5日
 **/
@RestController
@RequestMapping("/blogSort")
public class BlogSortController {

    @Autowired
    private BlogSortService blogSortService;

    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody BlogSortView blogSortVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);

        return ResultUtil.successWithData(blogSortService.getPageList(blogSortVO));
    }

    //@AvoidRepeatableCommit
    @OperationLogger(value = "增加博客分类")
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody BlogSortView blogSortVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return blogSortService.addBlogSort(blogSortVO);
    }

    @OperationLogger(value = "编辑博客分类")
    @PostMapping("/edit")
    public String edit(@Validated({Update.class}) @RequestBody BlogSortView blogSortVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return blogSortService.editBlogSort(blogSortVO);
    }

    @OperationLogger(value = "批量删除博客分类")
    @PostMapping("/deleteBatch")
    public String delete(@Validated({Delete.class}) @RequestBody List<BlogSortView> blogSortVoList, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return blogSortService.deleteBatchBlogSort(blogSortVoList);
    }

    @PostMapping("/stick")
    public String stick(@Validated({Delete.class}) @RequestBody BlogSortView blogSortVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return blogSortService.stickBlogSort(blogSortVO);

    }

    @OperationLogger(value = "通过点击量排序博客分类")
    @PostMapping("/blogSortByClickCount")
    public String blogSortByClickCount() {
        return blogSortService.blogSortByClickCount();
    }

    /**
     * 通过引用量排序标签
     * 引用量就是所有的文章中，有多少使用了该标签，如果使用的越多，该标签的引用量越大，那么排名越靠前
     *
     * @return
     */
    @OperationLogger(value = "通过引用量排序博客分类")
    @PostMapping("/blogSortByCite")
    public String blogSortByCite() {
        return blogSortService.blogSortByCite();
    }

}
