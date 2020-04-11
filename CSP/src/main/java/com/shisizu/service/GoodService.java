package com.shisizu.service;

import com.shisizu.domain.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZhangCaiLei
 * @date 2020-04-10
 */

public interface GoodService {

    List<Good> selectRandom();
    List<Good> selectType(String gType);
}
