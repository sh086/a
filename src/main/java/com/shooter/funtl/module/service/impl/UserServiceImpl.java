package com.shooter.funtl.module.service.impl;

import com.shooter.funtl.common.dto.BaseResult;
import com.shooter.funtl.common.utils.RegexpUtils;
import com.shooter.funtl.module.dao.UserDao;
import com.shooter.funtl.module.entity.User;
import com.shooter.funtl.module.service.UserService;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String email, String passWord) {
        val user = selectUserByEmail(email);
        if( user != null){
            // 名为密钥加盟
            String md5PassWd = DigestUtils.md5DigestAsHex(passWord.getBytes());
            if(md5PassWd.equals(user.getPassWord())){
                return user;
            }
        }
        return null;
    }

    @Override
    public User selectUserById(Long id) {
        val params = new User();
        params.setId(id);
        return userDao.selectUserByParams(params);
    }

    @Override
    public User selectUserByName(String userName) {
        val params = new User();
        params.setUserName(userName);
        return userDao.selectUserByParams(params);
    }

    @Override
    public List<User> selectUserByNameLike(String userNameLike) {
        return userDao.selectUserByUserNameLike(userNameLike);
    }

    @Override
    public User selectUserByEmail(String email) {
        val params = new User();
        params.setEmail(email);
        return userDao.selectUserByParams(params);
    }

    @Override
    public List<User> selectUserAll() {
        return userDao.selectUserAll();
    }

    @Override
    public BaseResult save(User user) {
        //校验用户有效性
        val checkResult = checkUser(user);
        if(checkResult != null){
            return checkResult;
        }
        //加密密码
        String md5PassWd = DigestUtils.md5DigestAsHex(user.getPassWord().getBytes());
        user.setPassWord(md5PassWd);
        //保存用户信息
        if(user.getId() != null){
            userDao.updateById(user);
        }else {
            userDao.insert(user);
        }
        return BaseResult.success("用户信息保存成功！");
    }

    @Override
    public void insert(User user) {
        String md5PassWd = DigestUtils.md5DigestAsHex(user.getPassWord().getBytes());
        user.setPassWord(md5PassWd);
        userDao.insert(user);
    }

    @Override
    public void updateById(User user) {
        String md5PassWd = DigestUtils.md5DigestAsHex(user.getPassWord().getBytes());
        user.setPassWord(md5PassWd);
        userDao.updateById(user);
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    /**
     * 校验用户有效性
     * */
    private BaseResult checkUser(User user){
        //校验邮箱
        if(StringUtils.isBlank(user.getEmail())){
            return BaseResult.fail("邮箱不能为空，请重新输入！");
        }
        if(!RegexpUtils.checkEmail(user.getEmail())){
            return BaseResult.fail("邮箱格式不正确，请重新输入！");
        }
        val emailRecord = selectUserByEmail(user.getEmail());
        if(emailRecord != null){
            return BaseResult.fail("该邮箱已经存在，请重新输入！");
        }

        //校验密码
        if(StringUtils.isBlank(user.getPassWord())){
            return BaseResult.fail("密码不能为空，请重新输入！");
        }

        //校验姓名
        if(StringUtils.isBlank(user.getUserName())){
            return BaseResult.fail("姓名不能为空，请重新输入！");
        }
        val nameRecord = selectUserByName(user.getUserName());
        if(nameRecord != null){
            return BaseResult.fail("该姓名已经存在，请重新输入！");
        }

        if(user.getPhone() == null){
            return BaseResult.fail("手机不能为空，请重新输入！");
        }
        if(!RegexpUtils.checkPhone(String.valueOf(user.getPhone()))){
            return BaseResult.fail("手机格式不正确，请重新输入！");
        }

        return null;
    }

    @Override
    public List<User> selectByUserLike(User user) {
        return userDao.selectByUserLike(user);
    }
}