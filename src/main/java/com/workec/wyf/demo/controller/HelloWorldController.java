package com.workec.wyf.demo.controller;

import com.workec.wyf.demo.properties.GroupProperties;
import com.workec.wyf.demo.properties.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    // 因为这个太艰难了，失败了好多次
    @Autowired
    private UserProperties userProperties;

    @Autowired
    private GroupProperties groupProperties;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello ec";
    }

    
    @RequestMapping("world")
    public UserProperties world() {
        return userProperties;
        // 每次更新代码，需要重新启动
    }

    @GetMapping("/group")
    public GroupProperties group(){
        return groupProperties;
    }
}
