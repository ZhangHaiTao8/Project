package com.shisizu.controller;

import com.shisizu.domain.Good;
import com.shisizu.service.GoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * @author ZhangCaiLei
 * @date 2020-04-10
 */
@Controller
public class GoodController {
    //日志记录
    public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(TestController.class);

    @Autowired
    private GoodService goodService;

    @RequestMapping("/AllGoods")
    @ResponseBody
    public String selectAll(){
        List<Good> allgood = goodService.selectAll();
        System.out.println(allgood);
        String result = toJSONString(allgood);
        return result;
    }

}
