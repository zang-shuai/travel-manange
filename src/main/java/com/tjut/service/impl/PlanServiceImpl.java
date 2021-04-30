package com.tjut.service.impl;

import com.tjut.dao.PlanDao;
import com.tjut.dao.impl.PlanDaoImpl;
import com.tjut.entity.Plan;
import com.tjut.service.PlanService;

import java.util.List;

public class PlanServiceImpl implements PlanService {
    private PlanDao planDao=new PlanDaoImpl();
    @Override
    public List<Plan> findAll() {
        return null;
    }

    @Override
    public void add(Plan plan) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Plan findByPId(Integer pid) {
        return null;
    }

    @Override
    public List<Plan> findByGId(Integer gid) {
        return null;
    }

    @Override
    public List<Plan> findByTId(Integer tid) {
        return null;
    }

    @Override
    public void update(Plan plan) {

    }

    @Override
    public Integer plusOne(Integer pid) {
        return null;
    }
}
