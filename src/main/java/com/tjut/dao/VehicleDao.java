package com.tjut.dao;


import com.tjut.entity.User;
import com.tjut.entity.Vehicle;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface VehicleDao {
    List<Vehicle> findAll();

    void add(Vehicle Vehicle);

    void delete(Integer id);

    Vehicle findById(Integer id);
    List<Vehicle> findByPId(Integer pid);

    void update(Vehicle Vehicle);
}
