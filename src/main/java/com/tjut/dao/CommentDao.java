package com.tjut.dao;


import com.tjut.entity.Comment;
import com.tjut.entity.Guider;
import com.tjut.entity.SelectComment;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface CommentDao {
    void add(Comment comment);

    void delete(Integer id);

    Comment findById(Integer cid);
    List<Comment> findByUId(Integer uid);
    List<Comment> findByPId(Integer pid);
    List<SelectComment> findComments(Integer pid);
}
