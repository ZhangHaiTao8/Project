package com.shisizu.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.shisizu.domain.Admin;
import com.shisizu.domain.Msg;
import com.shisizu.domain.User;
import com.shisizu.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author 袁红
 * @create 2020-04-11-19:00
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    //日志记录
    public static final Logger LOGGER= (Logger) LoggerFactory.getLogger(TestController.class);


    //进入管理员界面
    @RequestMapping("/enterAdmin")
    public String enterAdmin(){
        return "admin";
    }

    //进入管理员登录界面
    @RequestMapping("/enterAdminLogin")
    public String enterAdminLogin(){
        return "AdminLogin";
    }

    //进入管理员主界面
    @RequestMapping("/enterAdminMain")
    public String enterAdminMain(){
        return "AdminMain";
    }

    //执行登录
    @RequestMapping("/adminLogin")
    @ResponseBody
    public Msg AdminLogin(@RequestParam(value = "admName",required = false) String admName
            , @RequestParam(value = "admPassword", required = false) String admPassword, HttpSession session) {
        LOGGER.info("UserController执行！！！日志记录！！！");
        Admin admin = adminService.selectAdmin(admName, admPassword);
        System.out.println(admin);
        if (admin != null) {
            session.setAttribute("admin", admin);
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    //退出登录
    @RequestMapping("/adminOut")
    @ResponseBody
    public Msg adminOut(HttpSession session) {
        session.invalidate();
        return Msg.success();
    }

}
