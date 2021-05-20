package com.tjut.entity;

import java.util.Date;

public class WorkTime {
    private Date pstartdate;
    private Date penddate;

    @Override
    public String toString() {
        return "WorkTime{" +
                "pstartdate=" + pstartdate +
                ", penddate=" + penddate +
                '}';
    }

    public Date getPstartdate() {
        return pstartdate;
    }

    public void setPstartdate(Date pstartdate) {
        this.pstartdate = pstartdate;
    }

    public Date getPenddate() {
        return penddate;
    }

    public void setPenddate(Date penddate) {
        this.penddate = penddate;
    }
}
