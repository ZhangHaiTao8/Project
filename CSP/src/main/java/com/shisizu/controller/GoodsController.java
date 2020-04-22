package com.shisizu.controller;

import com.shisizu.domain.*;
import com.shisizu.service.GoodsService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * @author ZhangCaiLei
 * @date 2020-04-10
 */
@Controller
public class GoodsController {
    //日志记录
    public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(TestController.class);

    @Autowired
    private GoodsService goodsService;



    //进入商品列表页面
    @RequestMapping("/enterGoodList")
    public String enterGoodList() {
        return "GoodList";
    }

    //进入商品查找列表页面
    @RequestMapping("/enterGoodSelect")
    public String enterGoodSelect() {
        return "GoodSelect";
    }

    //首页随机展示商品
    @RequestMapping("/RandomGoods")
    @ResponseBody
    public String selectRandom(@RequestParam(value = "gType", required = false) String gType) {
        LOGGER.info("GoodController执行！！！日志记录！！！");
        List<Goods> allgood = goodsService.selectRandom(gType);
        System.out.println(allgood);
        String result = toJSONString(allgood);
        return result;
    }

    //执行商品分类展示
    @RequestMapping("/typeGoods")
    @ResponseBody
    public String selectType(@RequestParam(value = "gType", required = false) String gType) {
        LOGGER.info("GoodController执行！！！日志记录！！！");

        List<Goods> typegood = goodsService.selectType(gType);
        System.out.println(typegood);
        String result = toJSONString(typegood);
        return result;
    }

    //执行商品模糊查找
    @RequestMapping("/selectGoods")
    @ResponseBody
    public String selectInput(@RequestParam(value = "gName", required = false) String gName, @RequestParam(value = "gType", required = false) String gType) {
        LOGGER.info("GoodController执行！！！日志记录！！！");
        List<Goods> selectgood = goodsService.selectInput(gName, gType);
        System.out.println(selectgood);
        String result = toJSONString(selectgood);
        return result;
    }

    //发表评论
    @ResponseBody
    @RequestMapping("/comment")
    public Msg comment(@Param("content") String content, HttpSession session, Comment comment) {
        User currentUser = (User) session.getAttribute("user");
        String username = currentUser.getUname();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(d);

        comment.setUsername(username);
        comment.setDate(date);
        comment.setContent(content);
        System.out.println(comment);
        int i = goodsService.InsertComment(comment);
        return Msg.success();
    }

    //展示评论
    @RequestMapping("/showComment")
    @ResponseBody
    public Msg showComment() {
        List<Comment> comments = goodsService.showComment();
        System.out.println(comments);
        return Msg.success().add("comments", comments);
    }

    //主页进入商品详情页面或者是用户操作页
    @RequestMapping("/enterDetails")
    public String enterDetails(int gid, Model model, HttpSession session) {
        model.addAttribute("gid", gid);
        System.out.println(gid);
        System.out.println(session.getAttribute("user") + "666666666666");
        //取到当前登录的用户
        User currentUser = (User) session.getAttribute("user");
        int cid = currentUser.getUid();
        System.out.println(cid + "99999");
        //通过商品的id来得到卖家的对象（如果当前对象就是卖家，就进入用户操作页；
        // 否则就是买家，进入商品详情页）
        //int mid=soldGoodsService.selectByGid(gid);
        int mid = goodsService.selectMidByGid(gid);
        System.out.println(mid + "88888");
        if (cid == mid) {
            return "GoodsDone";
        }
        model.addAttribute("cid", cid);
        return "GoodsDetails";
    }

    //带商家商品展示
    @ResponseBody
    @RequestMapping("/selectGoodsAndUser")
    public Msg selectGoodsAndUser() {
        List<UG> goods = goodsService.selectGoodsAndUser();
        System.out.println(goods);
        return Msg.success().add("goodsInfo", goods);
    }

    //根据商品id查找商品
    @RequestMapping("/getOneGoods")
    @ResponseBody
    public Msg getOneGoods(@Param("gid") int gid) {
        Goods goods = goodsService.getOneGoods(gid);
        System.out.println(goods);
        return Msg.success().add("goods", goods);
    }

    //根据商品id修改商品信息
    @ResponseBody
    @RequestMapping("/updateOneGoods")
    public Msg updateOneGoods(@Param("gid") int gid, Goods goods) {
        int i = goodsService.updateOneGoods(goods);
        System.out.println(i);
        return Msg.success();
    }

    //根据商品id下架商品
    @RequestMapping("/deleteOneGoods")
    @ResponseBody
    public Msg deleteOneGoods(@Param("gid") int gid) {
        int i = goodsService.deleteOneGoods(gid);
        System.out.println(i);
        return Msg.success();
    }
}
