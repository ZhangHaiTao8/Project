package com.shisizu.controller;

import com.shisizu.domain.Msg;
import com.shisizu.domain.UG;
import com.shisizu.service.SoldGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 袁红
 * @create 2020-04-16-14:38
 */
@Controller
public class SoldGoodsController {
    @Autowired
    private SoldGoodsService soldGoodsService;


    // 文件上传
    @RequestMapping("/uploadFile")
    @ResponseBody
    public Msg uploadFile(HttpServletRequest request,
                          @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        String contexPath = "E:\\IntelliJ IDEA\\PROJECTS\\CSP\\src\\main\\resources\\static\\images\\good\\";
        System.out.println(contexPath);
        if(!file.isEmpty()) {
            byte[] bytes=file.getBytes();
            FileOutputStream out=new FileOutputStream(contexPath+file.getOriginalFilename());
            out.write(bytes);
            out.close();
        }
        System.out.println(file.getOriginalFilename());

        String newFile="/images/good/"+file.getOriginalFilename();//"picture/"+ String
        return Msg.success().add("file", newFile);
    }

    //获取用户id进入上架页
    @RequestMapping("/enterSoldGoods")
    public String enterSoldGoods(int uid, Model model){
        System.out.println(uid);
        model.addAttribute("uid",uid);
        return "SoldGoods";
    }

    @RequestMapping("/soldGoodsInsert")
    @ResponseBody
    public Msg soldGoodsInsert(UG ug){
        int i=soldGoodsService.soldGoodsInsert(ug);
        System.out.println(i);
        return Msg.success();
    }
}
