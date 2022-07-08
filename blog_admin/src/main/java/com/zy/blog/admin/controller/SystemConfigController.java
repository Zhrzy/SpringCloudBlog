package com.zy.blog.admin.controller;


import com.zy.blog.service.service.SystemConfigService;
import com.zy.blog.utils.ResultUtil1;
import com.zy.blog.view.SystemConfigView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 系统配置 RestApi
 *
 *  @author 小章鱼
 * @date 2020年12月18日
 */
@RestController
@RequestMapping("/sysConfig")
public class SystemConfigController {

    @Autowired
    private SystemConfigService systemConfigService;

    @RequestMapping("/getSystemConfig")
    public String  getSystemConfig() {
        return ResultUtil1.result("success","成功",systemConfigService.selectSystemConfig());
    }

    @RequestMapping("/editSystemConfig")
    public String editSystemConfig(@RequestBody SystemConfigView systemConfigView){

        int a =systemConfigService.editSystemConfig(systemConfigView);
        return  ResultUtil1.result("success","成功",null);
    }
    @PostMapping("/cleanRedisByKey")
    public String cleanRedisByKey(@RequestBody List<String> key) {
        return systemConfigService.cleanRedisByKey(key);
    }
}
