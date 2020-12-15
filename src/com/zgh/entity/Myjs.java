package com.zgh.entity;

public class Myjs extends BaseDto{
    private Integer jid;
    private String jname;

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    @Override
    public String toString() {
        return "Myjs{" +
                "jid=" + jid +
                ", jname='" + jname + '\'' +
                ", allPages=" + allPages +
                ", up=" + up +
                ", next=" + next +
                ", current=" + current +
                ", allCount=" + allCount +
                '}';
    }
}
