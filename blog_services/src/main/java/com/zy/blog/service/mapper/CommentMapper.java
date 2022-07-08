package com.zy.blog.service.mapper;


import com.zy.blog.base.SuperMapper;
import com.zy.blog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * 评论表 Mapper 接口
 *
 * @author 小章鱼
 * @since 2021-09-08
 */
@Mapper
public interface CommentMapper extends SuperMapper<Comment> {

}
