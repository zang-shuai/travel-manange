package com.tjut.dao.impl;

import com.tjut.dao.PlanDao;
import com.tjut.entity.Plan;
import com.tjut.entity.Tourist;
import com.tjut.entity.TouristImg;
import com.tjut.entity.User;
import com.tjut.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PlanDaoImpl implements PlanDao {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Plan> findAll() {
        String sql = "select * from plan";
        return template.query(sql, new BeanPropertyRowMapper<>(Plan.class));
    }

    @Override
    public void add(Plan plan) {
        String sql = "insert into plan values (null,?,?,?,?,?,?,?)";
        template.update(sql, plan.getTId(), plan.getPStartDate(), plan.getPEndDate(), plan.getGId(), plan.getPPrice(), plan.getPMaxCount(), plan.getPCount());
    }

    @Override
    public void delete(Integer pid) {
        String sql = "delete from plan where pid=?";
        template.update(sql, pid);

    }

    @Override
    public Plan findByPId(Integer pid) {
        String sql = "select * from plan where pid=?";
        Plan p = template.queryForObject(sql, new BeanPropertyRowMapper<>(Plan.class), pid);
        return p;
    }

    @Override
    public List<Plan> findByGId(Integer gid) {
        String sql = "select * from plan where gid=?";
        return template.query(sql, new BeanPropertyRowMapper<>(Plan.class), gid);
    }

    @Override
    public List<Plan> findByTId(Integer tid) {
        String sql = "select * from plan where tid=?";
        return template.query(sql, new BeanPropertyRowMapper<>(Plan.class), tid);
    }

    @Override
    public void update(Plan plan) {
        String sql = "update plan set tid = ?,pstartdate = ? ,penddate = ? , gid = ? ,pprice = ?,pmaxcount=?,pcount=? where pid = ?";
        template.update(sql,plan.getTId(),plan.getPStartDate(),plan.getPEndDate(),plan.getPId(),plan.getPPrice(),plan.getPMaxCount(),plan.getPCount(),plan.getPId());
    }
    @Override
    public Integer plusOne(Integer pid) {

        String sql = "update plan set  pcount=pcount+1  where pid = 1 and pmaxcount<pcount";
        return template.update(sql, pid);
    }
}
