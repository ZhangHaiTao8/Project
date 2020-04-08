package com.shisizu.util;

/**
 * @author 袁红
 * @create 2020-03-15-9:02
 */

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 *
 * 第一步：引入约束
 * 第二步：注解配置aop
 * 第三步：生成组件注解4个：@Controller @Service @Respository @Component
 */
@Aspect
@Slf4j
@Component
public class WebLogAspect {
    //日志一般来说会记录什么？记录用户使用前的一些信息
    //以及使用我们方法之后返回一些响应信息
    //按照业务需求 分成前置日志记录 后置日志记录
    //使用前置增强 和 后置增强

    //aop切入点表达式
    @Before("execution(public * com.shisizu.controller.*.*(..))")
    public void beforeLog() throws Exception{
        //获取请求
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //返回值对象快捷键：ctrl+alt+v
        HttpServletRequest request = attributes.getRequest();
        //日志 记录用户ip 用户方法 url访问
        log.info("Url:"+request.getRequestURL());
        log.info("Method:"+request.getMethod());
        log.info("IP:"+request.getRemoteAddr());
        Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements())
        {
            String argName=(String)enumeration.nextElement();
            log.info("args:{},value:{}",argName,request.getParameter(argName));
        }
    }

    @AfterReturning(returning = "ret",pointcut = "execution(public * com.shisizu.controller.*.*(..))")
    public void afterLog(Object ret) throws Exception{
        log.info("用户使用完方法响应结果为："+ret);
    }
}
