package com.shisizu.service;

import com.shisizu.domain.User;

/**
 * @author 袁红
 * @create 2020-04-07-18:56
 */
public interface UserService {

    User selectUserByExample(String uphone, String upassword);

    int userRegisterInsert(User user);
}
