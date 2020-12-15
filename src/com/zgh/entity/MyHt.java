package com.zgh.entity;

public class MyHt extends BaseDto{
    //HTID` decimal(8, 0) NOT NULL,
    //  `HTNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    //  `HTREMARK` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    private Integer htid;
    private String htname;
    private String htremark;

    public Integer getHtid() {
        return htid;
    }

    public void setHtid(Integer htid) {
        this.htid = htid;
    }

    public String getHtname() {
        return htname;
    }

    public void setHtname(String htname) {
        this.htname = htname;
    }

    public String getHtremark() {
        return htremark;
    }

    public void setHtremark(String htremark) {
        this.htremark = htremark;
    }

    @Override
    public String toString() {
        return "MyHt{" +
                "htid=" + htid +
                ", htname='" + htname + '\'' +
                ", htremark='" + htremark + '\'' +
                ", allPages=" + allPages +
                ", up=" + up +
                ", next=" + next +
                ", current=" + current +
                ", allCount=" + allCount +
                '}';
    }
}
