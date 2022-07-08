package com.zy.blog.entity;

import lombok.Data;


/**
 * @description:当前在线的管理员【不持久化到数据库，只存储在Redis中】
 * @author: 小章鱼
 * @date: 2021/9/28 16:13
 **/
@Data
public class OnlineAdmin {
    /**
     * 会话编号
     */
    private String tokenId;

    /**
     * 用户Token
     */
    private String token;

    /**
     * 管理员的UID
     */
    private String adminUid;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地址
     */
    private String loginLocation;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 登录时间
     */
    private String loginTime;

    /**
     * 过期时间
     */
    private String expireTime;
}
