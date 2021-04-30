package com.tjut.service.impl;

import com.tjut.dao.UserDao;
import com.tjut.dao.impl.UserDaoImpl;
import com.tjut.entity.User;
import com.tjut.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private final UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUName(), user.getUPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(Integer id) {
        dao.delete(id);
    }

    @Override
    public User findUserByTelephoneNumber(String id) {
        User byId = dao.findByTelephoneNumber(id);
        return byId;
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }


}
