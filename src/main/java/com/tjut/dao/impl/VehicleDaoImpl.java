package com.tjut.dao.impl;

import com.tjut.dao.VehicleDao;
import com.tjut.dao.VehicleService;
import com.tjut.entity.Vehicle;
import com.tjut.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class VehicleDaoImpl implements VehicleDao {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Vehicle> findAll() {
        String sql = "select * from vehicle";
        return template.query(sql, new BeanPropertyRowMapper<>(Vehicle.class));
    }

    @Override
    public void add(Vehicle vehicle) {
        String sql = "insert into Vehicle values (null,?,?,?)";
        template.update(sql, vehicle.getVType(),vehicle.getVCapacity(),vehicle.getPId());
    }

    @Override
    public void delete(Integer id) {

        String sql = "delete from vehicle where vid=?";
        template.update(sql, id);
    }

    @Override
    public Vehicle findById(Integer id) {
        String sql = "select *from vehicle where vid=?";
        Vehicle vehicle;
        try {
            vehicle = template.queryForObject(sql, new BeanPropertyRowMapper<>(Vehicle.class), id);
        } catch (Exception e) {
            return null;
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> findByPId(Integer pid) {
        String sql = "select * from vehicle where pid=?";
        return template.query(sql, new BeanPropertyRowMapper<>(Vehicle.class),pid);
    }

    @Override
    public void update(Vehicle vehicle) {
        String sql = "update vehicle set vtype=?,vcapacity=? ,pid=? where vid = ?";
        template.update(sql,vehicle.getVType(),vehicle.getVCapacity(),vehicle.getPId());

    }
}
