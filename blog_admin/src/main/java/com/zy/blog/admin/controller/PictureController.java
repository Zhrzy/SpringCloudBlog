package com.zy.blog.admin.controller;


import com.zy.blog.admin.annotation.OperationLogger.OperationLogger;
import com.zy.blog.service.service.PictureService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.GetList;
import com.zy.blog.utils.annotion.validator.group.Insert;
import com.zy.blog.utils.annotion.validator.group.Update;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.PictureView;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 图片表 RestApi
 *
 *  @author 小章鱼
 * @date 2021年10月2日
 */
@RestController
@RequestMapping("/picture")
@Slf4j
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @PostMapping(value = "/getList")
    public String getList(@Validated({GetList.class}) @RequestBody PictureView pictureVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("获取图片列表:", pictureVO);
        return ResultUtil.successWithData(pictureService.getPageList(pictureVO));
    }


    @OperationLogger(value = "增加图片")
    @ApiOperation(value = "增加图片", notes = "增加图片", response = String.class)
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody List<PictureView> pictureVOList, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("添加图片:", pictureVOList);
        return pictureService.addPicture(pictureVOList);

    }

    @OperationLogger(value = "编辑图片")
    @ApiOperation(value = "编辑图片", notes = "编辑图片", response = String.class)
    @PostMapping("/edit")
    public String edit(@Validated({Update.class}) @RequestBody PictureView pictureVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("编辑图片:{}", pictureVO);
        return pictureService.editPicture(pictureVO);

    }

    @OperationLogger(value = "删除图片")
    @ApiOperation(value = "删除图片", notes = "删除图片", response = String.class)
    @PostMapping("/delete")
    public String delete(@RequestBody PictureView pictureVO) {
        log.info("删除图片:{}", pictureVO);
        return pictureService.deleteBatchPicture(pictureVO);
    }

    @OperationLogger(value = "通过图片Uid将图片设为封面")
    @ApiOperation(value = "通过图片Uid将图片设为封面", notes = "通过图片Uid将图片设为封面", response = String.class)
    @PostMapping("/setCover")
    public String setCover(@Validated({Update.class}) @RequestBody PictureView pictureVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("设置图片分类封面:{}", pictureVO);
        return pictureService.setPictureCover(pictureVO);
    }
}

