package com.zy.blog.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
/**
 * 实体类公共字段
 * @author zy 1716457206@qq.com
 */
public class EntityBase<T extends Model> extends Model{
    /**
     * 唯一UID
     */
    @TableId(value = "uid",type = IdType.UUID)
    public String uid;

    /**
     * 状态 0：失效  1：生效
     */
    public int status;

    /**
     * @TableField 配置需要填充的字段
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date updateTime;

    public EntityBase() {
        this.status = 1;
        this.createTime = new Date();
        this.updateTime = new Date();
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
