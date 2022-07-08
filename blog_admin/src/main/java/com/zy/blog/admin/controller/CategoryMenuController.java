package com.zy.blog.admin.controller;



import com.zy.blog.admin.annotation.OperationLogger.OperationLogger;
import com.zy.blog.service.service.CategoryMenuService;
import com.zy.blog.service.service.MenuService;
import com.zy.blog.utils.ThrowableUtils;
import com.zy.blog.utils.annotion.validator.group.Delete;
import com.zy.blog.utils.annotion.validator.group.GetList;
import com.zy.blog.utils.annotion.validator.group.Insert;
import com.zy.blog.utils.annotion.validator.group.Update;
import com.zy.blog.utils.util.ResultUtil;
import com.zy.blog.view.CategoryMenuView;
import com.zy.blog.view.MenuView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 菜单表
 *
 *  @author 小章鱼
 * @date 2021年02月5日
 */

@RestController
@RequestMapping("/categoryMenu")
@Slf4j
public class CategoryMenuController {

    @Autowired
    MenuService menuService;
    @Autowired
    CategoryMenuService categoryMenuService;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public String getList(@Validated({GetList.class}) @RequestBody CategoryMenuView categoryMenuVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.successWithData(categoryMenuService.getPageList(categoryMenuVO));
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(@RequestParam(value = "keyword", required = false) String keyword) {
        return ResultUtil.successWithData(categoryMenuService.getAllList(keyword));
    }

    @RequestMapping(value = "/getButtonAll", method = RequestMethod.GET)
    public String getButtonAll(@RequestParam(value = "keyword", required = false) String keyword) {

        return ResultUtil.successWithData(categoryMenuService.getButtonAllList(keyword));
    }

   // @AvoidRepeatableCommit
    @OperationLogger(value = "增加菜单")
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody CategoryMenuView categoryMenuVO, BindingResult result) {
        ThrowableUtils.checkParamArgument(result);
        return categoryMenuService.addCategoryMenu(categoryMenuVO);
    }


    @OperationLogger(value = "增加菜单")
    @PostMapping("/edit")
    public String edit(@Validated({Update.class}) @RequestBody CategoryMenuView categoryMenuVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return categoryMenuService.editCategoryMenu(categoryMenuVO);
    }


    @OperationLogger(value = "删除菜单")
    @PostMapping("/delete")
    public String delete(@Validated({Delete.class}) @RequestBody CategoryMenuView categoryMenuVO, BindingResult result) {
        ThrowableUtils.checkParamArgument(result);
        return categoryMenuService.deleteCategoryMenu(categoryMenuVO);
    }




    @OperationLogger(value = "置顶菜单")
    @PostMapping("/stick")
    public String stick(@Validated({Delete.class}) @RequestBody CategoryMenuView categoryMenuVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return categoryMenuService.stickCategoryMenu(categoryMenuVO);
    }
}

