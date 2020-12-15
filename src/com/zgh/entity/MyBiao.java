package com.zgh.entity;
/**
 * 操表实体类
 */

public class MyBiao extends BaseDto{
    //  `BID` decimal(8, 0) NOT NULL,
    //  `HID` decimal(8, 0) NULL DEFAULT NULL,
    //  `DKD` float NULL DEFAULT NULL,
    //  `SKD` float NULL DEFAULT NULL,
    //  `MKD` float NULL DEFAULT NULL,
    //  `MTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    //  `EID` decimal(8, 0) NULL DEFAULT NULL,
    private Integer bid;
    private Integer hid;
    private float dkd;
    private float skd;
    private float mkd;
    private String mtime;
    private Integer eid;
    private String erealname;
    private String haddress;
    private String hfh;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public float getDkd() {
        return dkd;
    }

    public void setDkd(float dkd) {
        this.dkd = dkd;
    }

    public float getSkd() {
        return skd;
    }

    public void setSkd(float skd) {
        this.skd = skd;
    }

    public float getMkd() {
        return mkd;
    }

    public void setMkd(float mkd) {
        this.mkd = mkd;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getErealname() {
        return erealname;
    }

    public void setErealname(String erealname) {
        this.erealname = erealname;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }

    public String getHfh() {
        return hfh;
    }

    public void setHfh(String hfh) {
        this.hfh = hfh;
    }

    @Override
    public String toString() {
        return "MyBiao{" +
                "bid=" + bid +
                ", hid=" + hid +
                ", dkd=" + dkd +
                ", skd=" + skd +
                ", mkd=" + mkd +
                ", mtime='" + mtime + '\'' +
                ", eid=" + eid +
                ", erealname='" + erealname + '\'' +
                ", haddress='" + haddress + '\'' +
                ", hfh='" + hfh + '\'' +
                ", allPages=" + allPages +
                ", up=" + up +
                ", next=" + next +
                ", current=" + current +
                ", allCount=" + allCount +
                '}';
    }
}
