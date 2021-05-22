package com.tjut.dao.impl;

import com.tjut.dao.CommentDao;
import com.tjut.entity.*;
import com.tjut.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CommentDaoImpl implements CommentDao {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void add(Comment comment) {
        String sql = "insert into comment values (null,?,?,?,?)";
        template.update(sql, comment.getUId(), comment.getPId(), comment.getContent(), comment.getCType());

    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from comment where cId=?";
        template.update(sql, id);
    }

    @Override
    public Comment findById(Integer cid) {
        String sql = "select * from comment where cid=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(Comment.class), cid);
    }

    @Override
    public List<Comment> findByUId(Integer uid) {
        String sql = "select * from comment where uid=?";
        return template.query(sql, new BeanPropertyRowMapper<>(Comment.class), uid);
    }

    @Override
    public List<Comment> findByPId(Integer pid) {
        String sql = "select * from comment where pid=?";
        return template.query(sql, new BeanPropertyRowMapper<>(Comment.class), pid);
    }

    @Override
    public List<SelectComment> findComments(Integer pid) {
        String sql = "select distinct uhead, uname, comment.pid, content, comment.ctype from user,     plan,     comment where user.uid = comment.uid and ((comment.pid in (select plan.pid  from plan where plan.tid = (select tid from plan where plan.pid = ?)) and ctype = 2) or (comment.pid in (select plan.pid from plan where plan.gid = (select gid from plan where plan.pid = ?))    and ctype = 1))";
        return template.query(sql, new BeanPropertyRowMapper<>(SelectComment.class), pid, pid);
    }

}
