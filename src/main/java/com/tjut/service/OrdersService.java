package com.tjut.service;


import com.tjut.entity.Orders;
import com.tjut.entity.WorkTime;

import java.util.List;

/**
 * 用户操作的DAO
 * 1. 用户已经购买了该订单
 *      1. 检查是否有该订单
 *      2. 如果没有则购买并且返回成功，否则返回失败
 */
public interface OrdersService {
    void add(Orders orders);

    void delete(Integer id);

    List<Orders> findByUId(Integer uid);
    List<Orders> findByPId(Integer pid);
    Orders findByOId(Integer oid);
    List<WorkTime>  findUsersTime(Integer uid);

}
