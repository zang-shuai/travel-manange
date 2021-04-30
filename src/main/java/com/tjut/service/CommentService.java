package com.tjut.service;


import com.tjut.entity.Comment;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface CommentService {
    void add(Comment comment);

    void delete(Integer id);

    Comment findById(Integer cid);
    List<Comment> findByUId(Integer uid);
    List<Comment> findByPId(Integer pid);
}
