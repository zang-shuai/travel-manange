package com.tjut.dao.impl;

import com.tjut.dao.TouristImgDao;
import com.tjut.entity.TouristImg;
import com.tjut.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TouristImgDaoImpl implements TouristImgDao {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<TouristImg> findByTId(Integer tid) {
        String sql = "select * from touristimg where tid=?";
        return template.query(sql, new BeanPropertyRowMapper<>(TouristImg.class), tid);
    }

    @Override
    public void add(TouristImg touristImg) {
        String sql = "insert into touristimg values (null,?,?)";
        template.update(sql, touristImg.getTId(), touristImg.getTAddress());
    }

    @Override
    public TouristImg findById(Integer iid) {
        String sql = "select * from touristimg where iid=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(TouristImg.class), iid);
    }

    @Override
    public void delete(Integer iid) {
        String sql = "delete from touristimg where iid=?";
        template.update(sql, iid);
    }
}
