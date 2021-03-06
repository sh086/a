package com.shooter.funtl.module.service;

import com.shooter.funtl.common.modal.BaseResult;
import com.shooter.funtl.common.modal.PageInfo;
import com.shooter.funtl.module.entity.User;
import com.shooter.funtl.module.modal.UserSearchModal;

import java.util.List;

public interface UserService {

    PageInfo<User> page(UserSearchModal modal);

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

    void deleteByIds(String[] ids);

    User login(String email, String passWord);

}
