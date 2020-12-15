package com.zgh.entity;

public class User {
    private Integer eid;
    private String ename;
    private String epsw;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEpsw() {
        return epsw;
    }

    public void setEpsw(String epsw) {
        this.epsw = epsw;
    }

    @Override
    public String toString() {
        return "User{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", epsw='" + epsw + '\'' +
                '}';
    }
}
