package com.zy.blog.admin.controller;



import com.zy.blog.service.service.WebVisitService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.GetList;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.WebVisitView;
/*import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;*/
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


/**
 * 用户访问表 RestApi
 *
 * @author 小章鱼
 * @date 2019年5月17日08:38:09
 */
@Api(value = "用户访问相关接口", tags = {"用户访问相关接口"})
@RestController
@RequestMapping("/webVisit")
@Slf4j
public class WebVisitController {

    @Autowired
    private WebVisitService webVisitService;

    @ApiOperation(value = "获取用户访问列表", notes = "获取用户访问列表")
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody WebVisitView webVisitVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.result(SysConf.SUCCESS, webVisitService.getPageList(webVisitVO));

    }
}

