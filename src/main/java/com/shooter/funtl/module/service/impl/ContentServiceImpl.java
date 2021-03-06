package com.shooter.funtl.module.service.impl;

import com.shooter.funtl.module.dao.ContentDao;
import com.shooter.funtl.module.entity.Content;
import com.shooter.funtl.module.service.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentDao contentDao;

    @Override
    public List<Content> selectAll() {
        return contentDao.selectAll();
    }
}
