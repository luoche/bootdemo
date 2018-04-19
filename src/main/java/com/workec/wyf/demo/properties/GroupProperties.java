package com.workec.wyf.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : wangyafei@ecqun.com
 * @date :  2018-04-18 15:08
 **/
// 不加这个，不会被注释到bean
@Component
@ConfigurationProperties(prefix = "common")
public class GroupProperties {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "GroupEntity{" +
                "age='" + age + '\'' +
                '}';
    }
}
