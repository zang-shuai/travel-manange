package com.tjut.service;

import com.tjut.entity.Tourist;
import com.tjut.entity.Tourist;

import java.util.List;

public interface TouristService {
    List<Tourist> findAll();

    String getNameById(Integer id);

    Tourist login(Tourist tourist);


    void addTourist(Tourist tourist);

    void deleteTourist(Integer id);

    Tourist findTouristById(Integer id);

    void updateTourist(Tourist tourist);
}
