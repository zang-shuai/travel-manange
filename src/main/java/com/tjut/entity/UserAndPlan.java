package com.tjut.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserAndPlan implements Serializable {
    User user = new User();

    List<Orders> orders=new ArrayList<>();

    @Override
    public String toString() {
        return "UserAndPlan{" +
                "user=" + user +
                ", orders=" + orders +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
