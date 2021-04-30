package com.tjut.service.impl;

import com.tjut.dao.TouristImgDao;
import com.tjut.dao.impl.TouristImgDaoImpl;
import com.tjut.entity.TouristImg;
import com.tjut.service.TouristImgService;

import java.util.List;

public class TouristImgServiceImpl implements TouristImgService {
    TouristImgDao touristImgDao = new TouristImgDaoImpl();

    @Override
    public List<TouristImg> findByTId(Integer tid) {
        return null;
    }

    @Override
    public void add(TouristImg TouristImg) {

    }

    @Override
    public TouristImg findById(Integer iid) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
