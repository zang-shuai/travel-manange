package com.tjut.dao;


import com.tjut.entity.TouristImg;
import com.tjut.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的DAO
 */
public interface UserDao {
    List<User> findAll();

    User findUserByUsernameAndPassword(String username, String password);

    void add(User user);

    String getNameById(Integer id);

    void delete(Integer id);

    User findByTelephoneNumber(String parseInt);

    User findById(String id);

    void update(User user);
}
