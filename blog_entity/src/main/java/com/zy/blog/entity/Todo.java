package com.zy.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.blog.base.EntityBase;
import lombok.Data;

@Data
@TableName(value = "t_todo")
public class Todo extends EntityBase<Todo> {
    private static final long serialVersionUID = 1L;

    /**
     * 内容
     */
    private String text;

    /**
     * 管理员UID
     */
    private String adminUid;

    /**
     * 表示事项是否完成
     */
    private Boolean done;
}