package com.tjut.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkTimeTable {
    Guider g=new Guider();
    List<WorkTime> l=new ArrayList<>();

    public Guider getG() {
        return g;
    }

    public void setG(Guider g) {
        this.g = g;
    }

    public List<WorkTime> getL() {
        return l;
    }

    public void setL(List<WorkTime> l) {
        this.l = l;
    }

    @Override
    public String toString() {
        return "WorkTimeTable{" +
                "g=" + g +
                ", l=" + l +
                '}';
    }
}
