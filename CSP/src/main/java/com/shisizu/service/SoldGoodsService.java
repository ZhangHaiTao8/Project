package com.shisizu.service;

import com.shisizu.domain.UG;
import org.springframework.stereotype.Service;

/**
 * @author 袁红
 * @create 2020-04-14-15:49
 */
@Service
public interface SoldGoodsService {

    int selectByGid(int gid);

    int soldGoodsInsert(UG ug);
}
