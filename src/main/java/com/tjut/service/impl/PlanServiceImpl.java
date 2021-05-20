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
import com.tjut.service.GuiderService;
import com.tjut.service.PlanService;
import com.tjut.service.TouristService;

import java.util.*;

public class PlanServiceImpl implements PlanService {
    private final PlanDao planDao = new PlanDaoImpl();
    private final TouristService touristService = new TouristServiceImpl();
    private final GuiderService guiderService = new GuiderServiceImpl();

    @Override
    public List<Plan> findAll() {
        List<Plan> all = planDao.findAll();
        for (Plan p : all) {
            Guider g = guiderService.findById(p.getGId());
            Tourist t = touristService.findTouristById(p.getTId());
            p.setTourist(t);
            p.setGuider(g);
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
        Plan p = planDao.findByPId(pid);
        Tourist t = touristService.findTouristById(p.getTId());
        Guider g = guiderService.findById(p.getGId());
        p.setTourist(t);
        p.setGuider(g);
        return p;
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
                workTime.setPstartdate(pStartDate);
                workTime.setPenddate(pEndDate);
                wt.add(workTime);
            }
            workTimeTable.setL(wt);
            l.add(workTimeTable);
        }
        return l;
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