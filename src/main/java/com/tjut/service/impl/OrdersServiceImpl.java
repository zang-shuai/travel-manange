package com.tjut.service.impl;

import com.tjut.dao.InsuranceDao;
import com.tjut.dao.OrdersDao;
import com.tjut.dao.PlanDao;
import com.tjut.dao.impl.InsuranceDaoImpl;
import com.tjut.dao.impl.OrdersDaoImpl;
import com.tjut.dao.impl.PlanDaoImpl;
import com.tjut.entity.Orders;
import com.tjut.entity.Plan;
import com.tjut.entity.WorkTime;
import com.tjut.service.OrdersService;
import com.tjut.service.PlanService;

import java.util.List;

public class OrdersServiceImpl implements OrdersService {
    private final OrdersDao ordersDao = new OrdersDaoImpl();
    private final PlanDao planDao = new PlanDaoImpl();
    private final PlanService planService = new PlanServiceImpl();
    private final InsuranceDao insuranceDao = new InsuranceDaoImpl();

    @Override
    public void add(Orders orders) {
        ordersDao.add(orders);
    }

    @Override
    public void delete(Integer id) {
        ordersDao.delete(id);
    }

    @Override
    public List<Orders> findByUId(Integer uid) {
        List<Orders> Orders = ordersDao.findByUId(uid);
        for (Orders o : Orders) {
            Plan p = planService.findByPId(o.getPId());
            o.setPlan(p);
            o.setInsurance(insuranceDao.findById(o.getSId()));
        }
        System.out.println(Orders);
        return Orders;
    }

    @Override
    public List<Orders> findByPId(Integer pid) {
        List<Orders> Orders = ordersDao.findByPId(pid);
        for (Orders o : Orders) {
            Plan p = planService.findByPId(o.getPId());
            o.setPlan(p);
            o.setInsurance(insuranceDao.findById(o.getSId()));
        }
        return Orders;
    }

    @Override
    public Orders findByOId(Integer oid) {
        return ordersDao.findByOId(oid);
    }

    @Override
    public List<WorkTime> findUsersTime(Integer uid) {
        return ordersDao.findUsersTime(uid);
    }
}
