package com.workec.wyf.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 测试是否可以多个config
 *
 * @author : wangyafei@ecqun.com
 * @date :  2018-04-18 16:33
 **/
@Component
@ConfigurationProperties(prefix = "web.girl")
public class NewWebConfig {

    private String name;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
