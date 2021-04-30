package com.tjut.entity;

public class Vehicle {
    private Integer VId;
    private String VType;
    private Integer VCapacity;
    private Integer PId;

    @Override
    public String toString() {
        return "Vehicle{" +
                "VId=" + VId +
                ", VType='" + VType + '\'' +
                ", VCapacity=" + VCapacity +
                ", PId=" + PId +
                '}';
    }

    public Integer getVId() {
        return VId;
    }

    public void setVId(Integer VId) {
        this.VId = VId;
    }

    public String getVType() {
        return VType;
    }

    public void setVType(String VType) {
        this.VType = VType;
    }

    public Integer getVCapacity() {
        return VCapacity;
    }

    public void setVCapacity(Integer VCapacity) {
        this.VCapacity = VCapacity;
    }

    public Integer getPId() {
        return PId;
    }

    public void setPId(Integer PId) {
        this.PId = PId;
    }
}
