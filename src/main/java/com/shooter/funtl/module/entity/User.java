package com.shooter.funtl.module.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable{

    private Long id;

    private String userName;

    @JsonIgnore
    private String passWord;

    private String email;

    private Long phone;

    private Date createTime;

    private Date updateTime;

}
