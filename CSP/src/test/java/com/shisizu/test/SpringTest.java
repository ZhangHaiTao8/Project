package com.shisizu.test;

import com.shisizu.dao.UserDao;
import com.shisizu.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 袁红
 * @create 2020-04-06-12:15
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringTest {

    @Autowired
    private UserDao userDao;
    @Test
    public void test(){
        System.out.println("666");
    }

    @Test
    public void index(){
        List<User> users = userDao.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testName(){
        User user = userDao.selectByName("张三");
        System.out.println(user);
    }

}
