package com.shooter.funtl.module.web.controller;

import com.shooter.funtl.module.entity.Content;
import com.shooter.funtl.module.entity.User;
import com.shooter.funtl.module.service.ContentService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 内容管理
 * */
@Controller
@RequestMapping("/content/")
public class ContentController {

    @Autowired
    private ContentService contentService;

    /**
     * 跳转列表页面
     * */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        val contents = contentService.selectAll();
        model.addAttribute("contents",contents);
        return "content_list";
    }

    /**
     * 跳转列表页面
     * */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(Model model){
        val contents = contentService.selectAll();
        model.addAttribute("content",new Content());
        return "content_form";
    }

    /**
     * 保存表单
     * */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(User user, Model model, RedirectAttributes redirectAttributes){
//        //保存用户表单
//        val saveResult = userService.save(user);
//
//        //保存成功
//        if(saveResult.getStatus()){
//            //设置调转属性
//            redirectAttributes.addFlashAttribute("saveResult",saveResult);
//            return "redirect:/user/list";
//        }
//        //保存失败
//        else {
//            model.addAttribute("saveResult",saveResult);
//            return "user_form";
//        }
        return "";

    }

}
