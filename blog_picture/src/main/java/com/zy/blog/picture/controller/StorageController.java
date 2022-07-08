package com.zy.blog.picture.controller;

import com.zy.blog.entity.NetworkDisk;
import com.zy.blog.entity.Storage;
import com.zy.blog.picture.security.RequestHolder;
import com.zy.blog.picture.service.StorageService;

import com.zy.blog.utils.util.FileUtils;
import com.zy.blog.utils.util.ResultUtil;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2022/3/5 23:50
 **/
@RestController
@RequestMapping("/storage")
public class StorageController {
   /*  @Value(value = "${file.upload.path}")*/
    String path;
    @Resource
    private StorageService storageService;

    /**
     * 初始化容量大小
     *
     * @return
     */
    @PostMapping(value = "/initStorageSize")
    public String initStorageSize(@ApiParam(name = "adminUid", value = "管理员uid") @RequestParam("adminUid") String adminUid,
                                  @ApiParam(name = "maxStorageSize", value = "最大网盘容量 ") @RequestParam(value = "maxStorageSize", defaultValue = "0") Long maxStorageSize) {
        return storageService.initStorageSize(adminUid, maxStorageSize);
    }

    /**
     * 编辑容量大小
     *
     * @return
     */
    @PostMapping(value = "/editStorageSize")
    public String editStorageSize(@ApiParam(name = "adminUid", value = "管理员uid") @RequestParam("adminUid") String adminUid,
                                  @ApiParam(name = "maxStorageSize", value = "最大网盘容量 ") @RequestParam(value = "maxStorageSize", defaultValue = "0") Long maxStorageSize) {
        return storageService.editStorageSize(adminUid, maxStorageSize);
    }

    /**
     * 通过管理员uid，获取存储信息
     *
     * @return
     */
    @RequestMapping(value = "/getStorageByAdminUid", method = RequestMethod.GET)
    public String getStorageByAdminUid(@RequestParam("adminUidList") List<String> adminUidList) {
        List<Storage> storageList = storageService.getStorageByAdminUid(adminUidList);
        return ResultUtil.successWithData(storageList);
    }


    /**
     * 上传文件
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(HttpServletRequest request, NetworkDisk networkDisk) {
        RequestHolder.checkLogin();
        // 获取文件
        List<MultipartFile> fileDatas = FileUtils.getMultipartFileList(request);
        return storageService.uploadFile(networkDisk, fileDatas);
    }

    /**
     * 查询当前用户存储信息
     *
     * @return
     */
    @RequestMapping(value = "/getStorage", method = RequestMethod.GET)
    public String getStorage() {
        RequestHolder.checkLogin();
        Storage storage = storageService.getStorageByAdmin();
        return ResultUtil.successWithData(storage);
    }
}
