package com.zy.blog.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.blog.base.ServiceImplBase;
import com.zy.blog.entity.FeedBack;
import com.zy.blog.entity.User;
import com.zy.blog.service.mapper.FeedbackMapper;
import com.zy.blog.service.service.FeedbackService;
import com.zy.blog.service.service.UserService;
import com.zy.blog.utils.constant.MessageConf;
import com.zy.blog.utils.constant.SQLConf;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.enums.EStatus;
import com.zy.blog.utils.holder.RequestHolder;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.utils.util.StringUtils;
import com.zy.blog.view.FeedBackView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 反馈表 服务实现类
 *
 * @author 小章鱼
 * @date 2021-09-08
 */
@Service
public class FeedbackServiceImpl extends ServiceImplBase<FeedbackMapper, FeedBack> implements FeedbackService {

    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private UserService userService;


    @Override
    public IPage<FeedBack> getPageList(FeedBackView feedbackVO) {
        QueryWrapper<FeedBack> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(feedbackVO.getTitle())) {
            queryWrapper.like(SQLConf.TITLE, feedbackVO.getTitle());
        }

        if (feedbackVO.getFeedbackStatus() != null) {
            queryWrapper.eq(SQLConf.FEEDBACK_STATUS, feedbackVO.getFeedbackStatus());
        }

        Page<FeedBack> page = new Page<>();
        page.setCurrent(feedbackVO.getCurrentPage());
        page.setSize(feedbackVO.getPageSize());
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.orderByDesc(SQLConf.CREATE_TIME);
        IPage<FeedBack> pageList = feedbackService.page(page, queryWrapper);

        List<FeedBack> feedbackList = pageList.getRecords();
        List<String> userUids = new ArrayList<>();
        feedbackList.forEach(item -> {
            if (StringUtils.isNotEmpty(item.getUserUid())) {
                userUids.add(item.getUserUid());
            }
        });
        List<User> userList = userService.getUserListByIds(userUids);
        Map<String, User> map = new HashMap<>();
        userList.forEach(item -> {
            item.setPassWord("");
            map.put(item.getUid(), item);
        });

        feedbackList.forEach(item -> {
            if (StringUtils.isNotEmpty(item.getUserUid())) {
                item.setUser(map.get(item.getUserUid()));
            }
        });

        pageList.setRecords(feedbackList);
        return pageList;
    }

    @Override
    public String addFeedback(FeedBackView feedbackVO) {
        HttpServletRequest request = RequestHolder.getRequest();
        FeedBack feedback = feedbackService.getById(feedbackVO.getUid());
        feedback.setTitle(feedbackVO.getTitle());
        feedback.setContent(feedbackVO.getContent());
        feedback.setFeedbackStatus(feedbackVO.getFeedbackStatus());
        feedback.setReply(feedbackVO.getReply());
        feedback.setUpdateTime(new Date());
        if (request.getAttribute(SysConf.ADMIN_UID) != null) {
            feedback.setAdminUid(request.getAttribute(SysConf.ADMIN_UID).toString());
        }
        feedback.setUpdateTime(new Date());
        feedback.updateById();
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.UPDATE_SUCCESS);
    }

    @Override
    public String editFeedback(FeedBackView feedbackVO) {
        return null;
    }

    @Override
    public String deleteBatchFeedback(List<FeedBackView> feedbackVOList) {
        HttpServletRequest request = RequestHolder.getRequest();
        final String adminUid = request.getAttribute(SysConf.ADMIN_UID).toString();
        if (feedbackVOList.size() <= 0) {
            return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        }
        List<String> uids = new ArrayList<>();
        feedbackVOList.forEach(item -> {
            uids.add(item.getUid());
        });

        Collection<FeedBack> feedbackList = feedbackService.listByIds(uids);

        feedbackList.forEach(item -> {
            item.setAdminUid(adminUid);
            item.setUpdateTime(new Date());
            item.setStatus(EStatus.DISABLED);
        });

        Boolean save = feedbackService.updateBatchById(feedbackList);

        if (save) {
            return ResultUtil.result(SysConf.SUCCESS, MessageConf.DELETE_SUCCESS);
        } else {
            return ResultUtil.result(SysConf.ERROR, MessageConf.DELETE_FAIL);
        }
    }
}
