package com.shisizu.service.impl;

import com.shisizu.dao.AdminDao;
import com.shisizu.domain.Admin;
import com.shisizu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 袁红
 * @create 2020-04-11-19:02
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin selectAdmin(String admName, String admPassword) {
        return adminDao.selectAdmin(admName,admPassword);
    }
}
