package com.zy.blog.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.blog.base.ServiceImplBase;
import com.zy.blog.commons.feign.PictureFeignClient;
import com.zy.blog.entity.ResourceSort;
import com.zy.blog.entity.StudyVideo;
import com.zy.blog.service.mapper.ResourceSortMapper;
import com.zy.blog.service.netutils.WebUtil;
import com.zy.blog.service.service.ResourceSortService;
import com.zy.blog.service.service.StudyVideoService;
import com.zy.blog.utils.constant.BaseSQLConf;
import com.zy.blog.utils.constant.BaseSysConf;
import com.zy.blog.utils.constant.MessageConf;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.enums.EStatus;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.utils.util.StringUtils;
import com.zy.blog.view.ResourceSortView;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 资源分类表 服务实现类
 *
 * @author 小章鱼
 * @since 2021-09-04
 */
@Service
public class ResourceSortServiceImpl extends ServiceImplBase<ResourceSortMapper, ResourceSort> implements ResourceSortService {

    @Resource
    private ResourceSortService resourceSortService;

    @Resource
    private StudyVideoService studyVideoService;

    @Resource
    private PictureFeignClient pictureFeignClient;

    @Resource
    private WebUtil webUtil;

    @Override
    public IPage<ResourceSort> getPageList(ResourceSortView resourceSortVO) {
        QueryWrapper<ResourceSort> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(resourceSortVO.getKeyword()) && !StringUtils.isEmpty(resourceSortVO.getKeyword().trim())) {
            queryWrapper.like(BaseSQLConf.SORT_NAME, resourceSortVO.getKeyword().trim());
        }
        Page<ResourceSort> page = new Page<>();
        page.setCurrent(resourceSortVO.getCurrentPage());
        page.setSize(resourceSortVO.getPageSize());
        queryWrapper.eq(BaseSQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.orderByDesc(BaseSQLConf.SORT);
        IPage<ResourceSort> pageList = resourceSortService.page(page, queryWrapper);
        List<ResourceSort> list = pageList.getRecords();

        final StringBuffer fileUids = new StringBuffer();
        list.forEach(item -> {
            if (StringUtils.isNotEmpty(item.getFileUid())) {
                fileUids.append(item.getFileUid() + BaseSysConf.FILE_SEGMENTATION);
            }
        });
        String pictureResult = null;
        Map<String, String> pictureMap = new HashMap<>();

        if (fileUids != null) {
            pictureResult = this.pictureFeignClient.getPicture(fileUids.toString(), BaseSysConf.FILE_SEGMENTATION);
        }
        List<Map<String, Object>> picList = webUtil.getPictureMap(pictureResult);

        picList.forEach(item -> {
            pictureMap.put(item.get(SysConf.UID).toString(), item.get(SysConf.URL).toString());
        });

        for (ResourceSort item : list) {
            //获取图片
            if (StringUtils.isNotEmpty(item.getFileUid())) {
                List<String> pictureUidsTemp = StringUtils.changeStringToString(item.getFileUid(), BaseSysConf.FILE_SEGMENTATION);
                List<String> pictureListTemp = new ArrayList<>();
                pictureUidsTemp.forEach(picture -> {
                    pictureListTemp.add(pictureMap.get(picture));
                });
                item.setPhotoList(pictureListTemp);
            }
        }
        pageList.setRecords(list);
        return pageList;
    }

    @Override
    public String addResourceSort(ResourceSortView resourceSortVO) {
        /**
         * 判断需要增加的分类是否存在
         */
        QueryWrapper<ResourceSort> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(BaseSQLConf.SORT_NAME, resourceSortVO.getSortName());
        queryWrapper.eq(BaseSQLConf.STATUS, EStatus.ENABLE);
        ResourceSort tempSort = resourceSortService.getOne(queryWrapper);
        if (tempSort != null) {
            return ResultUtil.errorWithMessage(MessageConf.ENTITY_EXIST);
        }

        ResourceSort resourceSort = new ResourceSort();
        resourceSort.setSortName(resourceSortVO.getSortName());
        resourceSort.setContent(resourceSortVO.getContent());
        resourceSort.setFileUid(resourceSortVO.getFileUid());
        resourceSort.setSort(resourceSortVO.getSort());
        resourceSort.setStatus(EStatus.ENABLE);
        resourceSort.insert();
        return ResultUtil.successWithMessage(MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String editResourceSort(ResourceSortView resourceSortVO) {

        ResourceSort resourceSort = resourceSortService.getById(resourceSortVO.getUid());
        /**
         * 判断需要编辑的分类是否存在
         */
        if (!resourceSort.getSortName().equals(resourceSortVO.getSortName())) {
            QueryWrapper<ResourceSort> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(BaseSQLConf.SORT_NAME, resourceSortVO.getSortName());
            queryWrapper.eq(BaseSQLConf.STATUS, EStatus.ENABLE);
            ResourceSort tempSort = resourceSortService.getOne(queryWrapper);
            if (tempSort != null) {
                return ResultUtil.errorWithMessage(MessageConf.ENTITY_EXIST);
            }
        }

        resourceSort.setSortName(resourceSortVO.getSortName());
        resourceSort.setContent(resourceSortVO.getContent());
        resourceSort.setFileUid(resourceSortVO.getFileUid());
        resourceSort.setSort(resourceSortVO.getSort());
        resourceSort.setUpdateTime(new Date());
        resourceSort.updateById();
        return ResultUtil.successWithMessage(MessageConf.UPDATE_SUCCESS);
    }

    @Override
    public String deleteBatchResourceSort(List<ResourceSortView> resourceSortVOList) {
        if (resourceSortVOList.size() <= 0) {
            return ResultUtil.errorWithMessage(MessageConf.PARAM_INCORRECT);
        }
        List<String> uids = new ArrayList<>();
        resourceSortVOList.forEach(item -> {
            uids.add(item.getUid());
        });

        // 判断要删除的分类，是否有资源
        QueryWrapper<StudyVideo> studyVideoQueryWrapper = new QueryWrapper<>();
        studyVideoQueryWrapper.eq(BaseSQLConf.STATUS, EStatus.ENABLE);
        studyVideoQueryWrapper.in(BaseSQLConf.RESOURCE_SORT_UID, uids);
        Integer count = studyVideoService.count(studyVideoQueryWrapper);
        if (count > 0) {
            return ResultUtil.errorWithMessage(MessageConf.RESOURCE_UNDER_THIS_SORT);
        }
        Collection<ResourceSort> resourceSortList = resourceSortService.listByIds(uids);

        resourceSortList.forEach(item -> {
            item.setUpdateTime(new Date());
            item.setStatus(EStatus.DISABLED);
        });

        Boolean save = resourceSortService.updateBatchById(resourceSortList);

        if (save) {
            return ResultUtil.successWithMessage(MessageConf.DELETE_SUCCESS);
        } else {
            return ResultUtil.errorWithMessage(MessageConf.DELETE_FAIL);
        }
    }

    @Override
    public String stickResourceSort(ResourceSortView resourceSortVO) {
        ResourceSort resourceSort = resourceSortService.getById(resourceSortVO.getUid());

        //查找出最大的那一个
        QueryWrapper<ResourceSort> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc(BaseSQLConf.SORT);
        Page<ResourceSort> page = new Page<>();
        page.setCurrent(0);
        page.setSize(1);
        IPage<ResourceSort> pageList = resourceSortService.page(page, queryWrapper);
        List<ResourceSort> list = pageList.getRecords();
        ResourceSort maxSort = list.get(0);

        if (StringUtils.isEmpty(maxSort.getUid())) {
            return ResultUtil.errorWithMessage(MessageConf.PARAM_INCORRECT);
        }
        if (maxSort.getUid().equals(resourceSort.getUid())) {
            return ResultUtil.errorWithMessage(MessageConf.THIS_SORT_IS_TOP);
        }

        Integer sortCount = maxSort.getSort() + 1;

        resourceSort.setSort(sortCount);
        resourceSort.setUpdateTime(new Date());
        resourceSort.updateById();

        return ResultUtil.successWithMessage(MessageConf.OPERATION_SUCCESS);
    }
}
