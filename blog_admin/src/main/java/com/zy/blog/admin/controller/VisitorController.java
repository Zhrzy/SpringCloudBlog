package com.zy.blog.admin.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 游客表 RestApi
 *
 * @author 小章鱼
 * @date 2021-09-08
 */
@RestController
@RequestMapping("/visitor")
@Api(value = "游客相关接口", tags = {"游客相关接口"})
@Slf4j
public class VisitorController {

}

