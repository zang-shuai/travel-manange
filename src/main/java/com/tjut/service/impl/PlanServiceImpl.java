package com.tjut.service.impl;

import com.tjut.dao.PlanDao;
import com.tjut.dao.impl.PlanDaoImpl;
import com.tjut.entity.Guider;
import com.tjut.entity.Plan;
import com.tjut.entity.WorkTime;
import com.tjut.entity.WorkTimeTable;
import com.tjut.service.PlanService;

import java.util.ArrayList;
import java.util.List;

public class PlanServiceImpl implements PlanService {
    private PlanDao planDao = new PlanDaoImpl();

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
    public List<WorkTimeTable> getAllGuidersWorkTime() {
        List<Plan> all = planDao.findAll();
        List<WorkTimeTable> l = new ArrayList<>();
        List<Integer> guider = new ArrayList<>();
        for (Plan p : all) {
            Integer gId = p.getGId();
            if (guider.contains(gId)) {
                for (WorkTimeTable w : l) {
                    if (w.getG().getGId().equals(gId)) {
                        WorkTime time = new WorkTime();
                        time.setStart(p.getPStartDate());
                        time.setEnd(p.getPEndDate());
                        w.add(time);
                    }
                }
            } else {
                guider.add(gId);
                WorkTimeTable workTimeTable = new WorkTimeTable();
                WorkTime time = new WorkTime();
                time.setStart(p.getPStartDate());
                time.setEnd(p.getPEndDate());
                Guider guider1 = new Guider();
                workTimeTable.setG(guider1);
                workTimeTable.add(time);
                l.add(workTimeTable);
            }
        }
        return l;
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