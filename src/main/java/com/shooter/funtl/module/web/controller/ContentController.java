package com.shooter.funtl.module.web.controller;

import com.shooter.funtl.module.entity.Content;
import com.shooter.funtl.module.service.ContentService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}
