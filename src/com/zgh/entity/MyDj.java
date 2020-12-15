package com.zgh.entity;

public class MyDj extends BaseDto{
    /**
     * `MID` decimal(8, 0) NOT NULL,
     *   `MDATE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     *   `EID` decimal(8, 0) NULL DEFAULT NULL,
     *   `CID` decimal(8, 0) NULL DEFAULT NULL,
     *   `HID` decimal(8, 0) NULL DEFAULT NULL,
     *   `MIMG` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     *   `MYJ` float NULL DEFAULT NULL,
     *   `MYZJ` float NULL DEFAULT NULL,
     *   `MFLAG` decimal(8, 0) NULL DEFAULT 0,
     *   `MBEGINTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     * */
    private Integer mid;
    private String mdate;
    private Integer eid;
    private String erealname;
    private Integer cid;
    private String cname;
    private String ctel;
    private Integer hid;
    private String hname;
    private String haddress;
    private String hfh;
    private String mimg;
    private float myj;
    private float myzj;
    private Integer hflag;
    private String mbegintime;

    public String getCtel() {
        return ctel;
    }

    public void setCtel(String ctel) {
        this.ctel = ctel;
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

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getMimg() {
        return mimg;
    }

    public void setMimg(String mimg) {
        this.mimg = mimg;
    }

    public float getMyj() {
        return myj;
    }

    public void setMyj(float myj) {
        this.myj = myj;
    }

    public float getMyzj() {
        return myzj;
    }

    public void setMyzj(float myzj) {
        this.myzj = myzj;
    }


    public Integer getHflag() {
        return hflag;
    }

    public void setHflag(Integer hflag) {
        this.hflag = hflag;
    }

    public String getMbegintime() {
        return mbegintime;
    }

    public void setMbegintime(String mbegintime) {
        this.mbegintime = mbegintime;
    }

    @Override
    public String toString() {
        return "MyDj{" +
                "mid=" + mid +
                ", mdate='" + mdate + '\'' +
                ", eid=" + eid +
                ", erealname='" + erealname + '\'' +
                ", cid=" + cid +
                ", cname='" + cname + '\'' +
                ", ctel='" + ctel + '\'' +
                ", hid=" + hid +
                ", hname='" + hname + '\'' +
                ", haddress='" + haddress + '\'' +
                ", hfh='" + hfh + '\'' +
                ", mimg='" + mimg + '\'' +
                ", myj=" + myj +
                ", myzj=" + myzj +
                ", hflag=" + hflag +
                ", mbegintime='" + mbegintime + '\'' +
                ", allPages=" + allPages +
                ", up=" + up +
                ", next=" + next +
                ", current=" + current +
                ", allCount=" + allCount +
                '}';
    }
}
