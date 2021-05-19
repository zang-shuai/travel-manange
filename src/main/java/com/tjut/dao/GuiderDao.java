package com.tjut.dao;

import com.tjut.entity.Guider;
import com.tjut.entity.Plan;

import java.util.List;

public interface GuiderDao {
    List<Guider> findAll();

    Guider findGuiderByGuidernameAndPassword(String guidername, String password);

    String getNameById(Integer id);


    void add(Guider Guider);

    void delete(Integer id);

    Guider findByTelephoneNumber(String parseInt);

    Guider findById(String cid);

    void update(Guider Guider);
}
