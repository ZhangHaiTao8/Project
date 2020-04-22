package com.shisizu.service.impl;


import com.shisizu.dao.GoodsDao;
import com.shisizu.domain.Comment;
import com.shisizu.domain.Goods;
import com.shisizu.domain.UG;
import com.shisizu.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhangCaiLei
 * @date 2020-04-10
 */

@Service
public class GoodsServiceImp implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> selectRandom(String gType) {
        return goodsDao.selectRandom(gType);
    }

    @Override
    public List<Goods> selectType(String gType) {
        return goodsDao.selectType(gType);
    }

    @Override
    public List<Goods> selectInput(String gName, String gType) {
        return goodsDao.selectInput(gName, gType);
    }

    @Override
    public int selectMidByGid(int gid) {
        return goodsDao.selectMidByGid(gid);
    }

    @Override
    public List<UG> selectGoodsAndUser() {
        return goodsDao.selectGoodsAndUser();
    }

    @Override
    public Goods getOneGoods(Integer gid) {
        return goodsDao.getOneGoods(gid);
    }

    @Override
    public int InsertComment(Comment comment) {
        return goodsDao.InsertComment(comment);
    }

    @Override
    public List<Comment> showComment() {
        return goodsDao.showComment();
    }

    @Override
    public int updateOneGoods(Goods goods) {
        return goodsDao.updateOneGoods(goods);
    }

    @Override
    public int deleteOneGoods(int gid) {
        return goodsDao.deleteOneGoods(gid);
    }
}
