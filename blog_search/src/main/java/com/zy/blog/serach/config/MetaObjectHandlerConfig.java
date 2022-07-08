package com.zy.blog.serach.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.zy.blog.utils.constant.SysConf;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Mybatis-plus自动填充
 *
 * @author 小章鱼
 * @date 2021年10月4日10:48:28
 */
@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {

    Logger log = LoggerFactory.getLogger(MetaObjectHandlerConfig.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("插入方法填充");
        setFieldValByName(SysConf.CREATE_TIME, new Date(), metaObject);
        setFieldValByName(SysConf.UPDATE_TIME, new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新方法填充");
        setFieldValByName(SysConf.UPDATE_TIME, new Date(), metaObject);
    }
}
