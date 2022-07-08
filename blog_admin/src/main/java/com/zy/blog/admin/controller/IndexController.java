package com.zy.blog.admin.controller;


import com.zy.blog.service.service.BlogService;
import com.zy.blog.service.service.CommentService;
import com.zy.blog.service.service.UserService;
import com.zy.blog.service.service.WebVisitService;
import com.zy.blog.utils.constant.Constants;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.enums.EStatus;
import com.zy.blog.utils.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页RestApi
 *
 *  @author 小章鱼
 * @date 2021年03月5日
 */
@RestController
@RequestMapping("/index")
@Slf4j
public class IndexController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private WebVisitService webVisitService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String init() {
        Map<String, Object> map = new HashMap<>(Constants.NUM_FOUR);
        map.put(SysConf.BLOG_COUNT, blogService.getBlogCount(EStatus.ENABLE));
        map.put(SysConf.COMMENT_COUNT, commentService.getCommentCount(EStatus.ENABLE));
        map.put(SysConf.USER_COUNT, userService.getUserCount(EStatus.ENABLE));
        map.put(SysConf.VISIT_COUNT, webVisitService.getWebVisitCount());
        return ResultUtil.result(SysConf.SUCCESS, map);
        
    }

    @RequestMapping(value = "/getVisitByWeek", method = RequestMethod.GET)
    public String getVisitByWeek() {
        Map<String, Object> visitByWeek = webVisitService.getVisitByWeek();
        return ResultUtil.result(SysConf.SUCCESS, visitByWeek);
      
    }

    @RequestMapping(value = "/getBlogCountByTag", method = RequestMethod.GET)
    public String getBlogCountByTag() {
        List<Map<String, Object>> blogCountByTag = blogService.getBlogCountByTag();
        return ResultUtil.result(SysConf.SUCCESS, blogCountByTag);
        
    }

    @RequestMapping(value = "/getBlogCountByBlogSort", method = RequestMethod.GET)
    public String getBlogCountByBlogSort() {

        List<Map<String, Object>> blogCountByTag = blogService.getBlogCountByBlogSort();
        return ResultUtil.result(SysConf.SUCCESS, blogCountByTag);
        
    }

    @RequestMapping(value = "/getBlogContributeCount", method = RequestMethod.GET)
    public String getBlogContributeCount() {

        Map<String, Object> resultMap = blogService.getBlogContributeCount();
        return ResultUtil.result(SysConf.SUCCESS, resultMap);
        
    }


}
