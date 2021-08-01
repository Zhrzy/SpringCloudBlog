package com.zy.blog.admin.controller;

import com.zy.blog.admin.service.SystemDictDataService;
import com.zy.blog.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 系统字典API
 * @author: ZhangY_ZXY
 * @create: 2021-07-28 21:55
 **/

@RestController
@RequestMapping("/admin/dictData")
public class SystemDictDataController {

    @Autowired
    private SystemDictDataService systemDictDataService;

    @PostMapping("/getDictByTypes")
    public String getDictByTypes(@RequestBody List<String> param){
        return ResultUtil.result("success","成功",systemDictDataService.selectByTypeList(param));

    }
}
