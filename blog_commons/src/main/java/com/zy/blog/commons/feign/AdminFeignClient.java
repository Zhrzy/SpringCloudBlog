package com.zy.blog.commons.feign;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 后台服务feign远程调用
 *
 * @author 小章鱼
 * @date 2021年1月21日22:19:10
 */
@Component
@FeignClient(name = "blog-admin")
public interface AdminFeignClient {


    /**
     * 获取系统配置信息
     */
    @RequestMapping(value = "/sysConfig/getSystemConfig", method = RequestMethod.GET)
    public String getSystemConfig();

}