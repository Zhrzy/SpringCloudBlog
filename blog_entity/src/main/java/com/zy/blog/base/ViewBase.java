package com.zy.blog.base;

/**
 * @description: 表现层基类对象
 * @author: 小章鱼
 * @create: 2021-07-28 22:02
 **/

public class ViewBase<T> extends Page<T> {

    public String uid;

    /**
     * 状态 0：失效  1：生效
     */
    public int status;

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
}
