package com.shooter.funtl.module.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ContentCategory implements Serializable {

    private Long id;

    private Long parentId;

    private String name;

    private Integer status;

    private Integer sortOrder;

    private Boolean isParent;

    private Date createTime;

    private Date updateTime;


}
