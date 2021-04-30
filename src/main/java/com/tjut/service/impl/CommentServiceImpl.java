package com.tjut.service.impl;

import com.tjut.dao.CommentDao;
import com.tjut.dao.impl.CommentDaoImpl;
import com.tjut.entity.Comment;
import com.tjut.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private CommentDao commentDao = new CommentDaoImpl();

    @Override
    public void add(Comment comment) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Comment findById(Integer cid) {
        return null;
    }

    @Override
    public List<Comment> findByUId(Integer uid) {
        return null;
    }

    @Override
    public List<Comment> findByPId(Integer pid) {
        return null;
    }
}
