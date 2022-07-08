package com.zy.blog.web.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * SpringSecurity中的用户实体类
 *
 * @author 小章鱼
 * @date 2021年9月19日21:43:47
 */
public class SecurityUser implements UserDetails {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final String uid;
    //用户
    private final String username;
    //密码
    private final String password;
    private final boolean enabled;
    private final Collection<? extends GrantedAuthority> authorities;

    public String getJti() {
        return jti;
    }

    private String jti;

    public String getAvatar() {
        return avatar;
    }
    private final String avatar;

    public SecurityUser(
            String uid,
            String username,
            String password,
            boolean enabled,
            Collection<? extends GrantedAuthority> authorities,
            String avatar,
            String jti
            ) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
        this.avatar=avatar;
        this.jti=jti;
    }

    /**
     * 返回分配给用户的角色列表
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    public String getUid() {
        return uid;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 账户是否激活
     *
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * 账户是否未过期
     *
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否未锁定
     *
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否未过期
     *
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}

