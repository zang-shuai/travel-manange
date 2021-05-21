package com.tjut.dao.impl;

import com.tjut.dao.UserDao;
import com.tjut.entity.User;
import com.tjut.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Objects;

public class UserDaoImpl implements UserDao {

    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findUserByUsernameAndPassword(String UName, String UPassword) {

        String sql = "select * from user where UName=? and UPassword= ?";
        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), UName, UPassword);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void add(User user) {
        String sql = "insert into user values (null,?,?,?,?,?,?)";
        template.update(sql, user.getUName(), user.getUAge(), user.getUTelephonenumber(), user.getUPassword(), user.getUHead(), user.getUPower());
    }

    @Override
    public String getNameById(Integer id) {
        String sql = "select uname  from user where uid=?";
        String s;
        try {
            s= Objects.requireNonNull(template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id)).getUName();
        } catch (Exception e) {
            return null;
        }
        return s;
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from user where UId=?";
        template.update(sql, id);
    }

    @Override
    public User findByTelephoneNumber(String utelephonenumber) {
        String sql = "select *from user where utelephonenumber=?";
        User user;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), utelephonenumber);
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    @Override
    public User findById(Integer id) {
        String sql = "select *from user where uid=?";
        User user;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    @Override
    public void update(User user) {
        String sql = "update user set Uname = ?,UAge = ? ,UTelephonenumber = ? , UPassword = ? , UHead = ?, UPower = ? where UId = ?";
        template.update(sql, user.getUName(), user.getUAge(), user.getUTelephonenumber(), user.getUPassword(), user.getUHead(), user.getUPower(), user.getUId());
    }
}
