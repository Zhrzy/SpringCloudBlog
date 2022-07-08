package com.zy.blog.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.blog.base.ServiceImplBase;
import com.zy.blog.commons.feign.PictureFeignClient;
import com.zy.blog.entity.ResourceSort;
import com.zy.blog.entity.StudyVideo;
import com.zy.blog.service.mapper.StudyVideoMapper;
import com.zy.blog.service.netutils.WebUtil;
import com.zy.blog.service.service.ResourceSortService;
import com.zy.blog.service.service.StudyVideoService;
import com.zy.blog.utils.constant.MessageConf;
import com.zy.blog.utils.constant.SQLConf;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.enums.EStatus;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.utils.util.StringUtils;
import com.zy.blog.view.StudyVideoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 学习视频表 服务实现类
 *
 * @author 小章鱼
 * @date 2021-09-04
 */
@Service
public class StudyVideoServiceImpl extends ServiceImplBase<StudyVideoMapper, StudyVideo> implements StudyVideoService {

    @Autowired
    private WebUtil webUtil;

    @Autowired
    private StudyVideoService studyVideoService;

    @Autowired
    private ResourceSortService resourceSortService;

    @Resource
    private PictureFeignClient pictureFeignClient;

    @Override
    public IPage<StudyVideo> getPageList(StudyVideoView studyVideoVO) {
        QueryWrapper<StudyVideo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(studyVideoVO.getKeyword()) && !StringUtils.isEmpty(studyVideoVO.getKeyword().trim())) {
            queryWrapper.like(SQLConf.NAME, studyVideoVO.getKeyword().trim());
        }

        Page<StudyVideo> page = new Page<>();
        page.setCurrent(studyVideoVO.getCurrentPage());
        page.setSize(studyVideoVO.getPageSize());
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.orderByDesc(SQLConf.CREATE_TIME);
        IPage<StudyVideo> pageList = studyVideoService.page(page, queryWrapper);
        List<StudyVideo> list = pageList.getRecords();

        final StringBuffer fileUids = new StringBuffer();
        list.forEach(item -> {
            if (StringUtils.isNotEmpty(item.getFileUid())) {
                fileUids.append(item.getFileUid() + SysConf.FILE_SEGMENTATION);
            }
        });
        String pictureResult = null;
        Map<String, String> pictureMap = new HashMap<>();
        if (fileUids != null) {
            pictureResult = this.pictureFeignClient.getPicture(fileUids.toString(), SysConf.FILE_SEGMENTATION);
        }
        List<Map<String, Object>> picList = webUtil.getPictureMap(pictureResult);
        picList.forEach(item -> {
            pictureMap.put(item.get(SysConf.UID).toString(), item.get(SysConf.URL).toString());
        });

        for (StudyVideo item : list) {
            //获取分类资源
            if (StringUtils.isNotEmpty(item.getFileUid())) {
                List<String> pictureUidsTemp = StringUtils.changeStringToString(item.getFileUid(), SysConf.FILE_SEGMENTATION);
                List<String> pictureListTemp = new ArrayList<>();
                pictureUidsTemp.forEach(picture -> {
                    pictureListTemp.add(pictureMap.get(picture));
                });
                item.setPhotoList(pictureListTemp);
            }

            if (StringUtils.isNotEmpty(item.getResourceSortUid())) {
                ResourceSort resourceSort = resourceSortService.getById(item.getResourceSortUid());
                item.setResourceSort(resourceSort);
            }
        }
        pageList.setRecords(list);
        return pageList;
    }

    @Override
    public String addStudyVideo(StudyVideoView studyVideoVO) {
        StudyVideo studyVideo = new StudyVideo();
        studyVideo.setName(studyVideoVO.getName());
        studyVideo.setSummary(studyVideoVO.getSummary());
        studyVideo.setContent(studyVideoVO.getContent());
        studyVideo.setFileUid(studyVideoVO.getFileUid());
        studyVideo.setBaiduPath(studyVideoVO.getBaiduPath());
        studyVideo.setResourceSortUid(studyVideoVO.getResourceSortUid());
        studyVideo.setClickCount(SysConf.ZERO);
        studyVideo.setUpdateTime(new Date());
        studyVideo.insert();
        return ResultUtil.successWithMessage(MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String editStudyVideo(StudyVideoView studyVideoVO) {
        StudyVideo studyVideo = studyVideoService.getById(studyVideoVO.getUid());
        studyVideo.setName(studyVideoVO.getName());
        studyVideo.setSummary(studyVideoVO.getSummary());
        studyVideo.setContent(studyVideoVO.getContent());
        studyVideo.setFileUid(studyVideoVO.getFileUid());
        studyVideo.setBaiduPath(studyVideoVO.getBaiduPath());
        studyVideo.setResourceSortUid(studyVideoVO.getResourceSortUid());
        studyVideo.setUpdateTime(new Date());
        studyVideo.updateById();
        return ResultUtil.successWithMessage(MessageConf.UPDATE_SUCCESS);
    }

    @Override
    public String deleteBatchStudyVideo(List<StudyVideoView> studyVideoVOList) {
        if (studyVideoVOList.size() <= 0) {
            return ResultUtil.errorWithMessage(MessageConf.PARAM_INCORRECT);
        }
        List<String> uids = new ArrayList<>();
        studyVideoVOList.forEach(item -> {
            uids.add(item.getUid());
        });
        Collection<StudyVideo> blogSortList = studyVideoService.listByIds(uids);
        blogSortList.forEach(item -> {
            item.setUpdateTime(new Date());
            item.setStatus(EStatus.DISABLED);
        });

        Boolean save = studyVideoService.updateBatchById(blogSortList);

        if (save) {
            return ResultUtil.successWithMessage(MessageConf.DELETE_SUCCESS);
        } else {
            return ResultUtil.errorWithMessage(MessageConf.DELETE_FAIL);
        }
    }
}
