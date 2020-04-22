package com.shisizu;

import com.shisizu.controller.TestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 袁红
 * @create 2020-04-06-12:12
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {

        SpringApplication.run(App.class,args);

        //启动项目自动打开系统默认浏览器并进入index界面
        Logger logger = LoggerFactory.getLogger(App.class);
        String cmd = "cmd /c start http://localhost:8080/enterIndex";
        Runtime run = Runtime.getRuntime();
        try{
            run.exec(cmd);
            logger.info("启动浏览器打开项目成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
}
