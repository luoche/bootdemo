package com.workec.wyf.demo.controller;

import com.workec.wyf.demo.entity.User;
import com.workec.wyf.demo.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.*;

/**
 * 用户中心
 *
 * @author : wangyafei@ecqun.com
 * @date :  2018-04-19 11:03
 **/
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public User user(@RequestParam("name") String name, @RequestParam("age") Integer age) {

        User user = new User();
        user.setName(name);
        user.setAge(age);

        return userRepository.save(user);
    }

    @GetMapping(value = "/userList")
    public List<User> getUserList() {
        return userRepository.findAll();
    }


    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") long id) {

        // boot 2.0 之后 不用用 findOne 直接使用 getOne
        // findbyid（id).get()
        return userRepository.findById(id).get();

//        User user = userRepository.findById(id);
//        return user;

        // jpa 类返回的是一个 optional 对象
//        Optional<User> user = userRepository.findById(id);
//        return user.get();

//        User user = userRepository.findOne(id);
    }

    @PutMapping("/user/{id}")
    public String updateUser(@PathVariable("id") Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "age", required = false) Integer age) {

        // todo
        userRepository.setUserInfoById(id, name);

        return "end";
//        User user = new User();
//        user.setId(id);
//        user.setName(name);
//        user.setAge(age);
//
//        return userRepository.save(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        // todo
//        return userRepository.deleteById(id);
    }

    @GetMapping("/select/name/{name}")
    public User getUserByName(@PathVariable("name") String name) {

        // 根据属性查询
        return userRepository.findByName(name);
    }

    @GetMapping("/delete/name/{name}")
    public String deleteUser(@PathVariable("name") String name) {
        // 通过dao层的一个封装
        // 实际应用中应该使用 service
        Integer id = userRepository.deleteUserByName(name);

        return "delete:" + id;
    }

    @GetMapping("/page")
    public Page<User> getPageUser() {
        // 已经过时的分页
        // 换成新版的
        Pageable   pageable = PageRequest.of(0, 5, Direction.DESC, "id");
        Page<User> datas    = userRepository.findAll(pageable);

        System.out.println("总条数：" + datas.getTotalElements());
        System.out.println("总页数：" + datas.getTotalPages());

        return datas;
    }
}
