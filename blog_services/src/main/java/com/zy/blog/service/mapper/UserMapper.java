package com.zy.blog.service.mapper;



import com.zy.blog.base.SuperMapper;
import com.zy.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author xuzhixiang
 * @since 2021-09-04
 */
@Mapper
public interface UserMapper extends SuperMapper<User> {

}
