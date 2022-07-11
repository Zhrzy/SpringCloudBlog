package com.zy.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zy.blog.base.EntityBase;
import lombok.Data;

import java.util.Objects;

@Data
@TableName(value = "t_role_menu")
public class RoleMenu extends EntityBase<RoleMenu> {
    private static final long serialVersionUID = 1L;
    private String roleUid;

    private String menuUid;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


}