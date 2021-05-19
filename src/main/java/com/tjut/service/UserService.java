package com.tjut.service;

import com.tjut.entity.User;

import java.util.List;


/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> findAll();


    User login(User user);
    String getNameById(Integer id);


    void addUser(User user);

    void deleteUser(Integer id);

    User findUserByTelephoneNumber(String id);

    void updateUser(User user);

}
