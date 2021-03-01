package com.shooter.funtl.module.web.controller;

import com.shooter.funtl.common.dto.BaseResult;
import com.shooter.funtl.module.entity.User;
import com.shooter.funtl.module.service.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public String list(Model model){
        val users = userService.selectUserAll();
        model.addAttribute("users",users);
        return "user_list";
    }

    /**
     * 跳转用户表单页面
     * */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(Model model){
        return "user_form";
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
     * 查询用户信息
     * */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String search(User user,Model model){
        val userResult = userService.selectByUserLike(user);
        model.addAttribute("users",userResult);
        return "user_list";
    }

    /**
     * 删除用户信息
     * */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult delete(String ids) {
        return BaseResult.success("曹操");
    }

}
