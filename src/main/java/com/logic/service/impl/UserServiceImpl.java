package com.logic.service.impl;

import com.logic.mapper.UserMapper;
import com.logic.model.User;
import com.logic.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author jiming.luo
 * @date 2018/1/31 14:00
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public List<User> listUsers() {
        return userMapper.listUsers();
    }

    @Transactional(isolation=Isolation.SERIALIZABLE)
    public boolean modifyUser(int sleep, String password) throws InterruptedException {
        User user1 = userMapper.listUsers().get(0);
        user1.setPassword("password1");
        userMapper.updateUser(user1);
        System.out.printf("开始睡眠： %s%n", Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(10);
        user1 = userMapper.listUsers().get(0);
        System.out.printf("%s 获取中间结果 %s%n", Thread.currentThread().getName(), user1);
        user1.setPassword("password2");
        userMapper.updateUser(user1);
        System.out.println("开始提交： " + Thread.currentThread().getName());
        return true;
    }

    @Transactional(isolation=Isolation.SERIALIZABLE)
    public boolean modifyUser12(int sleep, String password) throws InterruptedException {
        User user1 = userMapper.listUsers().get(0);
        System.out.printf("%s 获取中间结果 %s%n", Thread.currentThread().getName(), user1);
        TimeUnit.SECONDS.sleep(5);
        user1.setPassword("password3");
        userMapper.updateUser(user1);
        System.out.println("开始提交： " + Thread.currentThread().getName());
        return true;
    }

}
