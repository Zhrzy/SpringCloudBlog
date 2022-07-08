package com.zy.blog.admin.controller;

import com.zy.blog.admin.annotation.OperationLogger.OperationLogger;
import com.zy.blog.service.service.BlogService;
import com.zy.blog.utils.ResultUtil1;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.Delete;
import com.zy.blog.utils.annotion.validator.group.GetList;
import com.zy.blog.utils.annotion.validator.group.Insert;
import com.zy.blog.utils.annotion.validator.group.Update;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.BlogView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @description:
 *  @author 小章鱼
 * @date 2021年02月5日
 **/
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody BlogView blogVO, BindingResult result) {

        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.successWithData(blogService.getPageList(blogVO));
    }


    @OperationLogger(value = "增加博客")
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody BlogView blogVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return blogService.addBlog(blogVO);
    }

    @OperationLogger(value = "本地博客上传")
    @PostMapping("/uploadLocalBlog")
    public String uploadPics(@RequestBody List<MultipartFile> filedatas) throws IOException {

        return blogService.uploadLocalBlog(filedatas);
    }



    @OperationLogger(value = "编辑博客")
    @PostMapping("/edit")
    public String edit(@Validated({Update.class}) @RequestBody BlogView blogVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return blogService.editBlog(blogVO);
    }

    @OperationLogger(value = "推荐博客排序调整")
    @PostMapping("/editBatch")
    public String editBatch(@RequestBody List<BlogView> blogVOList) {
        return blogService.editBatch(blogVOList);
    }

    @OperationLogger(value = "删除博客")
    @PostMapping("/delete")
    public String delete(@Validated({Delete.class}) @RequestBody BlogView blogVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return blogService.deleteBlog(blogVO);
    }

    @OperationLogger(value = "删除选中博客")
    @PostMapping("/deleteBatch")
    public String deleteBatch(@RequestBody List<BlogView> blogVoList) {
        return blogService.deleteBatchBlog(blogVoList);
    }
}
