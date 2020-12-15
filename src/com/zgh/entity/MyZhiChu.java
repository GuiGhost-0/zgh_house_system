package com.zgh.entity;

/**
 * 支出表的实体类
 * */
public class MyZhiChu extends BaseDto{
    //  `ZID` decimal(8, 0) NOT NULL,
    //  `EID` decimal(8, 0) NULL DEFAULT NULL,
    //  `ZMONEY` float NULL DEFAULT NULL,
    //  `ZTM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    //  `ZTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    //  `ZREMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,

    private Integer zid;
    private Integer eid;
    private Float zmoney;
    private String ztm;
    private String ztime;
    private String zremark;
    private String erealname;

    public Integer getZid() {
        return zid;
    }

    public void setZid(Integer zid) {
        this.zid = zid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Float getZmoney() {
        return zmoney;
    }

    public void setZmoney(Float zmoney) {
        this.zmoney = zmoney;
    }

    public String getZtm() {
        return ztm;
    }

    public void setZtm(String ztm) {
        this.ztm = ztm;
    }

    public String getZtime() {
        return ztime;
    }

    public void setZtime(String ztime) {
        this.ztime = ztime;
    }

    public String getZremark() {
        return zremark;
    }

    public void setZremark(String zremark) {
        this.zremark = zremark;
    }

    public String getErealname() {
        return erealname;
    }

    public void setErealname(String erealname) {
        this.erealname = erealname;
    }

    @Override
    public String toString() {
        return "MyZhiChu{" +
                "zid=" + zid +
                ", eid=" + eid +
                ", zmoney=" + zmoney +
                ", ztm='" + ztm + '\'' +
                ", ztime='" + ztime + '\'' +
                ", zremark='" + zremark + '\'' +
                ", erealname='" + erealname + '\'' +
                ", allPages=" + allPages +
                ", up=" + up +
                ", next=" + next +
                ", current=" + current +
                ", allCount=" + allCount +
                '}';
    }
}
