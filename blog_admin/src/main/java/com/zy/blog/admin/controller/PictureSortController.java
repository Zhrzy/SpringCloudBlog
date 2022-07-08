package com.zy.blog.admin.controller;


import com.zy.blog.admin.annotation.OperationLogger.OperationLogger;
import com.zy.blog.entity.PictureSort;
import com.zy.blog.service.service.PictureSortService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.*;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.PictureSortView;
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
 * 图片分类表 RestApi
 *
 *  @author 小章鱼
 * @date 2021年10月2日
 */
@Api(value = "图片分类相关接口", tags = {"图片分类相关接口"})
@RestController
@RequestMapping("/pictureSort")
@Slf4j
public class PictureSortController {

    @Autowired
    private PictureSortService pictureSortService;

    @ApiOperation(value = "获取图片分类列表", notes = "获取图片分类列表", response = String.class)
    @PostMapping(value = "/getList")
    public String getList(@Validated({GetList.class}) @RequestBody PictureSortView PictureSortView, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("获取图片分类列表: {}", PictureSortView);
        return ResultUtil.result(SysConf.SUCCESS, pictureSortService.getPageList(PictureSortView));
        
    }

    @OperationLogger(value = "增加图片分类")
    @ApiOperation(value = "增加图片分类", notes = "增加图片分类", response = String.class)
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody PictureSortView PictureSortView, BindingResult result) {
        // 参数校验
       ThrowableUtils.checkParamArgument(result);
        log.info("增加图片分类: {}", PictureSortView);
        return pictureSortService.addPictureSort(PictureSortView);

        
    }

    @OperationLogger(value = "编辑图片分类")
    @ApiOperation(value = "编辑图片分类", notes = "编辑图片分类", response = String.class)
    @PostMapping("/edit")
    public String edit(@Validated({Update.class}) @RequestBody PictureSortView PictureSortView, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("编辑图片分类: {}", PictureSortView);
        return pictureSortService.editPictureSort(PictureSortView);
        
    }

    @OperationLogger(value = "删除图片分类")
    @ApiOperation(value = "删除图片分类", notes = "删除图片分类", response = String.class)
    @PostMapping("/delete")
    public String delete(@Validated({Delete.class}) @RequestBody PictureSortView PictureSortView, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("删除图片分类: {}", PictureSortView);
        return pictureSortService.deletePictureSort(PictureSortView);
        
    }

    @OperationLogger(value = "置顶分类")
    @ApiOperation(value = "置顶分类", notes = "置顶分类", response = String.class)
    @PostMapping("/stick")
    public String stick(@Validated({Delete.class}) @RequestBody PictureSortView PictureSortView, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("置顶图片分类: {}", PictureSortView);
        return pictureSortService.stickPictureSort(PictureSortView);
        
    }

    /*@OperationLogger(value = "通过Uid获取分类")
    @ApiOperation(value = "通过Uid获取分类", notes = "通过Uid获取分类", response = String.class)*/
    @PostMapping("/getPictureSortByUid")
    public String getPictureSortByUid(@Validated({Delete.class}) @RequestBody PictureSortView PictureSortView, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        PictureSort pictureSort = pictureSortService.getById(PictureSortView.getUid());
        return ResultUtil.successWithData(pictureSort);
        
    }
}

