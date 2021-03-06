package com.shooter.funtl.module.dao;

import com.shooter.funtl.module.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    /**分页查询**/
    List<User> page(Map<String,Object> params);

    /**按条件查询用户信息**/
    User selectUserByParams(User params);

    /**统计总数**/
    Integer countUserLike(User user);

    /**根据用户信息进行模糊查询**/
    List<User> selectByUserLike(User params);

    /**查询全部用户信息**/
    List<User> selectUserAll();

    /**新增用户信息**/
    void insert(User user);

    /**更新用户信息**/
    void updateById(User user);

    /**删除用户信息**/
    void deleteById(Long id);

    /**批量删除用户信息**/
    void deleteByIds(String[] ids);

}
