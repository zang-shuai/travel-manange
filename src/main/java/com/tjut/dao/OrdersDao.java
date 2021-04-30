package com.tjut.dao;


import com.tjut.entity.Orders;

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

}
