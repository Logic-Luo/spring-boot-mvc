package com.logic.mapper;

import com.logic.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.nio.file.attribute.UserPrincipalNotFoundException;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;
    @Test
    public void addUser() throws Exception {
        User user = new User();
        user.setPassword("root");
        user.setUsername("root");
        Integer integer = userMapper.addUser(user);
        Assert.assertEquals(new Integer(1), integer);
    }
}