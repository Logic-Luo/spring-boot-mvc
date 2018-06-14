package com.logic.service.impl;

import com.logic.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    public void addUser() {
    }

    @Test
    public void listUsers() {
    }

    @Test
    public void modifyUser() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                userService.modifyUser(10, "1111");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.setName("事务1");
        thread.start();

        Thread thread1 = new Thread(() -> {
            try {
                userService.modifyUser12(5, "222");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.setName("事务2");
        thread1.start();

        TimeUnit.SECONDS.sleep(30);
    }
}