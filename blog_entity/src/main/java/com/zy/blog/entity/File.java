package com.zy.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.blog.base.EntityBase;
import lombok.Data;


/**
 * @description:
 * @author: 小章鱼
 * @date: 2021/9/28 16:13
 **/

@TableName("t_file")
@Data
public class File extends EntityBase<File> {

    private static final long serialVersionUID = 1L;

    private String fileOldName;

    private Long fileSize;

    private String fileSortUid;

    /**
     * 图片扩展名
     */
    private String picExpandedName;

    /**
     * 图片名称
     */
    private String picName;

    /**
     * 图片url地址
     */
    private String picUrl;

    /**
     * 管理员Uid
     */
    private String adminUid;

    /**
     * 用户Uid
     */
    private String userUid;

    /**
     * 七牛云Url
     */
    private String qiNiuUrl;

    /**
     * Minio文件URL
     */
    private String minioUrl;
}
