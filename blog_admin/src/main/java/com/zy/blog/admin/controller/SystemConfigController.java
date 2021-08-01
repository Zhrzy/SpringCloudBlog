package com.zy.blog.admin.controller;


import com.zy.blog.admin.service.SystemConfigService;
import com.zy.blog.utils.ResultUtil;
import com.zy.blog.view.SystemConfigView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/sysConfig")
public class SystemConfigController {

    @Autowired
    private SystemConfigService systemConfigService;

    @RequestMapping("/getSystemConfig")
    public String  getSystemConfig() {
        return ResultUtil.result("success","成功",systemConfigService.selectSystemConfig());
    }

    @RequestMapping("/editSystemConfig")
    public String editSystemConfig(@RequestBody SystemConfigView systemConfigView){

        int a =systemConfigService.editSystemConfig(systemConfigView);
        return  ResultUtil.result("success","成功",null);
    }
}
