package com.shisizu.service;

import com.shisizu.domain.Comment;
import com.shisizu.domain.Goods;
import com.shisizu.domain.UG;

import java.util.List;

/**
 * @author ZhangCaiLei
 * @date 2020-04-10
 */

public interface GoodsService {

    List<Goods> selectRandom(String gType);
    List<Goods> selectType(String gType);
    List<Goods> selectInput(String gName, String gType);

    int selectMidByGid(int gid);

    List<UG> selectGoodsAndUser();
    //List<Goods> selectAllGoods();
    Goods getOneGoods(Integer gid);

    int InsertComment(Comment comment);

    List<Comment> showComment();

    int updateOneGoods(Goods goods);

    int  deleteOneGoods(int gid);
}
