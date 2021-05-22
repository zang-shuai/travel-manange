package com.tjut.dao;


import com.tjut.entity.Orders;
import com.tjut.entity.WorkTime;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface OrdersDao {
    void add(Orders orders);

    void delete(Integer id);

    List<Orders> findByUId(Integer uid);
    List<Orders> findByPId(Integer pid);
    Orders findByOId(Integer oid);
    List<WorkTime>  findUsersTime(Integer uid);
}
