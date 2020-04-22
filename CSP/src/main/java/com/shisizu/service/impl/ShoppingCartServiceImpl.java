package com.shisizu.service.impl;

import com.shisizu.dao.ShoppingCartDao;
import com.shisizu.domain.ShoppingCart;
import com.shisizu.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 袁红
 * @create 2020-04-14-13:53
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartDao shoppingCartDao;
    @Override
    public List<ShoppingCart> selectShoppingCart(Integer cid,Integer gid) {
        return shoppingCartDao.selectShoppingCart(cid,gid);
    }

    @Override
    public int addShoppingCart(int gid, int cid) {
        return shoppingCartDao.addShoppingCart(gid,cid);
    }

    @Override
    public int deleteShoppingCart(int gid, int cid) {
        return shoppingCartDao.deleteShoppingCart(gid,cid);
    }

    @Override
    public int deleteShoppingCartAll(int cid) {
        return shoppingCartDao.deleteShoppingCartAll(cid);
    }
}
