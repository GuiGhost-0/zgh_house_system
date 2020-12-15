package com.zgh.entity;

public class MySort extends BaseDto{
    /**
     * `SID` decimal(8, 0) NOT NULL,
     *   `SNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     * */

    private Integer sid;//房屋类型编号
    private String sname;//房屋类型名称

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "MySort{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", allPages=" + allPages +
                ", up=" + up +
                ", next=" + next +
                ", current=" + current +
                ", allCount=" + allCount +
                '}';
    }
}
