package com.shisizu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 袁红
 * @create 2020-04-06-12:27
 */
@Controller
public class TestController {
    public static final Logger LOGGER= (Logger) LoggerFactory.getLogger(TestController.class);
    @RequestMapping("/Thyindex")
    public String index(){
        LOGGER.info("JspsController执行！！！日志记录！！！");
        return "Thyindex";
    }
}
