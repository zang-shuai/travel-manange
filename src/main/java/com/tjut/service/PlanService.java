package com.tjut.service;


import com.tjut.entity.Plan;
import com.tjut.entity.WorkTime;
import com.tjut.entity.WorkTimeTable;

//import javax.resource.spi.work.Work;
import java.util.List;

/**
 * 用户操作的DAO
 */
public interface PlanService {
    List<Plan> findAll();

    void add(Plan plan);

    void delete(Integer id);

    Plan findByPId(Integer pid);

    List<Plan> findByGId(Integer gid);

    List<WorkTimeTable> getAllGuidersWorkTime();

    List<Plan> findByTId(Integer tid);

    void update(Plan plan);

    Integer plusOne(Integer pid);
}