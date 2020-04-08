package com.shisizu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shisizu.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 袁红
 * @create 2020-04-06-14:46
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

    User selectByName(String name);//测试

    User selectUserByExample(@Param("uphone") String uphone, @Param("upassword") String upassword);

    int userRegisterInsert(User user);
}
