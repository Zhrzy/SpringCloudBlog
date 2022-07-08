package com.zy.blog.web.util;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zy.blog.entity.Admin;
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

/**
 * jwt过滤器  该Filter 保证每次请求一定会过滤
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
            System.out.println(userJson);
            Admin user = new Admin();
            user.setUserName(userJson.getString("principal"));
            //获取id
            cn.hutool.json.JSONObject userFromToken= (cn.hutool.json.JSONObject) JSONUtil.parse(userJson.getString("principal"));
            String  userId = userFromToken.get("uid").toString();
            request.setAttribute(SysConf.ADMIN_UID,userId);

            JSONArray authoritiesArray = userJson.getJSONArray("authorities");
            String [] authorities = authoritiesArray.toArray( new
                    String[authoritiesArray.size()]);
            //2.新建并填充authentication
            UsernamePasswordAuthenticationToken authentication = new
                    UsernamePasswordAuthenticationToken(
                    user, null, AuthorityUtils.createAuthorityList(authorities));
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                    request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}
