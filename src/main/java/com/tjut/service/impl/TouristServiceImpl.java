package com.tjut.service.impl;

import com.tjut.dao.TouristDao;
import com.tjut.dao.TouristImgDao;
import com.tjut.dao.UserDao;
import com.tjut.dao.impl.TouristDaoImpl;
import com.tjut.dao.impl.TouristImgDaoImpl;
import com.tjut.dao.impl.UserDaoImpl;
import com.tjut.entity.Tourist;
import com.tjut.entity.TouristImg;
import com.tjut.service.TouristService;

import java.util.ArrayList;
import java.util.List;

public class TouristServiceImpl implements TouristService {
    private final TouristDao dao = new TouristDaoImpl();
    private final TouristImgDao touristImgDao = new TouristImgDaoImpl();

    @Override
    public List<Tourist> findAll() {
        List<Tourist> all = dao.findAll();
        for (Tourist t : all) {
            t.setTouristImg(touristImgDao.findByTId(t.getTId()));
        }
        return all;
    }

    @Override
    public String getNameById(Integer id) {
        return dao.getNameById(id);
    }

    @Override
    public Tourist login(Tourist tourist) {
        return null;
    }

    @Override
    public void addTourist(Tourist tourist) {
        dao.add(tourist);
        Tourist byIdSecond = dao.findByIdSecond(tourist.getTIdSecond());
        for (TouristImg touristImg : tourist.getTouristImg()) {
            touristImg.setTId(byIdSecond.getTId());
            touristImgDao.add(touristImg);
        }
    }

    @Override
    public void deleteTourist(Integer id) {

    }

    @Override
    public Tourist findTouristById(Integer id) {
        Tourist byId = dao.findById(id);
        List<TouristImg> byTId = touristImgDao.findByTId(byId.getTId());
        byId.setTouristImg(byTId);
        return byId;
    }

    @Override
    public void updateTourist(Tourist tourist) {

    }
}
