package com.zy.blog.picture.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zy.blog.entity.File;
import com.zy.blog.entity.NetworkDisk;
import com.zy.blog.entity.Storage;
import com.zy.blog.entity.SystemConfig;
import com.zy.blog.picture.config.SQLConf;
import com.zy.blog.picture.mapper.StorageMapper;
import com.zy.blog.picture.security.SecurityUser;
import com.zy.blog.picture.service.FileService;
import com.zy.blog.picture.service.NetworkDiskService;
import com.zy.blog.picture.service.StorageService;
import com.zy.blog.picture.util.FeignUtil;
import com.zy.blog.utils.constant.EStatus;
import com.zy.blog.utils.constant.ErrorCode;
import com.zy.blog.utils.constant.MessageConf;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.exception.type.QueryException;
import com.zy.blog.utils.exception.type.UpdateException;
import com.zy.blog.utils.holder.RequestHolder;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.utils.util.StringUtils;
import com.zy.blog.utils.util.WebUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.zy.blog.base.ServiceImplBase;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文件服务实现类
 *
 * @author 小章鱼
 * @date 2021-09-17
 */
@Slf4j
@RefreshScope
@Service
public class StorageServiceImpl extends ServiceImplBase<StorageMapper, Storage> implements StorageService {

    @Autowired
    private NetworkDiskService networkDiskService;
    @Autowired
    private StorageService storageService;
    @Resource
    private FileService fileService;
    @Autowired
    private FeignUtil feignUtil;

    @Override
    public String initStorageSize(String adminUid, Long maxStorageSize) {
        QueryWrapper<Storage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.ADMIN_UID, adminUid);
        queryWrapper.last(SysConf.LIMIT_ONE);
        Storage storage = storageService.getOne(queryWrapper);
        if (storage != null) {
            return ResultUtil.errorWithMessage(MessageConf.ENTITY_EXIST);
        } else {
            Storage saveStorage = new Storage();
            saveStorage.setAdminUid(adminUid);
            saveStorage.setStorageSize(0L);
            saveStorage.setMaxStorageSize(maxStorageSize);
            saveStorage.insert();
            return ResultUtil.successWithMessage(MessageConf.OPERATION_SUCCESS);
        }
    }

    @Override
    public String editStorageSize(String adminUid, Long maxStorageSize) {
        QueryWrapper<Storage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.ADMIN_UID, adminUid);
        queryWrapper.last(SysConf.LIMIT_ONE);
        Storage storage = storageService.getOne(queryWrapper);
        if (storage == null) {
            // 如果没有分配容量，那么初始化一个为0的
            log.error("未分配存储空间，重新初始化网盘空间！");
            return initStorageSize(adminUid, maxStorageSize);
        } else {
            if (maxStorageSize < storage.getStorageSize()) {
                return ResultUtil.errorWithMessage("网盘容量不能小于当前已用空间");
            }
            storage.setMaxStorageSize(maxStorageSize);
            storage.updateById();
            return ResultUtil.successWithMessage(MessageConf.OPERATION_SUCCESS);
        }
    }

    @Override
    public List<Storage> getStorageByAdminUid(List<String> adminUidList) {
        System.out.println(adminUidList);
        boolean checkSuccess = StringUtils.checkUidList(adminUidList);
        if (!checkSuccess) {
            throw new QueryException(ErrorCode.PARAM_INCORRECT, MessageConf.PARAM_INCORRECT);
        }
        QueryWrapper<Storage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.in(SQLConf.ADMIN_UID, adminUidList);
        List<Storage> storageList = storageService.list(queryWrapper);
        return storageList;
    }

    @Override
    public String uploadFile(NetworkDisk networkDisk, List<MultipartFile> fileDatas) {
        HttpServletRequest request = RequestHolder.getRequest();
        SystemConfig systemConfig = feignUtil.getSystemConfig();
        if (systemConfig == null) {
            throw new QueryException(ErrorCode.SYSTEM_CONFIG_IS_NOT_EXIST, MessageConf.SYSTEM_CONFIG_NOT_EXIST);
        }
        // 计算文件大小
        Long newStorageSize = 0L;
        Long storageSize = 0L;
        for (MultipartFile fileData : fileDatas) {
            newStorageSize += fileData.getSize();
        }
        Storage storage = getStorageByAdmin();
        if (storage != null) {
            storageSize = storage.getStorageSize() + newStorageSize;
            // 判断上传的文件是否超过了剩余空间
            if (storage.getMaxStorageSize() < storageSize) {
                throw new UpdateException(ErrorCode.UPDATE_DEFAULT_ERROR, "上传失败，您可用的空间已经不足！");
            } else {
                storage.setStorageSize(storageSize);
            }
        } else {
            throw new UpdateException(ErrorCode.UPDATE_DEFAULT_ERROR, "上传失败，您没有分配可用的上传空间！");
        }

        // 上传文件
        String result = fileService.batchUploadFile(request, fileDatas, systemConfig);
        List<File> fileList = WebUtils.getAllList(result, File.class);
        List<NetworkDisk> networkDiskList = new ArrayList<>();

        for (File file : fileList) {
            NetworkDisk saveNetworkDisk = new NetworkDisk();
            saveNetworkDisk.setAdminUid(request.getAttribute(SysConf.ADMIN_UID).toString());
            saveNetworkDisk.setFilePath(networkDisk.getFilePath());
            saveNetworkDisk.setQiNiuUrl(file.getQiNiuUrl());
            saveNetworkDisk.setLocalUrl(file.getPicUrl());
            saveNetworkDisk.setMinioUrl(file.getMinioUrl());
            saveNetworkDisk.setFileSize(file.getFileSize());
            saveNetworkDisk.setFileName(file.getPicName());
            saveNetworkDisk.setExtendName(file.getPicExpandedName());
            saveNetworkDisk.setFileOldName(file.getFileOldName());
            saveNetworkDisk.setCreateTime(new Date());
            networkDiskList.add(saveNetworkDisk);
        }

        // 上传文件
        networkDiskService.saveBatch(networkDiskList);
        // 更新容量大小
        storageService.updateById(storage);

        return ResultUtil.successWithMessage(MessageConf.OPERATION_SUCCESS);
    }

    @Override
    public Storage getStorageByAdmin() {
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String adminUid = securityUser.getUid();
        QueryWrapper<Storage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SysConf.STATUS, EStatus.ENABLE);
        queryWrapper.eq(SQLConf.ADMIN_UID, adminUid);
        queryWrapper.last(SysConf.LIMIT_ONE);
        Storage reStorage = storageService.getOne(queryWrapper);
        return reStorage;
    }
}
