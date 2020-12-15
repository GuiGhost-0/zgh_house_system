package com.zgh.entity;


/**
 * 登记收费实体类
 * */
public class MyDjsf extends BaseDto{
    //`YID` decimal(8, 0) NOT NULL,
    //  `MID` decimal(8, 0) NULL DEFAULT NULL,
    //  `EID` decimal(8, 0) NULL DEFAULT NULL,
    //  `MYZJ` float NULL DEFAULT NULL,
    //  `MBEGINTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,

    private Integer yid;
    private Integer mid;
    private Integer eid;
    private Float myzj;
    private String mbegintime;
    private String haddress;
    private String hfh;
    private String cname;
    private String ctel;
    private String mdate;

    public Integer getYid() {
        return yid;
    }

    public void setYid(Integer yid) {
        this.yid = yid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Float getMyzj() {
        return myzj;
    }

    public void setMyzj(Float myzj) {
        this.myzj = myzj;
    }

    public String getMbegintime() {
        return mbegintime;
    }

    public void setMbegintime(String mbegintime) {
        this.mbegintime = mbegintime;
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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCtel() {
        return ctel;
    }

    public void setCtel(String ctel) {
        this.ctel = ctel;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    @Override
    public String toString() {
        return "MyDjsf{" +
                "yid=" + yid +
                ", mid=" + mid +
                ", eid=" + eid +
                ", myzj=" + myzj +
                ", mbegintime='" + mbegintime + '\'' +
                ", haddress='" + haddress + '\'' +
                ", hfh='" + hfh + '\'' +
                ", cname='" + cname + '\'' +
                ", ctel='" + ctel + '\'' +
                ", mdate='" + mdate + '\'' +
                ", allPages=" + allPages +
                ", up=" + up +
                ", next=" + next +
                ", current=" + current +
                ", allCount=" + allCount +
                '}';
    }
}
