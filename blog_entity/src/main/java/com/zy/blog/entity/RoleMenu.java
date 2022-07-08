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

    public String getRoleUid() {
        return roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }

    public String getMenuUid() {
        return menuUid;
    }

    public void setMenuUid(String menuUid) {
        this.menuUid = menuUid;
    }

    @Override
    public boolean equals(Object o) {
        RoleMenu roleMenu = (RoleMenu) o;
        return this.roleUid.equals(roleMenu.getRoleUid()) && this.menuUid.equals(roleMenu.getMenuUid());
    }

    @Override
    public int hashCode() {
        return (this.roleUid.hashCode()+ this.menuUid.hashCode())<<1;
    }
}