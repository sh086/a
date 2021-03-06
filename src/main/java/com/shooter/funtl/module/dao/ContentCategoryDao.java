package com.shooter.funtl.module.dao;

import com.shooter.funtl.module.entity.ContentCategory;
import java.util.List;

public interface ContentCategoryDao {

    /**
     * 查询全部内容分类信息
     * **/
    List<ContentCategory> selectAll();
}
