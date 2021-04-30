package com.tjut.service;


import com.tjut.entity.TouristImg;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface TouristImgService {
    List<TouristImg> findByTId(Integer tid);

    void add(TouristImg TouristImg);
    TouristImg findById(Integer iid);

    void delete(Integer id);
}
