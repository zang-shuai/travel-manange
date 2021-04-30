package com.tjut.dao;


import com.tjut.entity.Orders;
import com.tjut.entity.Plan;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface PlanDao {
    List<Plan> findAll();

    void add(Plan plan);

    void delete(Integer id);

    Plan findByPId(Integer pid);

    List<Plan> findByGId(Integer gid);

    List<Plan> findByTId(Integer tid);

    void update(Plan plan);

    Integer plusOne(Integer pid);
}