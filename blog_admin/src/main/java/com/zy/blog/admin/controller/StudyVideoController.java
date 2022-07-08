package com.zy.blog.admin.controller;



import com.zy.blog.admin.annotation.OperationLogger.OperationLogger;
import com.zy.blog.service.service.StudyVideoService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.Delete;
import com.zy.blog.utils.annotion.validator.group.GetList;
import com.zy.blog.utils.annotion.validator.group.Insert;
import com.zy.blog.utils.annotion.validator.group.Update;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.StudyVideoView;
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
 * 视频表 RestApi
 *
 *  @author 小章鱼
 * @date 2021年7月2日
 */
@RestController
@RequestMapping("/studyVideo")
@Api(value = "学习视频相关接口", tags = {"学习视频相关接口"})
@Slf4j
public class StudyVideoController {

    @Autowired
    private StudyVideoService studyVideoService;

    @ApiOperation(value = "获取学习视频列表", notes = "获取学习视频列表", response = String.class)
    @PostMapping(value = "/getList")
    public String getList(@Validated({GetList.class}) @RequestBody StudyVideoView StudyVideoView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("获取学习视频列表: {}", StudyVideoView);
        return ResultUtil.successWithData(studyVideoService.getPageList(StudyVideoView));
        
    }

    @OperationLogger(value = "增加学习视频")
    @ApiOperation(value = "增加学习视频", notes = "增加学习视频", response = String.class)
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody StudyVideoView StudyVideoView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("增加学习视频: {}", StudyVideoView);
        return studyVideoService.addStudyVideo(StudyVideoView);
        
    }

    @OperationLogger(value = "编辑学习视频")
    @ApiOperation(value = "编辑学习视频", notes = "编辑学习视频", response = String.class)
    @PostMapping("/edit")
    public String edit(@Validated({Update.class}) @RequestBody StudyVideoView StudyVideoView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("编辑学习视频: {}", StudyVideoView);
        return studyVideoService.editStudyVideo(StudyVideoView);
        
    }

    @OperationLogger(value = "删除学习视频")
    @ApiOperation(value = "删除学习视频", notes = "删除学习视频", response = String.class)
    @PostMapping("/deleteBatch")
    public String deleteBatch(@Validated({Delete.class}) @RequestBody List<StudyVideoView> studyVideoVOList, BindingResult result) {

        // 参数校验
       ThrowableUtils.checkParamArgument(result);
        log.info("删除学习视频: {}", studyVideoVOList);
        return studyVideoService.deleteBatchStudyVideo(studyVideoVOList);
        
    }

}

