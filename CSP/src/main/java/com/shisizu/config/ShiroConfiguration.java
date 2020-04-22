package com.shisizu.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 袁红
 * @create 2020-03-25-10:50
 */
//配置过滤
@Configuration//把这个类纳入到spring容器当中作为配置
public class ShiroConfiguration {

    //将自己的验证方式加入容器
    @Bean//表示把方法的返回值作为javabean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm=new MyShiroRealm();
        //myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        System.out.println("myShiroRealm注入成功");
        return myShiroRealm;
    }

    @Bean
    //权限管理，配置主要Realm的管理认证  将工厂注入到数据源中
    public org.apache.shiro.mgt.SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }


//    @Bean
//    public HashedCredentialsMatcher hashedCredentialsMatcher(){
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        // 使用md5 算法进行加密
//        hashedCredentialsMatcher.setHashAlgorithmName("md5");
//        // 设置散列次数： 意为加密几次
//        hashedCredentialsMatcher.setHashIterations(2);
//
//        return hashedCredentialsMatcher;
//    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(org.apache.shiro.mgt.SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> map = new HashMap<String,String>();
        //登出
        //map.put("/logout","logout");
        //对所有用户认证
        map.put("/enterHome","authc");
        //登录
        //map.put("/login","anon");
        //注册
        map.put("/Register","anon");
        shiroFilterFactoryBean.setLoginUrl("/enterLogin");
        //权限验证成功登录的页面
        shiroFilterFactoryBean.setSuccessUrl("/enterHome");
        //错误页面，认证不通过跳转
        //shiroFilterFactoryBean.setUnauthorizedUrl("/error");;

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    //加入注解的使用，不加入这个注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(org.apache.shiro.mgt.SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
