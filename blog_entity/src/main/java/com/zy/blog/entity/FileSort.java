package com.zy.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.blog.base.EntityBase;
import lombok.Data;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2021/9/28 16:13
 **/

@TableName("t_file_sort")
@Data
public class FileSort extends EntityBase<FileSort> {

    private static final long serialVersionUID = 1L;

    /**
     * 项目名
     */
    private String projectName;

    /**
     * 模块分类名
     */
    private String sortName;

    /**
     * 存储路径
     */
    private String url;
}
