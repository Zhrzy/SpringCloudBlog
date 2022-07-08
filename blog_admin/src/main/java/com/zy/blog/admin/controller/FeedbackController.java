package com.zy.blog.admin.controller;



import com.zy.blog.admin.annotation.OperationLogger.OperationLogger;
import com.zy.blog.service.service.FeedbackService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.Delete;
import com.zy.blog.utils.annotion.validator.group.GetList;
import com.zy.blog.utils.annotion.validator.group.Update;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.FeedBackView;
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
 * 反馈表 RestApi
 *
 *  @author 小章鱼
 * @date 2021年02月5日
 */
@RestController
@RequestMapping("/feedback")
@Slf4j
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody FeedBackView feedbackVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("获取反馈列表: {}", feedbackVO);
        return ResultUtil.result(SysConf.SUCCESS, feedbackService.getPageList(feedbackVO));
    }

    @OperationLogger(value = "编辑反馈")
    @PostMapping("/edit")
    public String edit(@Validated({Update.class}) @RequestBody FeedBackView feedbackVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("编辑反馈: {}", feedbackVO);
        return feedbackService.addFeedback(feedbackVO);
    }

    @OperationLogger(value = "批量删除反馈")
    @PostMapping("/deleteBatch")
    public String delete(@Validated({Delete.class}) @RequestBody List<FeedBackView> feedbackVOList, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("批量删除反馈: {}", feedbackVOList);
        return feedbackService.deleteBatchFeedback(feedbackVOList);
    }

}

