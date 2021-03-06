package com.shooter.funtl.module.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Content implements Serializable {

    private Long id;

    private Long  categoryId;

    private String title;

    private String subTitle;

    private String titleDesc;

    private String url;

    private String pic;

    private String pic2;

    private String content;

    private Date createTime;

    private Date updateTime;

}
