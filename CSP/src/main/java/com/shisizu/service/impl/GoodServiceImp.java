package com.shisizu.service.impl;

import com.shisizu.dao.GoodDao;
import com.shisizu.domain.Good;
import com.shisizu.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhangCaiLei
 * @date 2020-04-10
 */

@Service
public class GoodServiceImp implements GoodService {

    @Autowired
    private GoodDao goodDao;

    @Override
    public List<Good> selectRandom() {
        return goodDao.selectRandom();
    }

    @Override
    public List<Good> selectType(String gType) {
        return goodDao.selectType(gType);
    }
}
