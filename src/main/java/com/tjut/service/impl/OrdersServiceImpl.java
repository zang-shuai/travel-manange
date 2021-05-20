package com.tjut.service.impl;

import com.tjut.dao.OrdersDao;
import com.tjut.dao.impl.OrdersDaoImpl;
import com.tjut.entity.Orders;
import com.tjut.entity.WorkTime;
import com.tjut.service.OrdersService;

import java.util.List;

public class OrdersServiceImpl implements OrdersService {
    private final OrdersDao ordersDao = new OrdersDaoImpl();
    @Override
    public void add(Orders orders) {
        ordersDao.add(orders);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Orders> findByUId(Integer uid) {
        return ordersDao.findByUId(uid);
    }

    @Override
    public List<Orders> findByPId(Integer pid) {
        return ordersDao.findByPId(pid);
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
