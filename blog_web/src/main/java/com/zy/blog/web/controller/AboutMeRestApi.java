package com.zy.blog.web.controller;


import com.zy.blog.service.service.AdminService;
import com.zy.blog.service.service.WebConfigService;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.enums.EBehavior;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.web.annotion.log.BussinessLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 关于我 RestApi
 *
 * @author 小章鱼
 * @date 2021年11月12日14:51:54
 */
@RestController
@RequestMapping("/about")
@Api(value = "关于我相关接口", tags = {"关于我相关接口"})
@Slf4j
public class AboutMeRestApi {

    @Autowired
    AdminService adminService;

    @Autowired
    WebConfigService webConfigService;

    /**
     * 获取关于我的信息
     */
    @BussinessLog(value = "关于我", behavior = EBehavior.VISIT_PAGE)
    @ApiOperation(value = "关于我", notes = "关于我")
    @GetMapping("/getMe")
    public String getMe() {

        log.info("获取关于我的信息");
        return ResultUtil.result(SysConf.SUCCESS, adminService.getAdminByUser(SysConf.ADMIN));
    }

    @ApiOperation(value = "获取联系方式", notes = "获取联系方式")
    @GetMapping("/getContact")
    public String getContact() {
        log.info("获取联系方式");
        return ResultUtil.result(SysConf.SUCCESS, webConfigService.getWebConfigByShowList());
    }

}

