package com.shisizu.controller;

import com.shisizu.domain.Good;
import com.shisizu.domain.User;
import com.shisizu.service.GoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    //首页随机展示12个商品
    @RequestMapping("/RandomGoods")
    @ResponseBody
    public String selectRandom(){
        List<Good> allgood = goodService.selectRandom();
        System.out.println(allgood);
        String result = toJSONString(allgood);
        return result;
    }

    //进入商品列表页面
    @RequestMapping("/enterGoodList")
    public String enterGoodList() {
        return "GoodList";
    }

    //执行商品分类展示
    @RequestMapping("/typeGoods")
    @ResponseBody
    public String selectType(@RequestParam(value = "gType", required = false) String gType) {
        LOGGER.info("GoodController执行！！！日志记录！！！");
        List<Good> typegood = goodService.selectType(gType);
        System.out.println(typegood);
        String result = toJSONString(typegood);
        return result;
    }

}
