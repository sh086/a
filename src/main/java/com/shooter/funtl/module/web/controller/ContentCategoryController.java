package com.shooter.funtl.module.web.controller;

import com.shooter.funtl.module.entity.ContentCategory;
import com.shooter.funtl.module.service.ContentCategoryService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;


/**
 * 内容分类管理
 * */
@Controller
@RequestMapping("/content/category/")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    /**
     * 跳转列表页面
     * */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        val sourceList = contentCategoryService.selectAll();
        val targetList = new ArrayList<ContentCategory>();
        contentCategoryService.sortList(sourceList,targetList,0L);
        model.addAttribute("contentCategories",targetList);
        return "content_category_list";
    }

}
