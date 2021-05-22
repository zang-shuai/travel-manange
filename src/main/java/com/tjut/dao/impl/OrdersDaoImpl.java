package com.tjut.dao.impl;

import com.tjut.dao.OrdersDao;
import com.tjut.entity.Orders;
import com.tjut.entity.WorkTime;
import com.tjut.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrdersDaoImpl implements OrdersDao {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void add(Orders orders) {
        String sql = "insert into orders values (null,?,?,?,?)";
        template.update(sql, orders.getPId(), orders.getUId(), orders.getSId(), orders.getOBuyDate());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from orders where oid=?";
        template.update(sql, id);

    }

    @Override
    public List<Orders> findByUId(Integer uid) {
        String sql = "select * from orders where uid=?";
        return template.query(sql, new BeanPropertyRowMapper<>(Orders.class), uid);
    }

    @Override
    public List<Orders> findByPId(Integer pid) {
        String sql = "select * from orders where pid=?";
        return template.query(sql, new BeanPropertyRowMapper<>(Orders.class), pid);
    }

    @Override
    public Orders findByOId(Integer oid) {
        String sql = "select *from orders where oid=?";
        Orders orders;
        try {
            orders = template.queryForObject(sql, new BeanPropertyRowMapper<>(Orders.class), oid);
        } catch (Exception e) {
            return null;
        }
        return orders;
    }

    @Override
    public List<WorkTime> findUsersTime(Integer uid) {
        String sql = "select pstartdate,penddate from plan,orders where plan.pid=orders.pid and orders.uid=?  order by pstartdate";
        return template.query(sql, new BeanPropertyRowMapper<>(WorkTime.class), uid);
    }
}
