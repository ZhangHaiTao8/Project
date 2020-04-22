package com.shisizu.controller;

import com.shisizu.domain.Msg;
import com.shisizu.domain.ShoppingCart;
import com.shisizu.domain.User;
import com.shisizu.service.ShoppingCartService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 袁红
 * @create 2020-04-06-12:27
 */
@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    //插入用户购买信息到数据库
    @ResponseBody
    @RequestMapping("/addShoppingCart")
    public Msg addShoppingCart(@Param("gid") Integer gid, @Param("cid") Integer cid) {
        int i = shoppingCartService.addShoppingCart(gid, cid);
        System.out.println(i + "ooooooooooooooooooooooooooo");
        return Msg.success();
    }

    //删除购物车信息
    @ResponseBody
    @RequestMapping("/deleteShoppingCart")
    public Msg deleteShoppingCart(@Param("gid") Integer gid, @Param("cid") Integer cid) {
        int i = shoppingCartService.deleteShoppingCart(gid, cid);
        System.out.println(i + "ooooooooooooooooooooooooooo");
        return Msg.success();
    }

    //清空购物车
    @RequestMapping("/deleteShoppingCartAll")
    @ResponseBody
    public Msg deleteShoppingCartAll(@Param("cid") Integer cid) {
        int i = shoppingCartService.deleteShoppingCartAll(cid);
        System.out.println(i + "ooooooooooooooooooooooooooo");
        return Msg.success();
    }

    //由商品详情页进入购物车页面
    @RequestMapping("/enterShoppingCart")
    public String enterShoppingCart(Integer gid, Model model, HttpSession session) {
        model.addAttribute("gid", gid);
        System.out.println(gid);
        //取到当前登录的用户
        User currentUser = (User) session.getAttribute("user");
        int cid = currentUser.getUid();
        model.addAttribute("cid", cid);
        System.out.println(cid);
        return "ShoppingCart";
    }


    @RequestMapping("/selectShoppingCart")
    @ResponseBody
    public Msg selectShoppingCart(@Param("cid") Integer cid, @Param("gid") Integer gid) {
        System.out.println(cid + "1111111111111111111111111111111111");
        List<ShoppingCart> shoppingCarts = shoppingCartService.selectShoppingCart(cid, gid);
        System.out.println(shoppingCarts);
        return Msg.success().add("shoppingCarts", shoppingCarts);
    }
}
