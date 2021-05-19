package com.tjut.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Purchase implements Serializable {
    Guider guider = new Guider();
    Tourist tourist = new Tourist();
    Plan plan=new Plan();

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    List<Comment> comments=new ArrayList<>();

    @Override
    public String toString() {
        return "Purchase{" +
                "guider=" + guider +
                ", tourist=" + tourist +
                ", plan=" + plan +
                ", comments=" + comments +
                '}';
    }

    public Guider getGuider() {
        return guider;
    }

    public void setGuider(Guider guider) {
        this.guider = guider;
    }

    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
