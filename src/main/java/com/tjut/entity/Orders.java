package com.tjut.entity;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {
    private Integer OId;
    private Integer PId;
    private Integer UId;
    private Integer SId;
    private Date OBuyDate;

    @Override
    public String toString() {
        return "Orders{" +
                "OId=" + OId +
                ", PId=" + PId +
                ", UId=" + UId +
                ", SId=" + SId +
                ", OBuyDate=" + OBuyDate +
                '}';
    }

    public Integer getSId() {
        return SId;
    }

    public void setSId(Integer SId) {
        this.SId = SId;
    }

    public Integer getOId() {
        return OId;
    }

    public void setOId(Integer OId) {
        this.OId = OId;
    }

    public Integer getPId() {
        return PId;
    }

    public void setPId(Integer PId) {
        this.PId = PId;
    }

    public Integer getUId() {
        return UId;
    }

    public void setUId(Integer UId) {
        this.UId = UId;
    }

    public Date getOBuyDate() {
        return OBuyDate;
    }

    public void setOBuyDate(Date OBuyDate) {
        this.OBuyDate = OBuyDate;
    }
}
