package com.logic.service;

import com.logic.model.User;

import java.util.List;

/**
 * @author jiming.luo
 * @date 2018/1/31 13:59
 * @since 1.0
 */
public interface UserService {
   Integer addUser(User user);

   List<User> listUsers();
}
