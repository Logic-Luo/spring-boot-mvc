package com.logic.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jiming.luo
 * @date 2018/1/31 13:27
 * @since 1.0
 */
@Controller
@RequestMapping("/")
public class TestController {
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

    @RequestMapping("/")
    @ResponseBody
    public String helloWorld() {
        return "Hello Word";
    }
}
