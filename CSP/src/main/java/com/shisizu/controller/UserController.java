package com.shisizu.controller;

import com.shisizu.domain.Msg;
import com.shisizu.domain.User;
import com.shisizu.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author 袁红
 * @create 2020-04-07-18:50
 */
@Controller

public class UserController {
    //日志记录
    public static final Logger LOGGER= (Logger) LoggerFactory.getLogger(TestController.class);

    //注入到容器
    @Autowired
    private UserService userService;

    @RequestMapping("/getUserId")
    @ResponseBody
    public Msg getUserId(HttpSession session){
        User user = (User)session.getAttribute("user");
        int uid=user.getUid();
        return Msg.success().add("uid",uid);
    }

    //进入初始页
    @RequestMapping("/enterIndex")
    public String enterIndex(){
        return "index";
    }

    //进入登录页
    @RequestMapping(value = "/enterLogin",method = RequestMethod.GET)
    public String enterLogin(){
        return "Login";
    }

    //进入注册页
    @RequestMapping("/enterRegister")
    public String enterRegister(){
        return "Register";
    }

    //进入忘记密码页
    @RequestMapping("/enterForget")
    public String enterForget(){
        return "Forget";
    }

    //进入主页
    @RequestMapping("/enterHome")
    public String index(){
        return "home";
    }

    //执行登录
    @RequestMapping(value = "/enterLogin",method = RequestMethod.POST)
    @ResponseBody
    public Msg userLogin(@RequestParam(value = "uphone",required = false) String uphone
            ,@RequestParam(value = "upassword", required = false) String upassword,HttpSession session){
        LOGGER.info("UserController执行！！！日志记录！！！");
//        User user = userService.selectUserByExample(uphone, upassword);
//        session.setAttribute("user", user);
//        System.out.println(user);
//        if(user!=null){
//            return Msg.success();
//        }else{
//            return Msg.fail();

        //添加用户认证信息 令牌
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(uphone,upassword);
        //进行验证
        try {
            subject.login(usernamePasswordToken);//执行登录方法

            User user = (User)subject.getPrincipal();//对象存放session域
            session.setAttribute("user",user);

            return Msg.success();
        } catch (UnknownAccountException e) {//账号错误
            return Msg.fail();
        }catch (IncorrectCredentialsException e){//密码错误
            return Msg.fail();
        }
    }

    //执行注册
    @RequestMapping("/userRegister")
    @ResponseBody
    public Msg userRegister(User user){
        int i=userService.userRegisterInsert(user);
        System.out.println(i);
        if(i==1) {
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

//    // 用户退出
//    @RequestMapping("/userOut")
//    @ResponseBody
//    public Msg userOut() {
//        //session.invalidate();
//        return Msg.success();
//    }

    //用户登出
    @RequestMapping("/logout")
    @ResponseBody
    public Msg logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return Msg.success();
    }

    // 用户登录时忘记密码
    @RequestMapping("/codeUpdate")
    @ResponseBody
    public Msg codeUpdate(@RequestParam(value = "upassword2") String upassword2,
                          @RequestParam(value = "uemail") String uemail) {
        System.out.println(upassword2 +","+ uemail);
        // 根据用户输入的邮箱查找密码
        String oldPassword = userService.selectCodeByEmail(uemail);
        System.out.println(oldPassword);
        if (oldPassword != null) {
            // 对原来密码进行修改
            int i = userService.updateCodeByOldCode(uemail, upassword2);
            System.out.println(i);
        } else {
            System.out.println("你输入的邮箱有误");
            return Msg.fail();
        }
        return Msg.success();
    }


    // 验证用户名
    @RequestMapping("/checkUserName")
    @ResponseBody
    public Msg checkUserName(@RequestParam("uname") String uname) {
        // 先判断用户名是否是合法的表达式
        String regex = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
        if (!uname.matches(regex)) {
            return Msg.fail().add("va_msg", "用户名可以是2-5位中文或者6-16位英文和数字的组合");
        }
        // 数据库用户名重复校验
        User user = userService.checkUser(uname);
        if (user != null) {
            return Msg.fail().add("va_msg", "用户名已存在");
        } else {
            return Msg.success().add("va_msg", "用户名可用");
        }
    }

    // 验证手机号
    @RequestMapping("/checkUserPhone")
    @ResponseBody
    public Msg checkUserPhone(@RequestParam("uphone") String uphone) {
        // 先判断用户名是否是合法的表达式
        /* 手机号只能是1开头，第二位是3/4/5/7/8的任意一个，后九位[0-9]之间的数字 */
        System.out.println("uphone = [" + uphone + "]");
        String regex = "(^1(3|4|5|7|8)\\d{9}$)";
        if (!uphone.matches(regex)) {
            return Msg.fail().add("va_msg", "手机号格式不正确");
        } else {
            return Msg.success().add("va_msg", "");
        }
    }

    // 验证邮箱
    @RequestMapping("/checkUserEmail")
    @ResponseBody
    public Msg checkUserEmail(@RequestParam("uemail") String uemail) {
        // 先判断用户名是否是合法的表达式
        /* 手机号只能是1开头，第二位是3/4/5/7/8的任意一个，后九位[0-9]之间的数字 */
        String regex = "(^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$)";
        if (!uemail.matches(regex)) {
            return Msg.fail().add("va_msg", "邮箱格式不正确");
        } else {
            return Msg.success().add("va_msg", "");
        }
    }

}
