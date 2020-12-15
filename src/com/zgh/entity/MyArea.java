package com.zgh.entity;

public class MyArea extends BaseDto {
    /**
     * `AID` decimal(8, 0) NOT NULL,
     *   `ANAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     * */
    private Integer aid;
    private String aname;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "MyArea{" +
                "aid=" + aid +
                ", aname=" + aname +
                ", allPages=" + allPages +
                ", up=" + up +
                ", next=" + next +
                ", current=" + current +
                ", allCount=" + allCount +
                '}';
    }
}
