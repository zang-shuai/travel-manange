package com.tjut.entity;

import java.io.Serializable;

public class Guider implements Serializable {
    private Integer GId;
    private String GName;
    private Integer GAge;
    private String GTelephonenumber;
    private String GPassword;
    private String GHead;
    private String GIntroduce;

    public Integer getGId() {
        return GId;
    }

    public void setGId(Integer Gid) {
        GId = Gid;
    }

    public String getGName() {
        return GName;
    }

    public void setGName(String GName) {
        this.GName = GName;
    }

    public Integer getGAge() {
        return GAge;
    }

    public void setGAge(Integer GAge) {
        this.GAge = GAge;
    }

    public String getGTelephonenumber() {
        return GTelephonenumber;
    }

    public void setGTelephonenumber(String GTelephonenumber) {
        this.GTelephonenumber = GTelephonenumber;
    }

    public String getGPassword() {
        return GPassword;
    }

    public void setGPassword(String GPassword) {
        this.GPassword = GPassword;
    }

    public String getGHead() {
        return GHead;
    }

    public void setGHead(String GHead) {
        this.GHead = GHead;
    }

    public String getGIntroduce() {
        return GIntroduce;
    }

    public void setGIntroduce(String GIntroduce) {
        this.GIntroduce = GIntroduce;
    }

    @Override
    public String toString() {
        return "Guider{" +
                "GId=" + GId +
                ", GName='" + GName + '\'' +
                ", GAge=" + GAge +
                ", GTelephonenumber='" + GTelephonenumber + '\'' +
                ", GPassword='" + GPassword + '\'' +
                ", GHead='" + GHead + '\'' +
                ", GIntroduce='" + GIntroduce + '\'' +
                '}';
    }
}
