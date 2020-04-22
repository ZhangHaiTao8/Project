package com.shisizu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shisizu.domain.ShoppingCart;
import com.shisizu.domain.SoldGoods;
import com.shisizu.domain.UG;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 袁红
 * @create 2020-04-12-13:46
 */
@Mapper
public interface SoldGoodsDao extends BaseMapper<SoldGoods> {
    int selectByGid(int gid);

    int soldGoodsInsert(UG ug);
}
