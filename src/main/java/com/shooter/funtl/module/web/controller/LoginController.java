package com.shooter.funtl.module.web.controller;

import com.shooter.funtl.common.constant.SessionConstant;
import com.shooter.funtl.common.utils.CookieUtils;
import com.shooter.funtl.module.entity.User;
import com.shooter.funtl.module.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 跳转登录页面
     * */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login(HttpServletRequest req) {
        String userInfo = CookieUtils.getCookieValue(req,SessionConstant.SESSION_USER);
        if(StringUtils.isNotBlank(userInfo)){
            String[] userInfoArray = userInfo.split(":");
            req.setAttribute("loginId",userInfoArray[0]);
            req.setAttribute("loginPwd",userInfoArray[1]);
            req.setAttribute("isRemember",true);
        }
        return "login";
    }

    /**
     * 登录逻辑
     * */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String loginId,
                        @RequestParam(required = true) String loginPwd,
                        String isRemember, HttpServletRequest req, HttpServletResponse resp, Model model) {

        boolean isCheck = "on".equals(isRemember);
        //查询用户信息
        User user = userService.login(loginId, loginPwd);
        //登录失败的处理
        if(user == null){
            model.addAttribute("message","用户名或密码错误！");
            return login(req);
        }
        //登录成功的处理
        else {
            if(isCheck){
                //设置Cookie键值对，以及生效时间为7天
                CookieUtils.setCookie(req,resp,
                        SessionConstant.SESSION_USER,String.format("%s:%s",loginId,loginPwd),
                        7 * 24 * 60 * 60);
            }else {
                CookieUtils.deleteCookie(req,resp,SessionConstant.SESSION_USER);
            }
            model.addAttribute("message","登陆成功！");
            req.getSession().setAttribute(SessionConstant.SESSION_USER,user);
            return "redirect:/main";
        }
    }

    /**
     * 注销登录
     * */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest req){
        req.getSession().invalidate();
        return login(req);
    }
}
