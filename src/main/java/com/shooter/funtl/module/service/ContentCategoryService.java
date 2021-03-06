package com.shooter.funtl.module.service;

import com.shooter.funtl.module.entity.ContentCategory;

import java.util.List;

public interface ContentCategoryService {

    /**
     * 查询全部内容信息
     * **/
    List<ContentCategory> selectAll();

    /**
     * 目录排序
     * */
    void sortList(List<ContentCategory> sourceList,List<ContentCategory> targetList,Long parentId);

}
