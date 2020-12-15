package com.zgh.entity;

/**
 *mytf实体类
 */


public class MyTf extends BaseDto {

    //`TID` decimal(8, 0) NOT NULL,
    //  `MID` decimal(8, 0) NULL DEFAULT NULL,
    //  `EID` decimal(8, 0) NULL DEFAULT NULL,
    //  `TYZJ` float NULL DEFAULT NULL,
    //  `MTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    //  `MREMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    private Integer tid;
    private Integer mid;
    private Integer eid;
    private float tyzj;
    private String mtime;
    private String mremark;
    private String mbegintime;
    private String haddress;
    private String hfh;
    private String cname;
    private String ctel;
    private String mdate;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
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

    public float getTyzj() {
        return tyzj;
    }

    public void setTyzj(float tyzj) {
        this.tyzj = tyzj;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getMremark() {
        return mremark;
    }

    public void setMremark(String mremark) {
        this.mremark = mremark;
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
        return "MyTf{" +
                "tid=" + tid +
                ", mid=" + mid +
                ", eid=" + eid +
                ", tyzj=" + tyzj +
                ", mtime='" + mtime + '\'' +
                ", mremark='" + mremark + '\'' +
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
