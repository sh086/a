package com.shooter.funtl.module.service;

import com.shooter.funtl.common.dto.BaseResult;
import com.shooter.funtl.module.entity.User;

import java.util.List;

public interface UserService {

    List<User> selectByUserLike(User user);

    User selectUserById(Long id);

    User selectUserByName(String userName);

    List<User> selectUserByNameLike(String userNameLike);

    User selectUserByEmail(String email);

    List<User> selectUserAll();

    BaseResult save(User user);

    void insert(User user);

    void updateById(User user);

    void deleteById(Long id);

    User login(String email, String passWord);

}
