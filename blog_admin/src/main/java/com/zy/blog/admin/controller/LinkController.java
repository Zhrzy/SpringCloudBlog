package com.zy.blog.admin.controller;



import com.zy.blog.admin.annotation.OperationLogger.OperationLogger;
import com.zy.blog.service.service.LinkService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.Delete;
import com.zy.blog.utils.annotion.validator.group.GetList;
import com.zy.blog.utils.annotion.validator.group.Insert;
import com.zy.blog.utils.annotion.validator.group.Update;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.LinkView;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 友链表 RestApi
 *
 *
 *  @author 小章鱼
 * @date 2022年02月5日
 */
@RestController
@RequestMapping("/link")
@Slf4j
public class LinkController {

    @Autowired
    LinkService linkService;

    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody LinkView linkVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("获取友链列表");
        return ResultUtil.successWithData(linkService.getPageList(linkVO));
        
    }

    @OperationLogger(value = "增加友链")
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody LinkView linkVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return linkService.addLink(linkVO);
        
    }

    @OperationLogger(value = "编辑友链")
    @PostMapping("/edit")
    public String edit(@Validated({Update.class}) @RequestBody LinkView linkVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return linkService.editLink(linkVO);
        
    }

    @OperationLogger(value = "删除友链")
    @PostMapping("/delete")
    public String delete(@Validated({Delete.class}) @RequestBody LinkView linkVO, BindingResult result) {

        // 参数校验
       ThrowableUtils.checkParamArgument(result);
        return linkService.deleteLink(linkVO);
        
    }

    @PostMapping("/stick")
    public String stick(@Validated({Delete.class}) @RequestBody LinkView linkVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return linkService.stickLink(linkVO);
        
    }
}