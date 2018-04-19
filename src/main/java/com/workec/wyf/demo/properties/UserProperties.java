package com.workec.wyf.demo.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 用户的实体类
 *
 * @author : wangyafei@ecqun.com
 * @date :  2018-04-18 14:04
 **/
@Component
public class UserProperties {

    /**
     *  直接常量 : 注解普通字符串
     */
    @Value("1")
    private Integer id;

    /**
     * 注解：可以使用常量
     */
    @Value("${app.name}")
    private String name;

    @Value("${comnon.email}")
    private String email;

    @Value("${comnon.desc}")
    private String desc;

    @Value("${comnon.age}")
    private int age;

    /**
     * 注入操作系统属性
     */
    @Value("#{systemProperties['os.name']}")
    private String systemPropertiesName;

    public String getSystemPropertiesName() {
        return systemPropertiesName;
    }

    public void setSystemPropertiesName(String systemPropertiesName) {
        this.systemPropertiesName = systemPropertiesName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public UserProperties() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", desc='" + desc + '\'' +
                ", age=" + age +
                ", systemPropertiesName='" + systemPropertiesName + '\'' +
                '}';
    }
}
