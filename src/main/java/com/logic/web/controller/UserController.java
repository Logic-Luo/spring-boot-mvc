package com.logic.web.controller;

import com.logic.model.User;
import com.logic.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jiming.luo
 * @date 2018/1/31 14:02
 * @since 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/addUser")
    @ResponseBody
    public Integer addUser(User user) {
        return userService.addUser(user);
    }

    @RequestMapping("/listUsers")
    @ResponseBody
    public List<User> listUsers() {
        return userService.listUsers();
    }
}
