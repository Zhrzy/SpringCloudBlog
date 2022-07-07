package com.zy.blog.oauth.service;


import com.zy.blog.entity.Admin;
import com.zy.blog.utils.constant.EStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity用户工厂类
 *
 * @author 小章鱼
 * @date: 2022/6/22 2:13
 */
public final class SecurityUserFactory {

    private SecurityUserFactory() {
    }

    /**
     * 通过管理员Admin，生成一个SpringSecurity用户
     *
     * @param admin
     * @return
     */
    public static SecurityUser create(Admin admin) {
        boolean enabled = admin.getStatus() == EStatus.ENABLE;
        return new SecurityUser(
                admin.getUid(),
                admin.getUserName(),
                admin.getPassWord(),
                enabled,
                mapToGrantedAuthorities(admin.getRoleNames())
                ,admin.getAvatar()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

}
