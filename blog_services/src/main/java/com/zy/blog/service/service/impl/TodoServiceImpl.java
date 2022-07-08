package com.zy.blog.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.blog.base.ServiceImplBase;
import com.zy.blog.entity.Todo;
import com.zy.blog.service.mapper.TodoMapper;
import com.zy.blog.service.service.TodoService;
import com.zy.blog.utils.constant.MessageConf;
import com.zy.blog.utils.constant.SQLConf;
import com.zy.blog.utils.constant.SysConf;
import com.zy.blog.utils.enums.EStatus;
import com.zy.blog.utils.holder.RequestHolder;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.utils.util.StringUtils;
import com.zy.blog.view.TodoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 待办事项表 服务实现类
 * </p>
 *
 * @author xuzhixiang
 * @since 2019年6月29日10:31:44
 */
@Service
public class TodoServiceImpl extends ServiceImplBase<TodoMapper, Todo> implements TodoService {

    @Autowired
    TodoService todoService;

    @Resource
    TodoMapper todoMapper;

    @Override
    public void toggleAll(Integer done, String adminUid) {
        todoMapper.toggleAll(done, adminUid);
    }

    @Override
    public IPage<Todo> getPageList(TodoView todoVO) {
        String adminUid = RequestHolder.getAdminUid();
        QueryWrapper<Todo> queryWrapper = new QueryWrapper<>();

        if (StringUtils.isNotEmpty(todoVO.getKeyword()) && !StringUtils.isEmpty(todoVO.getKeyword().trim())) {
            queryWrapper.like(SQLConf.TEXT, todoVO.getKeyword().trim());
        }
        queryWrapper.eq(SQLConf.ADMINUID, adminUid);

        //按时间顺序倒排
        queryWrapper.orderByDesc(SQLConf.CREATE_TIME);

        Page<Todo> page = new Page<>();
        page.setCurrent(todoVO.getCurrentPage());
        page.setSize(todoVO.getPageSize());
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        IPage<Todo> pageList = todoService.page(page, queryWrapper);
        return pageList;
    }

    @Override
    public String addTodo(TodoView todoVO) {
        String adminUid = RequestHolder.getAdminUid();
        Todo todo = new Todo();
        todo.setText(todoVO.getText());
        //默认未完成
        todo.setDone(false);
        todo.setAdminUid(adminUid);
        todo.insert();
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String editTodo(TodoView todoVO) {
        String adminUid = RequestHolder.getAdminUid();
        Todo todo = todoService.getById(todoVO.getUid());

        if (!todo.getAdminUid().equals(adminUid)) {
            return ResultUtil.result(SysConf.ERROR, MessageConf.ACCESS_NO_PRIVILEGE);
        }

        todo.setText(todoVO.getText());
        todo.setDone(todoVO.getDone());
        todo.setUpdateTime(new Date());
        todo.updateById();
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.UPDATE_SUCCESS);
    }

    @Override
    public String deleteTodo(TodoView todoVO) {
        String adminUid = RequestHolder.getAdminUid();
        Todo todo = todoService.getById(todoVO.getUid());

        if (!todo.getAdminUid().equals(adminUid)) {
            return ResultUtil.result(SysConf.ERROR, MessageConf.DATA_NO_PRIVILEGE);
        }

        todo.setStatus(EStatus.DISABLED);
        todo.setUpdateTime(new Date());
        todo.updateById();
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.DELETE_SUCCESS);
    }

    @Override
    public String editBatchTodo(TodoView todoVO) {
        String adminUid = RequestHolder.getAdminUid();
        if (todoVO.getDone()) {
            todoService.toggleAll(SysConf.ONE, adminUid);
        } else {
            todoService.toggleAll(SysConf.ZERO, adminUid);
        }
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.UPDATE_SUCCESS);
    }


}
