package com.tjut.dao.impl;

import com.tjut.dao.GuiderDao;
import com.tjut.entity.Guider;
import com.tjut.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Objects;

public class GuiderDaoImpl implements GuiderDao {

    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public String getNameById(Integer id) {
        String sql = "select gname  from guider where gid=?";
        try {
            return Objects.requireNonNull(template.queryForObject(sql, new BeanPropertyRowMapper<>(Guider.class), id)).getGName();
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public List<Guider> findAll() {
        //使用JDBC操作数据库...
        //1.定义sql
        String sql = "select * from guider";
        return template.query(sql, new BeanPropertyRowMapper<>(Guider.class));
    }

    @Override
    public Guider findGuiderByGuidernameAndPassword(String guidername, String password) {
        String sql = "select * from guider where GName=? and GPassword= ?";
        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper<>(Guider.class), guidername, password);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void add(Guider guider) {
        String sql = "insert into guider values (null,?,?,?,?,?,?)";
        template.update(sql, guider.getGName(), guider.getGAge(), guider.getGTelephonenumber(), guider.getGPassword(), guider.getGHead(), guider.getGIntroduce());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from guider where GId=?";
        template.update(sql, id);
    }

    @Override
    public Guider findByTelephoneNumber(String utelephonenumber) {
        String sql = "select *from guider where Gtelephonenumber=?";
        Guider guider;
        try {
            guider = template.queryForObject(sql, new BeanPropertyRowMapper<>(Guider.class), utelephonenumber);
        } catch (Exception e) {
            return null;
        }
        return guider;
    }

    @Override
    public Guider findById(String gid) {
        String sql = "select *from guider where gid=?";
        Guider guider;
        try {
            guider = template.queryForObject(sql, new BeanPropertyRowMapper<>(Guider.class), gid);
        } catch (Exception e) {
            return null;
        }
        return guider;
    }

    @Override
    public void update(Guider guider) {
        String sql = "update guider set GName = ?,GAge = ? ,GTelephonenumber = ? , GPassword = ? , GHead = ? where GId = ?";
        template.update(sql, guider.getGName(), guider.getGAge(), guider.getGTelephonenumber(), guider.getGPassword(), guider.getGHead(), guider.getGId());
    }
}
