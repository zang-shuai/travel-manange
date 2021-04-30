package com.tjut.entity;

import java.io.Serializable;

public class TouristImg implements Serializable {
    private Integer IId;
    private Integer TId;
    private String TAddress;

    @Override
    public String toString() {
        return "TouristImg{" +
                "IId=" + IId +
                ", TId=" + TId +
                ", TAddress=" + TAddress +
                '}';
    }

    public Integer getIId() {
        return IId;
    }

    public void setIId(Integer IId) {
        this.IId = IId;
    }

    public Integer getTId() {
        return TId;
    }

    public void setTId(Integer TId) {
        this.TId = TId;
    }

    public String getTAddress() {
        return TAddress;
    }

    public void setTAddress(String TAddress) {
        this.TAddress = TAddress;
    }
}
