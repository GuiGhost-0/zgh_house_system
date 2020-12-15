package com.zgh.entity;

public class MyBs extends BaseDto{
    //  `BID` decimal(8, 0) NOT NULL,
    //  `HID` decimal(8, 0) NULL DEFAULT NULL,
    //  `MTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    //  `BREMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    //  `EID` decimal(8, 0) NULL DEFAULT NULL,
    private Integer bid;
    private Integer hid;
    private String mtime;
    private String bremark;
    private Integer eid;
    private String haddress;
    private String hfh;
    private String erealname;

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

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getBremark() {
        return bremark;
    }

    public void setBremark(String bremark) {
        this.bremark = bremark;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
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

    public String getErealname() {
        return erealname;
    }

    public void setErealname(String erealname) {
        this.erealname = erealname;
    }

    @Override
    public String toString() {
        return "MyBs{" +
                "bid=" + bid +
                ", hid=" + hid +
                ", mtime='" + mtime + '\'' +
                ", bremark='" + bremark + '\'' +
                ", eid=" + eid +
                ", haddress='" + haddress + '\'' +
                ", hfh='" + hfh + '\'' +
                ", erealname='" + erealname + '\'' +
                ", allPages=" + allPages +
                ", up=" + up +
                ", next=" + next +
                ", current=" + current +
                ", allCount=" + allCount +
                '}';
    }
}
