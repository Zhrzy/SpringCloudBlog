package com.zy.blog.admin.controller;

import com.zy.blog.service.service.ExceptionLogService;
import com.zy.blog.service.service.SysLogService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.GetList;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.ExceptionLogView;
import com.zy.blog.view.SysLogView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志记录表 RestApi
 *
 *  @author 小章鱼
 * @date 2021年02月2日
 */
@RestController
@RequestMapping("/log")
@Slf4j
public class LogController {

    @Autowired
    private SysLogService sysLogService;
    @Autowired
    private ExceptionLogService exceptionLogService;

    @PostMapping(value = "/getLogList")
    public String getLogList(@Validated({GetList.class}) @RequestBody SysLogView sysLogVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.result(SysConf.SUCCESS, sysLogService.getPageList(sysLogVO));
        
    }

    @PostMapping(value = "/getExceptionList")
    public String getExceptionList(@Validated({GetList.class}) @RequestBody ExceptionLogView exceptionLogVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.result(SysConf.SUCCESS, exceptionLogService.getPageList(exceptionLogVO));
        
    }
}

