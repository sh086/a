package com.shooter.funtl.module.dao;

import com.shooter.funtl.module.entity.Content;

import java.util.List;

public interface ContentDao {

    /**
     * 查询全部内容信息
     * **/
    List<Content> selectAll();

}
