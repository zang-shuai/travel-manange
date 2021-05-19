package com.tjut.dao;

import com.tjut.entity.Insurance;

import java.util.List;

public interface InsuranceDao {
    List<Insurance> findAll();

    int add(Insurance insurance);

    int delete(Integer id);

    Insurance findById(Integer id);

    int update(Insurance insurance);
}
