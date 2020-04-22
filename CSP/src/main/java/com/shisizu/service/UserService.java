package com.shisizu.service;

import com.shisizu.domain.User;
import org.springframework.stereotype.Service;

/**
 * @author 袁红
 * @create 2020-04-07-18:56
 */
@Service
public interface UserService {

    User selectUserByExample(String uphone, String upassword);

    int userRegisterInsert(User user);

    User selectByName(String uphone);

    String selectCodeByEmail(String uemail);

    int updateCodeByOldCode(String uemail, String upassword2);

    User checkUser(String uname);
}
