package com.tjut.service;

import com.tjut.entity.Insurance;

import java.util.List;

public interface InsuranceService {
    List<Insurance> findAll();

    int add(Insurance insurance);

    int delete(Integer id);

    Insurance findById(Integer id);

    int update(Insurance insurance);
}
