package com.zy.blog.admin.controller;

import com.zy.blog.service.service.SystemDictDataService;
import com.zy.blog.utils.ResultUtil1;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.authorityverify.AuthorityVerify;
import com.zy.blog.utils.annotion.validator.group.Delete;
import com.zy.blog.utils.annotion.validator.group.GetList;
import com.zy.blog.utils.annotion.validator.group.Insert;
import com.zy.blog.utils.annotion.validator.group.Update;
import com.zy.blog.utils.constant.MessageConf;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.utils.util.StringUtils;
import com.zy.blog.view.DictView;
import com.zy.blog.view.SysDictDataView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description: 系统字典API
 * @author: 小章鱼
 * @create: 2021-07-28 21:55
 **/

@RestController
@RequestMapping("/dictData")
public class SystemDictDataController {

    @Autowired
    private SystemDictDataService systemDictDataService;

    @PostMapping("/getDictByTypes")
    public String getDictByTypes(@RequestBody List<String> param){
        return ResultUtil1.result("success","成功",systemDictDataService.selectByTypeList(param));
    }

    @PostMapping("/getListByDictType")
    public String getListByDictType(@RequestParam("dictType") String dictType) {
        if (StringUtils.isEmpty(dictType)) {
            return ResultUtil1.result(SysConf.ERROR, MessageConf.OPERATION_FAIL);
        }
        return ResultUtil1.result(SysConf.SUCCESS, systemDictDataService.getListByDictType(dictType));
    }
    @AuthorityVerify
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody SysDictDataView sysDictDataVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);

        return ResultUtil.successWithData(systemDictDataService.getPageList(sysDictDataVO));
    }


    @PostMapping("/add")
    public String add(HttpServletRequest request, @Validated({Insert.class}) @RequestBody SysDictDataView sysDictDataVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return systemDictDataService.addSysDictData(sysDictDataVO);
    }

    @AuthorityVerify
    @PostMapping("/edit")
    public String edit(HttpServletRequest request, @Validated({Update.class}) @RequestBody SysDictDataView sysDictDataVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return systemDictDataService.editSysDictData(sysDictDataVO);
    }

    @AuthorityVerify
    @PostMapping("/deleteBatch")
    public String delete(HttpServletRequest request, @Validated({Delete.class}) @RequestBody List<SysDictDataView> sysDictDataVoList, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return systemDictDataService.deleteBatchSysDictData(sysDictDataVoList);
    }



    @PostMapping("/getListByDictTypeList")
    public String getListByDictTypeList(@RequestBody List<String> dictTypeList) {

        if (dictTypeList.size() <= 0) {
            return ResultUtil.result(SysConf.ERROR, MessageConf.OPERATION_FAIL);
        }
        return ResultUtil.result(SysConf.SUCCESS, systemDictDataService.getListByDictTypeList(dictTypeList));
    }
}
