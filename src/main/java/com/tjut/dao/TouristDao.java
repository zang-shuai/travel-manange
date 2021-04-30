package com.tjut.dao;

import com.tjut.entity.Orders;
import com.tjut.entity.Tourist;

import java.util.List;

public interface TouristDao {
    List<Tourist> findAll();

    void add(Tourist tourist);

    void delete(Integer id);
    Tourist findById(Integer id);
    Tourist findByIdSecond(String id);

    void update(Tourist tourist);
}
