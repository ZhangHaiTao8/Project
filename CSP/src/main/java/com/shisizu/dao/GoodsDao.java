package com.shisizu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shisizu.domain.Comment;
import com.shisizu.domain.Goods;
import com.shisizu.domain.UG;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ZhangCaiLei
 * @date 2020-04-10
 */
@Mapper
public interface GoodsDao extends BaseMapper<Goods> {

    List<Goods> selectRandom(@Param("gType") String gType);
    List<Goods> selectType(@Param("gType") String gType);
    List<Goods> selectInput(@Param("gName") String gName, @Param("gType") String gType);

    List<UG> selectGoodsAndUser();

    @Select("select * from goods where gid=#{gid}")
    Goods getOneGoods(Integer gid);

    int selectByGid(int gid);

    @Select("select uid from goods where gid=#{gid}")
    int selectMidByGid(int gid);

    @Insert("insert into comment(username,date,content) values(#{username},#{date},#{content})")
    int InsertComment(Comment comment);

    @Select("select * from comment")
    List<Comment> showComment();

    @Update("update goods set gname=#{gname},gcount=#{gcount},gprice=#{gprice},gtype=#{gtype},gdetails=#{gdetails} where gid=#{gid}")
    int updateOneGoods(Goods goods);

    @Delete("delete from goods where gid=#{gid}")
    int deleteOneGoods(@Param("gid") int gid);
}