package com.zy.blog.service.mapper;


import com.zy.blog.base.SuperMapper;
import com.zy.blog.entity.CommentReport;
import org.apache.ibatis.annotations.Mapper;

/**
 * 评论举报表 Mapper 接口
 *
 * @author 小章鱼
 * @since 2021-09-04
 */
@Mapper
public interface CommentReportMapper extends SuperMapper<CommentReport> {

}
