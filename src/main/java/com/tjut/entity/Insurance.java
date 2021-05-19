package com.tjut.entity;

import java.io.Serializable;
import java.util.Date;

public class Insurance implements Serializable {
    private Integer SId;
    private String SName;
    private Float SPrice;

    @Override
    public String toString() {
        return "Insurance{" +
                "SId=" + SId +
                ", SName='" + SName + '\'' +
                ", SPrice=" + SPrice +
                '}';
    }

    public Integer getSId() {
        return SId;
    }

    public void setSId(Integer SId) {
        this.SId = SId;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public Float getSPrice() {
        return SPrice;
    }

    public void setSPrice(Float SPrice) {
        this.SPrice = SPrice;
    }
}
