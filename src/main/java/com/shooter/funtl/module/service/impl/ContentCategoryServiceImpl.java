package com.shooter.funtl.module.service.impl;

import com.shooter.funtl.module.dao.ContentCategoryDao;
import com.shooter.funtl.module.entity.ContentCategory;
import com.shooter.funtl.module.service.ContentCategoryService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private ContentCategoryDao contentCategoryDao;

    @Override
    public List<ContentCategory> selectAll() {
        return contentCategoryDao.selectAll();
    }

    @Override
    public void sortList(List<ContentCategory> sourceList, List<ContentCategory> targetList, Long parentId) {
        for(val record : sourceList){
            if(record.getParentId().equals(parentId)){
                targetList.add(record);
                //判断有没有字节的，若有则继续追加
                if(record.getIsParent()){
                    for (val temp : sourceList){
                        if(temp.getParentId().equals(record.getId())){
                            sortList(sourceList,targetList,record.getId());
                            break;
                        }
                    }
                }
            }
        }
    }
}
