package com.logic.service.impl;

import com.logic.mapper.UserMapper;
import com.logic.model.User;
import com.logic.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jiming.luo
 * @date 2018/1/31 14:00
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserService{
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
}
