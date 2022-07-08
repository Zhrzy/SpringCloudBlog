package com.zy.blog.securityconfig;

/**
 * @description: 认证重构
 * @author: 小章鱼
 * @date: 2022/6/26 21:02
 **/
public class CurentUser {
   private static ThreadLocal<SecurityUser> threadLocalUserInfo  =new ThreadLocal();

    public static void setUser(SecurityUser user){
        threadLocalUserInfo.set(user);
        SecurityUser s = threadLocalUserInfo.get();
    }

    public static SecurityUser getSecurityUser(){
        return threadLocalUserInfo.get();
    }

    public static String getUid(){
        return threadLocalUserInfo.get().getUid().toString();
    }

    public static String getName(){
        return threadLocalUserInfo.get().getUsername().toString();
    }

    public static void remove(){
        threadLocalUserInfo.remove();
    }
}
