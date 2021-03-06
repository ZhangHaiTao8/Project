package com.shisizu.service.impl;

import com.shisizu.dao.UserDao;
import com.shisizu.domain.User;
import com.shisizu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 袁红
 * @create 2020-04-07-18:57
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserByExample(String uphone, String upassword) {
        return userDao.selectUserByExample(uphone,upassword);
    }

    @Override
    public int userRegisterInsert(User user) {
        return userDao.userRegisterInsert(user);
    }

    @Override
    public User selectByName(String uphone) {
        return userDao.selectByName(uphone);
    }

    @Override
    public String selectCodeByEmail(String uemail) {
        return userDao.selectCodeByEmail(uemail);
    }

    @Override
    public int updateCodeByOldCode(String uemail, String upassword2) {
        return userDao.updateCodeByOldCode(uemail,upassword2);
    }

    @Override
    public User checkUser(String uname) {
        return userDao.checkUser(uname);
    }
}
