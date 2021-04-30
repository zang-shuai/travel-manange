package com.tjut.dao;


import com.tjut.entity.Tourist;
import com.tjut.entity.TouristImg;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface TouristImgDao {
    List<TouristImg> findByTId(Integer tid);

    void add(TouristImg TouristImg);
    TouristImg findById(Integer iid);

    void delete(Integer id);
}
