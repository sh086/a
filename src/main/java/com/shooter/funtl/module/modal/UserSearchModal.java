package com.shooter.funtl.module.modal;

import lombok.Data;

@Data
public class UserSearchModal {

    private String userName;

    private String email;

    private Long phone;

    private Integer draw;

    private Integer start = 0;

    private Integer length = 10;
}
