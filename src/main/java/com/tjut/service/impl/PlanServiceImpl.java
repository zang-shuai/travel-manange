package com.tjut.service.impl;

import com.tjut.dao.PlanDao;
import com.tjut.dao.impl.PlanDaoImpl;
import com.tjut.entity.Plan;
import com.tjut.entity.WorkTime;
import com.tjut.entity.WorkTimeTable;
import com.tjut.service.PlanService;

import java.util.ArrayList;
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
    public List<WorkTime> getAllGuidersWorkTime() {
        List<Plan> all = planDao.findAll();
        List<WorkTimeTable> l=new ArrayList<>();
        List<Integer> guider=new ArrayList<>();
        for(Plan p:all){
            Integer gId = p.getGId();
            boolean contains = guider.contains(gId);
            if(contains){

            }else {

            }
        }
        return null;
    }

//    1. 程序的输入数据
//    2. 程序运行后反馈的预期结果
//    测试用例，测试工作，预期结果，

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
