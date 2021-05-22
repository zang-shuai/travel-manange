package com.tjut.entity;

import java.io.Serializable;

public class BuyResult implements Serializable {
    /*
      购买结果
      1. 已经购买：购买失败
      2. 已经满员，购买失败
      3. 时间冲突，购买失败
      3. 购买成功
     */
    private Boolean rel;
    private String why;

    @Override
    public String toString() {
        return "BuyResult{" +
                "rel=" + rel +
                ", why='" + why + '\'' +
                '}';
    }

    public Boolean getRel() {
        return rel;
    }

    public void setRel(Boolean rel) {
        this.rel = rel;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }
}
