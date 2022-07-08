package com.zy.blog.admin.controller;

import com.zy.blog.admin.annotation.OperationLogger.OperationLogger;
import com.zy.blog.service.service.WebConfigService;
import com.zy.blog.utils.annotion.validator.group.Update;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.WebConfigView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 网站配置表 RestApi
 *
 * @author 小章鱼
 * @date 2021年11月11日15:19:28
 */
@Api(value = "网站配置相关接口", tags = {"网站配置相关接口"})
@RestController
@RequestMapping("/webConfig")
@Slf4j
public class WebConfigController {

    @Autowired
    WebConfigService webConfigService;

    @ApiOperation(value = "获取网站配置", notes = "获取网站配置")
    @GetMapping("/getWebConfig")
    public String getWebConfig() {
        return ResultUtil.successWithData(webConfigService.getWebConfig());
    }

    @OperationLogger(value = "修改网站配置")
    @ApiOperation(value = "修改网站配置", notes = "修改网站配置")
    @PostMapping("/editWebConfig")
    public String editWebConfig(@Validated({Update.class}) @RequestBody WebConfigView webConfigVO, BindingResult result) {
        return webConfigService.editWebConfig(webConfigVO);
    }
}

