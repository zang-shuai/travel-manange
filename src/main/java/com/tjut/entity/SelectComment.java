package com.tjut.entity;

import java.io.Serializable;
import java.util.Date;

public class SelectComment implements Serializable {
    private String uhead;
    private String uname;
    private String content;
    private Integer pid;
    private Integer ctype;
//    private Date date;

    @Override
    public String toString() {
        return "SelectComment{" +
                "uhead='" + uhead + '\'' +
                ", uname='" + uname + '\'' +
                ", content='" + content + '\'' +
                ", pid=" + pid +
                ", ctype=" + ctype +
                '}';
    }

    public String getUhead() {
        return uhead;
    }

    public void setUhead(String uhead) {
        this.uhead = uhead;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCtype() {
        return ctype;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }
}
