package com.zy.blog.admin.controller;

import com.zy.blog.service.service.RoleService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.Delete;
import com.zy.blog.utils.annotion.validator.group.GetList;
import com.zy.blog.utils.annotion.validator.group.Insert;
import com.zy.blog.utils.annotion.validator.group.Update;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.RoleView;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 *  @author 小章鱼
 * @date 2021年8月12日
 **/
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "获取角色信息列表", notes = "获取角色信息列表")
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody RoleView roleVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.successWithData(roleService.getPageList(roleVO));
    }


    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody RoleView roleVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return roleService.addRole(roleVO);
    }


    @PostMapping("/edit")
    public String update(@Validated({Update.class}) @RequestBody RoleView roleVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return roleService.editRole(roleVO);
    }


    @PostMapping("/delete")
    public String delete(@Validated({Delete.class}) @RequestBody RoleView roleVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return roleService.deleteRole(roleVO);
    }

}
