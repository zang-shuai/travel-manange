package com.tjut.entity;

import java.io.Serializable;
import java.util.List;

public class Tourist implements Serializable {
    private Integer TId;
    private String TIdSecond;
    private String TName;
    private String TIntroduce;
    private Float TPrice;
    List<TouristImg> TouristImg;

    public String getTIdSecond() {
        return TIdSecond;
    }

    public void setTIdSecond(String TIdSecond) {
        this.TIdSecond = TIdSecond;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "TId=" + TId +
                ", TIdSecond='" + TIdSecond + '\'' +
                ", TName='" + TName + '\'' +
                ", TIntroduce='" + TIntroduce + '\'' +
                ", TPrice=" + TPrice +
                ", TouristImg=" + TouristImg +
                '}';
    }

    public Integer getTId() {
        return TId;
    }

    public void setTId(Integer TId) {
        this.TId = TId;
    }

    public String getTName() {
        return TName;
    }

    public void setTName(String TName) {
        this.TName = TName;
    }

    public String getTIntroduce() {
        return TIntroduce;
    }

    public void setTIntroduce(String TIntroduce) {
        this.TIntroduce = TIntroduce;
    }

    public Float getTPrice() {
        return TPrice;
    }

    public void setTPrice(Float TPrice) {
        this.TPrice = TPrice;
    }

    public List<com.tjut.entity.TouristImg> getTouristImg() {
        return TouristImg;
    }

    public void setTouristImg(List<com.tjut.entity.TouristImg> touristImg) {
        TouristImg = touristImg;
    }
}
