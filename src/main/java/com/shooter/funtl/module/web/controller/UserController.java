package com.shooter.funtl.module.web.controller;

import com.shooter.funtl.common.modal.BaseResult;
import com.shooter.funtl.common.modal.PageInfo;
import com.shooter.funtl.module.entity.User;
import com.shooter.funtl.module.modal.UserSearchModal;
import com.shooter.funtl.module.service.UserService;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 用户管理
 * */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute
    public User getUser(Long id){
        User user = null;
        if(id != null){
            user = userService.selectUserById(id);
        }else {
            user = new User();
        }
        return user;
    }

    /**
     * 跳转用户列表页面
     * */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "user_list";
    }

    /**
     * 跳转用户表单页面
     * */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){
        return "user_form";
    }

    /**
     * 跳转用户明细表单页面
     * */
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(User user){
        return "user_detail";
    }

    /**
     * 保存用户表单
     * */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(User user, Model model,RedirectAttributes redirectAttributes){
        //保存用户表单
        val saveResult = userService.save(user);

        //保存成功
        if(saveResult.getStatus()){
            //设置调转属性
            redirectAttributes.addFlashAttribute("saveResult",saveResult);
            return "redirect:/user/list";
        }
        //保存失败
        else {
            model.addAttribute("saveResult",saveResult);
            return "user_form";
        }

    }

    /**
     * 分页查询用户信息
     * */
    @RequestMapping(value = "page",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<User> page(UserSearchModal modal){
        return userService.page(modal);
    }

    /**
     * 批量删除用户信息
     * */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult deleteMulti(String ids) {
        if(StringUtils.isBlank(ids)){
            return BaseResult.fail("编号不能为空");
        }
        val idArray = ids.split(",");
        userService.deleteByIds(idArray);

        return BaseResult.success("删除数据成功");
    }

}
