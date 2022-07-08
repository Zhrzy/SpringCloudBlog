package com.zy.blog.commons.fallback;

import com.zy.blog.commons.feign.OauthFeignService;
import com.zy.blog.utils.util.ResultUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2022/6/25 9:13
 **/
@Component
public class OauthFeignServiceFallback implements OauthFeignService {
    @Override
    public Object oauthToken(MultiValueMap<String, String> map) {
        //        HttpServletRequest request = RequestHolder.getRequest();
//        StringBuffer requestURL = request.getRequestURL();
//        log.error("图片服务出现异常，服务降级返回，请求路径: {}", requestURL);\
        System.out.println("哈哈");
        return ResultUtil.errorWithMessage("认证服务返回错误信息");
    }

    @Override
    public String getTokenInfo(String token) {
        return null;
    }
}
