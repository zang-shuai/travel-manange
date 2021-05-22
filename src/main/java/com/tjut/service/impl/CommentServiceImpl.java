package com.tjut.service.impl;

import com.tjut.dao.CommentDao;
import com.tjut.dao.impl.CommentDaoImpl;
import com.tjut.entity.Comment;
import com.tjut.entity.SelectComment;
import com.tjut.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private final CommentDao commentDao = new CommentDaoImpl();

    @Override
    public void add(Comment comment) {
        commentDao.add(comment);
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
        return commentDao.findByPId(pid);
    }

    @Override
    public List<SelectComment> findComments(Integer pid) {
        return commentDao.findComments(pid);
    }
}
