package com.workec.wyf.demo.repository;

import com.workec.wyf.demo.entity.User;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * dao层
 *
 * @author : wangyafei@ecqun.com
 * @date :  2018-04-19 11:00
 **/
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 通过用户id 获取用户对象 （重写的）
     *
     * @param id 主键id
     * @return User
     */
//    User findById(long id);


    @Modifying
    @Transactional
    @Query("update User set name = ?2 where id = ?1")
    void setUserInfoById(Long id, String name);

    User findByName(String name);

    @Modifying
    @Transactional
    @Query("delete from User user where user.name = ?1")
    int deleteUserByName(String name);


}
