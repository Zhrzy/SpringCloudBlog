package com.zy.blog.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author: 小章鱼
 * @description:
 * @date: 2021/8/1 19:25
 **/
public class ServiceImplBase<M extends SuperMapper<T>, T> extends ServiceImpl<M,T>  implements ServiceBase<T> {
}
