package com.zy.blog.web.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zy.blog.utils.constant.SysConf;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * jwt过滤器    该Filter 保证每次请求一定会过滤
 * @author  小章鱼 1716457206@qq.com
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //得到请求头信息authorization信息
        String json = request.getHeader("json_token");
        //请求头 'Authorization': tokenHead + token
        if (json != null) {
            JSONObject userJson = JSON.parseObject(json);
            JSONArray authoritiesArray = userJson.getJSONArray("authorities");
            String [] authorities = authoritiesArray.toArray( new
                    String[authoritiesArray.size()]);
            List<String> list = new ArrayList<>();
            List<String> author = Arrays.asList(authorities);
            String  userId = userJson.get("uid").toString();
            request.setAttribute(SysConf.ADMIN_UID,userId);
            SecurityUser userDetails = new SecurityUser(
                    userJson.get("uid").toString(),
                    userJson.get("user_name").toString(),
                    "",
                    true,
                    null,
                    userJson.get("avatar").toString(),
                    userJson.get("jti").toString()
            );
            //2.新建并填充authentication
            UsernamePasswordAuthenticationToken authentication = new
                    UsernamePasswordAuthenticationToken(
                    userDetails, null, AuthorityUtils.createAuthorityList(authorities));
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                    request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}
