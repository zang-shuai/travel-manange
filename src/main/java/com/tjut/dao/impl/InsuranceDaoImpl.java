package com.tjut.dao.impl;

import com.tjut.dao.InsuranceDao;
import com.tjut.entity.Insurance;
import com.tjut.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class InsuranceDaoImpl implements InsuranceDao {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Insurance> findAll() {
        String sql = "select * from insurance";
        return template.query(sql, new BeanPropertyRowMapper<>(Insurance.class));
    }

    @Override
    public int add(Insurance insurance) {
        String sql = "insert into insurance values (null,?,?)";
        return template.update(sql, insurance.getSName(), insurance.getSPrice());
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from orders where oid=?";
        return template.update(sql, id);
    }

    @Override
    public Insurance findById(Integer id) {
        String sql = "select * from insurance where insurance.sid=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(Insurance.class), id);
    }

    @Override
    public int update(Insurance insurance) {
        String sql = "update insurance set sname = ?,sprice=? where sid = ?";
        return template.update(sql, insurance.getSName(), insurance.getSPrice(), insurance.getSId());
    }
}
