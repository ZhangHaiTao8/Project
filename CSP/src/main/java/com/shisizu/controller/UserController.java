package com.shisizu.controller;

import com.shisizu.domain.Msg;
import com.shisizu.domain.User;
import com.shisizu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


@Controller
public class UserController {
    //日志记录
    public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(TestController.class);

    //注入到容器
    @Autowired
    private UserService userService;

    //进入index页面
    @RequestMapping("/enterIndex")
    public String enterIndex() {
        return "index";
    }

    //进入登录页
    @RequestMapping("/enterLogin")
    public String enterLogin() {
        return "UserLogin";
    }

    //进入注册页
    @RequestMapping("/enterRegister")
    public String enterRegister() {
        return "UserRegister";
    }

    //个人信息界面
    @RequestMapping("/enterPersonal")
    public String enterPersonal(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "张三", "123", "男", "XX", "XXX.XXX", "XX@XX"));
        users.add(new User(2, "李四", "123", "男", "XX", "XXX.XXX", "XX@XX"));
        users.add(new User(3, "王五", "123", "男", "XX", "XXX.XXX", "XX@XX"));
        users.add(new User(4, "赵钱", "123", "男", "XX", "XXX.XXX", "XX@XX"));
        users.add(new User(5, "孙武", "123", "男", "XX", "XXX.XXX", "XX@XX"));
        model.addAttribute("users", users);
        return "personal";
    }

    //执行登录
    @RequestMapping("/userLogin")
    public String userLogin(@RequestParam(value = "uphone", required = false) String uphone
            , @RequestParam(value = "upassword", required = false) String upassword, Model model) {
        LOGGER.info("UserController执行！！！日志记录！！！");
        User user = userService.selectUserByExample(uphone, upassword);
        System.out.println(user);
        if (user != null) {
            model.addAttribute("user", user);
            return "home";
        } else {
            return "UserLogin";
        }
    }

    //进入首页
    @RequestMapping("/enterHome")
    public String enterHome() {
        return "home";
    }

    //执行注册
    @RequestMapping("/userRegister")
    @ResponseBody
    public Msg userRegister(User user) {
        int i = userService.userRegisterInsert(user);
        System.out.println(i);
        if (i == 1) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
}
