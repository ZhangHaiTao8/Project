package com.shisizu.service;

import com.shisizu.domain.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 袁红
 * @create 2020-04-14-13:52
 */
@Service
public interface ShoppingCartService {
    List<ShoppingCart> selectShoppingCart(Integer cid,Integer gid);

    int addShoppingCart(int gid, int cid);

    int deleteShoppingCart(int gid, int cid);
    int deleteShoppingCartAll(int cid);
}
