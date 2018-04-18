package com.workec.wyf.demo.controller;

import com.workec.wyf.demo.config.NewWebConfig;
import com.workec.wyf.demo.config.WebConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试config文件
 *  测试成功说明可以使用多个的config
 *  Q1 ：config 文件，或者准确的说是 properties 应该放在的目录位置
 *      是 config下还是 dao
 *
 * @author : wangyafei@ecqun.com
 * @date :  2018-04-18 16:29
 **/
@RestController
public class ConfigController {

    @Autowired
    public WebConfig webConfig;

    @Autowired
    public NewWebConfig newWebConfig;

    @RequestMapping("/config")
    public WebConfig index() {
        return webConfig;
    }

    @GetMapping("/newConfig")
    public NewWebConfig getConfig(){
        return  newWebConfig;
    }

}
