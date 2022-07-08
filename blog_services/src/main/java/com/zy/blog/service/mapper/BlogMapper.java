package com.zy.blog.service.mapper;

import com.zy.blog.base.SuperMapper;
import com.zy.blog.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author: 小章鱼
 * @description:
 * @date: 2021/8/26 22:30
 **/
@Mapper
public interface BlogMapper extends SuperMapper<Blog> {
    /**
     * 通过标签获取博客数量
     *
     * @return
     */
    @Select("SELECT tag_uid, COUNT(tag_uid) as count FROM  t_blog where status = 1 GROUP BY tag_uid")
    List<Map<String, Object>> getBlogCountByTag();

    /**
     * 通过分类获取博客数量
     *
     * @return
     */
    @Select("SELECT blog_sort_uid, COUNT(blog_sort_uid) AS count FROM  t_blog where status = 1 GROUP BY blog_sort_uid")
    List<Map<String, Object>> getBlogCountByBlogSort();

    /**
     * 获取一年内的文章贡献数
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @Select("SELECT DISTINCT DATE_FORMAT(create_time, '%Y-%m-%d') DATE, COUNT(uid) COUNT FROM t_blog WHERE 1=1 && status = 1 && create_time >= #{startTime} && create_time < #{endTime} GROUP BY DATE_FORMAT(create_time, '%Y-%m-%d')")
    List<Map<String, Object>> getBlogContributeCount(@Param("startTime") String startTime, @Param("endTime") String endTime);

}
