package com.zy.blog.serach.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;
import java.util.List;

/**
 * ESBlogIndex ES索引
 *
 *  @author 小章鱼
 *  @date 2022年4月29日20:20:14
 */


@Data
@Document(indexName = "blog", shards = 1, replicas = 0)
public class ESBlogIndex {
    @Id
    private String id;

    private String uid;

    private Integer oid;

    private String type;

    private String title;

    private String summary;

    private String content;

    private String blogSortName;

    private String blogSortUid;

    private String isPublish;

    private Date createTime;

    private String author;

    private String photoUrl;

    private List<String> tagUidList;

    private List<String> tagNameList;


}
