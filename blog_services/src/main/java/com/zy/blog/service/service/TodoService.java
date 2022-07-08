package com.zy.blog.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zy.blog.base.ServiceBase;
import com.zy.blog.entity.Todo;
import com.zy.blog.view.TodoView;

/**
 * 待办事项表 服务类
 *
 * @author 小章鱼
 * @date 2019年6月29日10:31:18
 */
public interface TodoService extends ServiceBase<Todo> {

    /**
     * 批量更新代办事项的状态
     *
     * @param done     : 状态
     * @param adminUid : 管理员UID
     */
    public void toggleAll(Integer done, String adminUid);

    /**
     * 获取待办事项列表
     *
     * @param TodoView
     * @return
     */
    public IPage<Todo> getPageList(TodoView TodoView);

    /**
     * 新增待办事项
     *
     * @param TodoView
     */
    public String addTodo(TodoView TodoView);

    /**
     * 编辑待办事项
     *
     * @param TodoView
     */
    public String editTodo(TodoView TodoView);

    /**
     * 删除待办事项
     *
     * @param TodoView
     */
    public String deleteTodo(TodoView TodoView);

    /**
     * 批量编辑待办事项
     *
     * @param TodoView
     */
    public String editBatchTodo(TodoView TodoView);
}
