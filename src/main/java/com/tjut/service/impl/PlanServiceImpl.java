package com.tjut.service.impl;

import com.tjut.dao.GuiderDao;
import com.tjut.dao.PlanDao;
import com.tjut.dao.TouristDao;
import com.tjut.dao.TouristImgDao;
import com.tjut.dao.impl.GuiderDaoImpl;
import com.tjut.dao.impl.PlanDaoImpl;
import com.tjut.dao.impl.TouristDaoImpl;
import com.tjut.dao.impl.TouristImgDaoImpl;
import com.tjut.entity.*;
import com.tjut.service.PlanService;

import java.util.*;

public class PlanServiceImpl implements PlanService {
    private final PlanDao planDao = new PlanDaoImpl();
    private final TouristDao touristDao = new TouristDaoImpl();

    @Override
    public List<Plan> findAll() {
        List<Plan> all = planDao.findAll();
        for (Plan p : all) {
            Tourist t = touristDao.findById(p.getTId());
            p.setTourist(t);
        }
        return all;
    }

    @Override
    public void add(Plan plan) {
        planDao.add(plan);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Plan findByPId(Integer pid) {
        Plan byPId = planDao.findByPId(pid);
        Tourist t = touristDao.findById(byPId.getTId());
        byPId.setTourist(t);
        return byPId;
    }

    @Override
    public List<Plan> findByGId(Integer gid) {
        return null;
    }

    @Override
    public List<WorkTimeTable> getAllGuidersWorkTime() {

        PlanDao planDao = new PlanDaoImpl();
        GuiderDao guiderDao = new GuiderDaoImpl();
        List<WorkTimeTable> l = new ArrayList<>();
        List<Guider> all = guiderDao.findAll();
        for (Guider guider : all) {
            WorkTimeTable workTimeTable = new WorkTimeTable();
            workTimeTable.setG(guider);
            List<Plan> byGId = planDao.findByGId(guider.getGId());
            List<WorkTime> wt = new ArrayList<>();
            for (Plan p : byGId) {
                Date pStartDate = p.getPStartDate();
                Date pEndDate = p.getPEndDate();
                WorkTime workTime = new WorkTime();
                workTime.setStart(pStartDate);
                workTime.setEnd(pEndDate);
                wt.add(workTime);
            }
            workTimeTable.setL(wt);
            l.add(workTimeTable);
        }
        return l;
    }

//    @Override
//    public List<WorkTimeTable> getAllGuidersWorkTime() {
//        List<Plan> all = planDao.findAll();
//        List<WorkTimeTable> l = new ArrayList<>();
//        List<Integer> guider = new ArrayList<>();
//        for (Plan p : all) {
//            Integer gId = p.getGId();
//            if (guider.contains(gId)) {
//                for (WorkTimeTable w : l) {
//                    if (w.getG().getGId().equals(gId)) {
//                        WorkTime time = new WorkTime();
//                        time.setStart(p.getPStartDate());
//                        time.setEnd(p.getPEndDate());
//                        w.add(time);
//                    }
//                }
//            } else {
//                guider.add(gId);
//                WorkTimeTable workTimeTable = new WorkTimeTable();
//
//                WorkTime time = new WorkTime();
//                time.setStart(p.getPStartDate());
//                time.setEnd(p.getPEndDate());
//
//
//                Guider guider1 = new Guider();
//                workTimeTable.setG(guider1);
//                workTimeTable.add(time);
//                l.add(workTimeTable);
//            }
//        }
//        for(WorkTimeTable w:l){
//            List<WorkTime> l1 = w.getL();
//            l1.sort(Comparator.comparing(WorkTime::getStart));
//        }
//        return l;
//    }

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