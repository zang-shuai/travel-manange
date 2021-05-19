package com.tjut.service.impl;

import com.tjut.dao.GuiderDao;
import com.tjut.service.GuiderService;
import com.tjut.dao.impl.GuiderDaoImpl;
import com.tjut.entity.Guider;

import java.util.List;

public class GuiderServiceImpl implements GuiderService {
    private final GuiderDao guiderDao = new GuiderDaoImpl();

    @Override
    public List<Guider> findAll() {
        return guiderDao.findAll();
    }

    @Override
    public Guider findGuiderByGuidernameAndPassword(String guidername, String password) {
        return null;
    }

    @Override
    public String getNameById(Integer id) {
        return guiderDao.getNameById(id);
    }

    @Override
    public void add(Guider guider) {
        guiderDao.add(guider);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Guider findByTelephoneNumber(String tel) {
        return guiderDao.findByTelephoneNumber(tel);
    }

    @Override
    public Guider findById(Integer id) {
        return guiderDao.findById(id);
    }

    @Override
    public void update(Guider Guider) {

    }
}
