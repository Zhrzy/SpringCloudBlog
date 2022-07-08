package com.zy.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.blog.base.EntityBase;
import lombok.Data;

/**
 * @description:
 * <p>
 *   存储信息实体类
 *  </p>
 * @author: 小章鱼
 * @date: 2021/9/28 16:16
 **/
@TableName("t_storage")
@Data
public class Storage extends EntityBase<Storage> {
    private static final long serialVersionUID = 1L;
    /**
     * 管理员UID
     */
    private String adminUid;

    /**
     * 当前网盘容量
     */
    private long storageSize;

    /**
     * 最大网盘容量
     */
    private long maxStorageSize;
}
