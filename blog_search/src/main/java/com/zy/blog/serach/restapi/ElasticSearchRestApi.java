package com.zy.blog.serach.restapi;


import com.zy.blog.commons.feign.WebFeignClient;
import com.zy.blog.entity.Blog;
import com.zy.blog.serach.pojo.ESBlogIndex;
import com.zy.blog.serach.repository.BlogRepository;
import com.zy.blog.serach.service.ElasticSearchService;
import com.zy.blog.utils.constant.MessageConf;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.utils.util.StringUtils;
import com.zy.blog.utils.util.WebUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ElasticSearch RestAPI
 *
 * @author: 小章鱼
 * @create: 2022年4月15日16:26:16
 */
@RequestMapping("/search")
@Api(value = "ElasticSearch相关接口", tags = {"ElasticSearch相关接口"})
@RestController
public class ElasticSearchRestApi {

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Autowired
    private ElasticSearchService searchService;
    @Autowired
    private BlogRepository blogRepository;
    @Resource
    private WebFeignClient webFeignClient;


    @ApiOperation(value = "通过ElasticSearch搜索博客", notes = "通过ElasticSearch搜索博客", response = String.class)
    @GetMapping("/elasticSearchBlog")
    public String searchBlog(HttpServletRequest request,
                             @RequestParam(required = false) String keywords,
                             @RequestParam(name = "currentPage", required = false, defaultValue = "1") Integer
                                     currentPage,
                             @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer
                                     pageSize) {

        if (StringUtils.isEmpty(keywords)) {
            return ResultUtil.result(SysConf.ERROR, MessageConf.KEYWORD_IS_NOT_EMPTY);
        }
        keywords = QueryParser.escape(keywords);
        return ResultUtil.result(SysConf.SUCCESS, searchService.search(keywords, currentPage, pageSize));
    }

    @ApiOperation(value = "通过uids删除ElasticSearch博客索引", notes = "通过uids删除ElasticSearch博客索引", response = String.class)
    @PostMapping("/deleteElasticSearchByUids")
    public String deleteElasticSearchByUids(@RequestParam(required = true, value = "uid") String uids) {

        List<String> uidList = StringUtils.changeStringToString(uids, SysConf.FILE_SEGMENTATION);

        for (String uid : uidList) {
            blogRepository.deleteById(uid);
        }

        return ResultUtil.result(SysConf.SUCCESS, MessageConf.DELETE_SUCCESS);
    }

    @ApiOperation(value = "通过博客uid删除ElasticSearch博客索引", notes = "通过uid删除博客", response = String.class)
    @PostMapping("/deleteElasticSearchByUid")
    public String deleteElasticSearchByUid(@RequestParam(required = true) String uid) {
        blogRepository.deleteById(uid);
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.DELETE_SUCCESS);
    }

    @ApiOperation(value = "ElasticSearch通过博客Uid添加索引", notes = "添加博客", response = String.class)
    @PostMapping("/addElasticSearchIndexByUid")
    public String addElasticSearchIndexByUid(@RequestParam(required = true) String uid) {
        String result = webFeignClient.getBlogByUid(uid);
        Blog eblog = WebUtils.getData(result, Blog.class);
        if (eblog == null) {
            return ResultUtil.result(SysConf.ERROR, MessageConf.INSERT_FAIL);
        }
        ESBlogIndex blog = searchService.buidBlog(eblog);
        blogRepository.save(blog);
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.INSERT_SUCCESS);
    }

    @ApiOperation(value = "ElasticSearch初始化索引", notes = "ElasticSearch初始化索引", response = String.class)
    @PostMapping("/initElasticSearchIndex")
    public String initElasticSearchIndex() throws ParseException {
        elasticsearchRestTemplate.deleteIndex(ESBlogIndex.class);
        elasticsearchRestTemplate.createIndex(ESBlogIndex.class);
        elasticsearchRestTemplate.putMapping(ESBlogIndex.class);

        Long page = 1L;
        Long row = 10L;
        Integer size = 0;

        do {
            // 查询blog信息
            String result = webFeignClient.getBlogBySearch(page, row);

            //构建blog
            List<Blog> blogList = WebUtils.getList(result, Blog.class);
            size = blogList.size();

            List<ESBlogIndex> esBlogIndexList = blogList.stream()
                    .map(searchService::buidBlog).collect(Collectors.toList());

            //存入索引库
            blogRepository.saveAll(esBlogIndexList);
            System.out.println("第几条"+page+","+esBlogIndexList.size());
            // 翻页
            page++;
        } while (size == 15);

        return ResultUtil.result(SysConf.SUCCESS, MessageConf.OPERATION_SUCCESS);
    }
}
