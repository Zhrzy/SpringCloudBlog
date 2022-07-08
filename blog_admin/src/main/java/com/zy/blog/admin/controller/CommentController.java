package com.zy.blog.admin.controller;

import com.zy.blog.admin.annotation.OperationLogger.OperationLogger;
import com.zy.blog.service.service.CommentService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.Delete;
import com.zy.blog.utils.annotion.validator.group.GetList;
import com.zy.blog.utils.annotion.validator.group.Insert;
import com.zy.blog.utils.annotion.validator.group.Update;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.CommentView;
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
 * 评论表 RestApi
 *
 *  @author 小章鱼
 * @date 2021年02月5日
 */
@RestController
@RequestMapping("/comment")
@Slf4j
public class CommentController {

    @Autowired
    CommentService commentService;


    @PostMapping(value = "/getList")
    public String getList(@Validated({GetList.class}) @RequestBody CommentView commentVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("获取评论列表: {}", commentVO);
        return ResultUtil.successWithData(commentService.getPageList(commentVO));
    }
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody CommentView commentVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("新增评论: {}", commentVO);
        return commentService.addComment(commentVO);
    }

    @PostMapping("/edit")
    public String edit(@Validated({Update.class}) @RequestBody CommentView commentVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("编辑评论: {}", commentVO);
        return commentService.editComment(commentVO);
    }
    @OperationLogger(value = "删除选中评论")
    @PostMapping("/delete")
    public String delete(@Validated({Delete.class}) @RequestBody CommentView commentVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("删除评论: {}", commentVO);
        return commentService.deleteComment(commentVO);
    }

    @OperationLogger(value = "批量删除选中评论")
    @PostMapping("/deleteBatch")
    public String deleteBatch(@Validated({Delete.class}) @RequestBody List<CommentView> commentVoList, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return commentService.deleteBatchComment(commentVoList);
    }


}

