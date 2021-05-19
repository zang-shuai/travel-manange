package com.tjut.service.impl;

import com.tjut.dao.GuiderDao;
import com.tjut.dao.InsuranceDao;
import com.tjut.dao.impl.GuiderDaoImpl;
import com.tjut.dao.impl.InsuranceDaoImpl;
import com.tjut.entity.Insurance;
import com.tjut.service.InsuranceService;

import java.util.List;

public class InsuranceServiceImpl implements InsuranceService {
    private final InsuranceDao insuranceDao = new InsuranceDaoImpl();

    @Override
    public List<Insurance> findAll() {
        return insuranceDao.findAll();
    }

    @Override
    public int add(Insurance insurance) {
        return insuranceDao.add(insurance);
    }

    @Override
    public int delete(Integer id) {
        return insuranceDao.delete(id);
    }

    @Override
    public Insurance findById(Integer id) {
        return insuranceDao.findById(id);
    }

    @Override
    public int update(Insurance insurance) {
        return insuranceDao.update(insurance);
    }
}
