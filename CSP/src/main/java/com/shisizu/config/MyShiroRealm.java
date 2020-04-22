package com.shisizu.config;

import com.shisizu.domain.Msg;
import com.shisizu.domain.User;
import com.shisizu.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 袁红
 * @create 2020-03-25-9:52
 */
//实现AuthorizingRealm接口用户认证
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }

        System.out.println("正在执行认证");
        //类型转换
        //UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) authenticationToken;
        //取出登录时令牌中的用户名，根据用户名查找用户在数据库中
//        String uphone = authenticationToken.getPrincipal().toString();
//        User user = userService.selectByName(uphone);

        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) authenticationToken;
        //取出登录时令牌中的用户名，根据用户名查找用户在数据库中
        User user = userService.selectByName(usernamePasswordToken.getUsername());
        System.out.println(user);
        //如果用户不存在，返回
        if (user==null){
            return null;
        }
        //创建盐值，使用账号作为盐值
        //ByteSource salt=ByteSource.Util.bytes(uphone);
        //创建身份验证对象
        return new SimpleAuthenticationInfo(user, user.getUpassword(), getName());
    }
}