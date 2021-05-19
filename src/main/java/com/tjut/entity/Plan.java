package com.tjut.entity;

import java.io.Serializable;
import java.util.Date;

public class Plan implements Serializable {
    private Integer PId;
    private Integer TId;
    private String TName;
    private Integer GId;
    private String GName;
    private Date PStartDate;
    private Date PEndDate;
    private Float PPrice;
    private Integer PMaxCount;
    private Integer PCount;

    @Override
    public String toString() {
        return "Plan{" +
                "PId=" + PId +
                ", TId=" + TId +
                ", TName='" + TName + '\'' +
                ", GId=" + GId +
                ", GName='" + GName + '\'' +
                ", PStartDate=" + PStartDate +
                ", PEndDate=" + PEndDate +
                ", PPrice=" + PPrice +
                ", PMaxCount=" + PMaxCount +
                ", PCount=" + PCount +
                '}';
    }

    public String getTName() {
        return TName;
    }

    public void setTName(String TName) {
        this.TName = TName;
    }

    public String getGName() {
        return GName;
    }

    public void setGName(String GName) {
        this.GName = GName;
    }

    public Integer getPId() {
        return PId;
    }

    public void setPId(Integer PId) {
        this.PId = PId;
    }

    public Integer getTId() {
        return TId;
    }

    public void setTId(Integer TId) {
        this.TId = TId;
    }

    public Integer getGId() {
        return GId;
    }

    public void setGId(Integer GId) {
        this.GId = GId;
    }

    public Date getPStartDate() {
        return PStartDate;
    }

    public void setPStartDate(Date PStartDate) {
        this.PStartDate = PStartDate;
    }

    public Date getPEndDate() {
        return PEndDate;
    }

    public void setPEndDate(Date PEndDate) {
        this.PEndDate = PEndDate;
    }

    public Float getPPrice() {
        return PPrice;
    }

    public void setPPrice(Float PPrice) {
        this.PPrice = PPrice;
    }

    public Integer getPMaxCount() {
        return PMaxCount;
    }

    public void setPMaxCount(Integer PMaxCount) {
        this.PMaxCount = PMaxCount;
    }

    public Integer getPCount() {
        return PCount;
    }

    public void setPCount(Integer PCount) {
        this.PCount = PCount;
    }
}
