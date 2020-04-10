package com.shisizu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shisizu.domain.Good;
import com.shisizu.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZhangCaiLei
 * @date 2020-04-10
 */
@Mapper
public interface GoodDao extends BaseMapper<Good> {

    List<Good> selectAll();
}