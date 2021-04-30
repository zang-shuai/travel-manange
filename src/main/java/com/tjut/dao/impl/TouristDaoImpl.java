package com.tjut.dao.impl;

import com.tjut.dao.TouristDao;
import com.tjut.entity.Tourist;
import com.tjut.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TouristDaoImpl implements TouristDao {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Tourist> findAll() {
        String sql = "select * from tourist";
        List<Tourist> query = template.query(sql, new BeanPropertyRowMapper<>(Tourist.class));
        return query;
    }

    @Override
    public void add(Tourist tourist) {
        String sql = "insert into tourist values (null,?,?,?,?)";
        template.update(sql, tourist.getTName(), tourist.getTIntroduce(), tourist.getTPrice(),tourist.getTIdSecond());

    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from tourist where tid=?";
        template.update(sql, id);
    }

    @Override
    public Tourist findById(Integer id) {
        String sql = "select * from tourist where tourist.tid=?";
        Tourist tourist = template.queryForObject(sql, new BeanPropertyRowMapper<>(Tourist.class), id);
        return tourist;
    }

    @Override
    public Tourist findByIdSecond(String id) {
        String sql = "select * from tourist where tourist.tidsecond=?";
        Tourist tourist = template.queryForObject(sql, new BeanPropertyRowMapper<>(Tourist.class), id);
        return tourist;
    }

    @Override
    public void update(Tourist tourist) {
        String sql = "update tourist set tname=?,tintroduce=?,tprice=?";
        template.update(sql,tourist.getTName(),tourist.getTIntroduce(),tourist.getTPrice());
    }
}
