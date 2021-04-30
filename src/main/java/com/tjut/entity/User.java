package com.tjut.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer UId;
    private Integer UAge;
    private String UName;
    private String UTelephonenumber;
    private String UPassword;
    private String UHead;
    private Integer UPower;

    @Override
    public String toString() {
        return "User{" +
                "UId=" + UId +
                ", UAge=" + UAge +
                ", UName='" + UName + '\'' +
                ", UTelephonenumber='" + UTelephonenumber + '\'' +
                ", UPassword='" + UPassword + '\'' +
                ", UHead='" + UHead + '\'' +
                ", UPower=" + UPower +
                '}';
    }

    public Integer getUId() {
        return UId;
    }

    public void setUId(Integer UId) {
        this.UId = UId;
    }

    public Integer getUAge() {
        return UAge;
    }

    public void setUAge(Integer UAge) {
        this.UAge = UAge;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public String getUTelephonenumber() {
        return UTelephonenumber;
    }

    public void setUTelephonenumber(String UTelephonenumber) {
        this.UTelephonenumber = UTelephonenumber;
    }

    public String getUPassword() {
        return UPassword;
    }

    public void setUPassword(String UPassword) {
        this.UPassword = UPassword;
    }

    public String getUHead() {
        return UHead;
    }

    public void setUHead(String UHead) {
        this.UHead = UHead;
    }

    public Integer getUPower() {
        return UPower;
    }

    public void setUPower(Integer UPower) {
        this.UPower = UPower;
    }
}
