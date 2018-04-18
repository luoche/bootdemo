package com.workec.wyf.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * boot测试
 *
 * @author : wangyafei@ecqun.com
 * @date :  2018-03-29 14:54
 **/

@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello ec";
    }

    
    @RequestMapping("world")
    public String world() {
        // 每次更新代码，需要重新启动
        return "This is all my world";
    }
}
