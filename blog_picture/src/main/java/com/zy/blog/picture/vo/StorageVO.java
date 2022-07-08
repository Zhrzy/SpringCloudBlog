package com.zy.blog.picture.vo;


import com.zy.blog.base.ViewBase;
import lombok.Data;

/**
 * CommentVO
 *
 * @author: 小章鱼
 * @create: 2022年3月11日
 */
@Data
public class StorageVO extends ViewBase<StorageVO> {

    /**
     * 管理员UID
     */
    private String adminUid;

    /**
     * 存储大小
     */
    private long storagesize;
}
