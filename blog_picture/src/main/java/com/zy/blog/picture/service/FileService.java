package com.zy.blog.picture.service;

import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.File;
import com.zy.blog.entity.SystemConfig;
import com.zy.blog.view.FileView;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2022/6/2 0:22
 **/
public interface FileService extends ServiceBase<File> {
    /**
     * 截图上传
     *
     * @param multipartFileList
     * @return
     */
    public String cropperPicture(List<MultipartFile> multipartFileList);

    /**
     * 通过fileIds获取图片信息
     *
     * @param fileIds
     * @param code
     * @return
     */
    public String getPicture(String fileIds, String code);

    /**
     * 批量文件上传
     *
     * @param request
     * @param multipartFileList
     * @param systemConfig
     * @return
     */
    String batchUploadFile(HttpServletRequest request, List<MultipartFile> multipartFileList, SystemConfig systemConfig);

    /**
     * 通过URL上传图片
     *
     * @param fileVO
     * @return
     */
    String uploadPictureByUrl(FileView fileVO);

    /**
     * CKeditor图像中的图片上传
     *
     * @param request
     * @return
     */
    Object ckeditorUploadFile(HttpServletRequest request);

    /**
     * CKeditor上传 复制的图片
     *
     * @return
     */
    Object ckeditorUploadCopyFile();

    /**
     * 工具栏 “插入\编辑超链接”的文件上传
     *
     * @return
     */
    Object ckeditorUploadToolFile(HttpServletRequest request);
}
