package com.zy.blog.admin.controller;


import com.zy.blog.admin.annotation.OperationLogger.OperationLogger;
import com.zy.blog.service.service.AdminService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.Update;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.AdminView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 系统设置RestApi
 *
 *  @author 小章鱼
 * @date 2020年12月18日
 */

@RestController
@RequestMapping("/system")
@Api(value = "系统设置相关接口", tags = {"系统设置相关接口"})
@Slf4j
public class SystemController {

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "获取我的信息", notes = "获取我的信息")
    @GetMapping("/getMe")
    public String getMe() {
        return ResultUtil.successWithData(adminService.getMe());
        
    }

    @OperationLogger(value = "编辑我的信息")
    @ApiOperation(value = "编辑我的信息", notes = "获取我的信息")
    @PostMapping("/editMe")
    public String editMe(@Validated({Update.class}) @RequestBody AdminView adminVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return adminService.editMe(adminVO);
        
    }

    @ApiOperation(value = "修改密码", notes = "修改密码")
    @PostMapping("/changePwd")
    public String changePwd(@RequestParam(name = "oldPwd", required = false) String oldPwd,
                            @RequestParam(name = "newPwd", required = false) String newPwd) {
        return adminService.changePwd(oldPwd, newPwd);
        
    }

}
