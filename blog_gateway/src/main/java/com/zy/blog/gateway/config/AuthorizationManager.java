package com.zy.blog.gateway.config;

import cn.hutool.core.collection.ConcurrentHashSet;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.internal.LinkedTreeMap;
import com.zy.blog.entity.Admin;

import com.zy.blog.entity.CategoryMenu;
import com.zy.blog.entity.Role;
import com.zy.blog.gateway.service.AdminService;
import com.zy.blog.gateway.service.CategoryMenuService;
import com.zy.blog.gateway.service.RoleService;
import com.zy.blog.gateway.util.RedisUtil;
import com.zy.blog.utils.JsonUtils;
import com.zy.blog.utils.constant.*;

import com.zy.blog.utils.enums.EMenuType;
import com.zy.blog.utils.enums.EStatus;
import com.zy.blog.utils.util.CheckUtils;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.utils.util.StringUtils;
import com.zy.blog.utils.util.cache.LRUCache;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author  小章鱼 1716457206@qq.com
 */
@Component
@Slf4j
public class AuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {
    /*测试add*/
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private CategoryMenuService categoryMenuService;

    @Autowired
    private LRUCache<String,Map<String,String>> perCache;


    private Set<String> permitAll = new ConcurrentHashSet<>();
    private static final AntPathMatcher antPathMatcher = new AntPathMatcher();

    public AuthorizationManager (){
        // permitAll.add("/");
        permitAll.add("/error");
        permitAll.add("/admin/admin/login");
        permitAll.add("/oauth/**");
        permitAll.add("/search/**");
        permitAll.add("/picture/**");
        //无需授权
        permitAll.add("/admin/admin/login");
        permitAll.add("/admin/admin/getInfo");
        permitAll.add("/admin/admin/getRouter");
        permitAll.add("/admin/sysConfig/getSystemConfig");
        permitAll.add("/admin/admin/logout");

//        permitAll.add("/favicon.ico");
//        //如果生产环境开启swagger调试
//        permitAll.add("/**/v2/api-docs/**");
//        permitAll.add("/**/swagger-resources/**");
//        permitAll.add("/webjars/**");
//        permitAll.add("/doc.html");
//        permitAll.add("/swagger-ui.html");
//        permitAll.add("/oauth/**");
////        permitAll.add("/admin/**");
////        permitAll.add("/admin/getInfo");
//        permitAll.add("/web/**");
//        permitAll.add(("/*/**"));
    }

    @Override
    public Mono<Void> verify(Mono<Authentication> authentication, AuthorizationContext object) {
        return null;
    }

    /**
     * 校验是否属于静态资源
     * @param requestPath 请求路径
     * @return
     */
    private boolean permitAll(String requestPath) {
        return permitAll.stream()
                .filter(r -> antPathMatcher.match(r, requestPath)).findFirst().isPresent();
    }

    /**
     * 权限校验
     * @author 小章鱼
     * @param auth 用户权限
     * @param requestPath 请求路径
     * @return
     */
    private boolean checkAuthorities(Authentication auth, String requestPath) {
        //白名单放行 不需要校验权限
        if(checkNeedPermission(requestPath))
            return true;
        if(auth instanceof Authentication) {
            requestPath = replacePath(requestPath);
            //获取认证信息
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            Object userinfo = auth.getPrincipal();
            JSONObject jsonObject = JsonUtils.strToJson(JsonUtils.objectToJson(userinfo));
            //获取用户id
            String adminUid = jsonObject.getJSONObject("claims").getString(SQLConf.UID);
            LinkedTreeMap<String, String> visitMap = new LinkedTreeMap<>();
            //先获取本地缓存
            LinkedTreeMap<String,String> local= (LinkedTreeMap<String, String>) perCache.get(RedisConf.ADMIN_VISIT_MENU + RedisConf.SEGMENTATION + adminUid);
            if(local!=null) visitMap= local;
            if(visitMap == null || visitMap.size()==0) {
                //在获取redis缓存
                String visitUrlStr = redisUtil.get(RedisConf.ADMIN_VISIT_MENU + RedisConf.SEGMENTATION + adminUid);
                if (StringUtils.isNotEmpty(visitUrlStr)) {
                    visitMap = (LinkedTreeMap<String, String>) JsonUtils.jsonToMap(visitUrlStr, String.class);
                    perCache.put(RedisConf.ADMIN_VISIT_MENU + RedisConf.SEGMENTATION + adminUid,visitMap);
                } else {
                    //解析角色
                    List<String> listRoleName = authorities.parallelStream()
                            .map(s -> s.getAuthority().replace("role_", "")).parallel().collect(Collectors.toList());
                    Admin admin = adminService.getById(adminUid);
                    QueryWrapper<Role> queryWrapper = new QueryWrapper();
                    queryWrapper.in("role_name", listRoleName);
                    queryWrapper.eq(SQLConf.STATUS, 1);
                    List<Role> roles = roleService.list(queryWrapper);
                    List<String> allMenuUid = new ArrayList<>();
                    for (Role role : roles) {
                        String caetgoryMenuUids = role.getCategoryMenuUids();
                        String[] uids = caetgoryMenuUids.replace("[", "").replace("]", "").replace("\"", "").split(",");
                        List<String> categoryMenuUids = new ArrayList<>(Arrays.asList(uids));
                        allMenuUid.addAll(categoryMenuUids);
                    }
                    //获取按钮也就是接口的菜单数据
                    QueryWrapper<CategoryMenu> buttons = new QueryWrapper<>();
                    buttons.in(SQLConf.UID, allMenuUid);
                    buttons.eq(SQLConf.MENU_TYPE, EMenuType.BUTTON);
                    buttons.eq(SQLConf.STATUS, EStatus.ENABLE);
                    List<CategoryMenu> buttonList = categoryMenuService.list(buttons);
                    //添加到map
                    for (CategoryMenu item : buttonList) {
                        if (StringUtils.isNotEmpty(item.getUrl())) {
                            visitMap.put(item.getUrl(), item.getUrl());
                        }
                    }
                    perCache.put(RedisConf.ADMIN_VISIT_MENU + RedisConf.SEGMENTATION+ adminUid ,visitMap);
                    redisUtil.setEx(RedisConf.ADMIN_VISIT_MENU + SysConf.REDIS_SEGMENTATION + adminUid, JsonUtils.objectToJson(visitMap), 1, TimeUnit.HOURS);
                }
            }

                if (visitMap.get(requestPath) != null) {
                    log.info("用户拥有操作权限，访问的路径: {}，拥有的权限接口：{}", requestPath, visitMap.get(requestPath));
                    //执行业务
                    return true;
                } else {
                    log.info("用户不具有操作权限，访问的路径: {}", requestPath);
                    return false;
                }

        }
        return true;
    }

    public boolean checkNeedPermission(String path){
        return path.contains("/get")||permitAll.contains(path)||path.contains("/picture") ||path.contains("/search") ||path.contains("/oauth");
    }

    public String replacePath(String path){
        String rePath="";
        if (path.startsWith("/admin"))
            rePath = path.replaceFirst("/admin","");
        return rePath;
    }

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();
        String requestPath = request.getURI().getPath();
        PathMatcher pathMatcher = new AntPathMatcher();

        // 对应跨域的预检请求直接放行
        if (request.getMethod() == HttpMethod.OPTIONS) {
            return Mono.just(new AuthorizationDecision(true));
        }

        // 是否直接放行
        if (permitAll(requestPath)) {
            return Mono.just(new AuthorizationDecision(true));
        }

        // token为空拒绝访问
        String token = request.getHeaders().getFirst("Authorization");
        if (StrUtil.isBlank(token)) {
            return Mono.just(new AuthorizationDecision(false));
        }

     /*   Mono<AuthorizationDecision> authorizationDecisionMono = mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(roleId -> {
                    // roleId是请求用户的角色(格式:ROLE_{roleId})，authorities是请求资源所需要角色的集合
                    log.info("访问路径：{}", path);
                    log.info("用户角色信息：{}", roleId);
                    log.info("资源需要权限authorities：{}", authorities);
                    return authorities.contains(roleId);
                })
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));
        return authorizationDecisionMono;*/

        return mono.map(auth -> {
            return new AuthorizationDecision(checkAuthorities(auth, requestPath));
        }).defaultIfEmpty(new AuthorizationDecision(false));

    }
}
