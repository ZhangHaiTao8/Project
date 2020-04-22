package com.shisizu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shisizu.domain.Goods;
import com.shisizu.domain.ShoppingCart;
import com.shisizu.domain.UG;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 袁红
 * @create 2020-04-12-13:46
 */
@Mapper
public interface ShoppingCartDao extends BaseMapper<ShoppingCart> {
    List<ShoppingCart> selectShoppingCart(@Param("cid") Integer cid,@Param("gid") Integer gid);

    int addShoppingCart(@Param("gid") Integer gid,@Param("cid") Integer cid);

    int deleteShoppingCart(@Param("gid") Integer gid,@Param("cid") Integer cid);
    int deleteShoppingCartAll(int cid);
}
