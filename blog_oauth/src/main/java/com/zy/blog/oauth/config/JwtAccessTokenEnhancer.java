package com.zy.blog.oauth.config;

import com.zy.blog.oauth.service.SecurityUser;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @description:  jwt增强  认证服务重构
 * @author: 小章鱼
 * @date: 2022/6/22 0:27
 **/
public class JwtAccessTokenEnhancer extends JwtAccessTokenConverter {
    @Override
    protected String encode(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        SecurityUser user = (SecurityUser)authentication.getUserAuthentication().getPrincipal();
        LinkedHashMap<String, Object> ex = new LinkedHashMap<String, Object>();
        //实现jwt扩展
        ex.put("uid", user.getUid());//id
        ex.put("avatar", user.getAvatar());//头像
        ex.put("jti",((DefaultOAuth2AccessToken)accessToken).getAdditionalInformation().get("jti").toString());
        ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(ex);
        return super.encode(accessToken, authentication);
    }
}
