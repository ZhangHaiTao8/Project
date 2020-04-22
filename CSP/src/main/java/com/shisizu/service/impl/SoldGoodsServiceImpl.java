package com.shisizu.service.impl;

import com.shisizu.dao.SoldGoodsDao;
import com.shisizu.domain.SoldGoods;
import com.shisizu.domain.UG;
import com.shisizu.service.SoldGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 袁红
 * @create 2020-04-14-15:49
 */
@Service
public class SoldGoodsServiceImpl implements SoldGoodsService {

    @Autowired
    private SoldGoodsDao soldGoodsDao;

    @Override
    public int selectByGid(int gid) {
        return soldGoodsDao.selectByGid(gid);
    }

    @Override
    public int soldGoodsInsert(UG ug) {
        return soldGoodsDao.soldGoodsInsert(ug);
    }
}
