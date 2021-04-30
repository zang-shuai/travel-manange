package com.tjut.entity;

import java.io.Serializable;

public class Comment implements Serializable {
    private Integer CId;
    private Integer UId;
    private Integer PId;
    private String Content;

    @Override
    public String toString() {
        return "Comment{" +
                "CId=" + CId +
                ", UId=" + UId +
                ", PId=" + PId +
                ", Content='" + Content + '\'' +
                '}';
    }

    public Integer getCId() {
        return CId;
    }

    public void setCId(Integer CId) {
        this.CId = CId;
    }

    public Integer getUId() {
        return UId;
    }

    public void setUId(Integer UId) {
        this.UId = UId;
    }

    public Integer getPId() {
        return PId;
    }

    public void setPId(Integer PId) {
        this.PId = PId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
