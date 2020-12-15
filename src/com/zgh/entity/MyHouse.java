package com.zgh.entity;

public class MyHouse extends BaseDto{
    /**
     * `HID` decimal(8, 0) NOT NULL,
     *   `SID` decimal(8, 0) NULL DEFAULT NULL,
     *   `AID` decimal(8, 0) NULL DEFAULT NULL,
     *   `HADDRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     *   `HFH` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     *   `HHX` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     *   `HMJ` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     *   `HMONEY` float NULL DEFAULT NULL,
     *   `HWF` float NULL DEFAULT NULL,
     *   `HDX` float NULL DEFAULT NULL,
     *   `HSF` float NULL DEFAULT NULL,
     *   `HMQ` float NULL DEFAULT NULL,
     *   `DKD` float NULL DEFAULT NULL,
     *   `SKD` float NULL DEFAULT NULL,
     *   `MKD` float NULL DEFAULT NULL,
     *   `HJP` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     *   `HREMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     *   `HIMG` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     *   `HFLAG` decimal(8, 0) NULL DEFAULT NULL,
     * */

    private Integer hid;//房屋编号
    private Integer sid;//房屋类型编号
    private String sname;//房屋类型
    private Integer aid;//片区编号
    private String aname;//片区名称
    private String haddress;//房屋地址
    private String hfh;//房号
    private String hhx;//户型
    private String hmj;//房屋面积
    private String hcx;//房屋朝向
    private Float hmoney;
    private Float hwf;
    private Float hdx;
    private Float hsf;
    private Float hmq;
    private Float dkd;
    private Float skd;
    private Float mkd;
    private String hjp;
    private String hremark;
    private String himg;
    private Integer hflag;


    public String getHcx() {
        return hcx;
    }

    public void setHcx(String hcx) {
        this.hcx = hcx;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

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

    public String getHhx() {
        return hhx;
    }

    public void setHhx(String hhx) {
        this.hhx = hhx;
    }

    public String getHmj() {
        return hmj;
    }

    public void setHmj(String hmj) {
        this.hmj = hmj;
    }

    public Float getHmoney() {
        return hmoney;
    }

    public void setHmoney(Float hmoney) {
        this.hmoney = hmoney;
    }

    public Float getHwf() {
        return hwf;
    }

    public void setHwf(Float hwf) {
        this.hwf = hwf;
    }

    public Float getHdx() {
        return hdx;
    }

    public void setHdx(Float hdx) {
        this.hdx = hdx;
    }

    public Float getHsf() {
        return hsf;
    }

    public void setHsf(Float hsf) {
        this.hsf = hsf;
    }

    public Float getHmq() {
        return hmq;
    }

    public void setHmq(Float hmq) {
        this.hmq = hmq;
    }

    public Float getDkd() {
        return dkd;
    }

    public void setDkd(Float dkd) {
        this.dkd = dkd;
    }

    public Float getSkd() {
        return skd;
    }

    public void setSkd(Float skd) {
        this.skd = skd;
    }

    public Float getMkd() {
        return mkd;
    }

    public void setMkd(Float mkd) {
        this.mkd = mkd;
    }

    public String getHjp() {
        return hjp;
    }

    public void setHjp(String hjp) {
        this.hjp = hjp;
    }

    public String getHremark() {
        return hremark;
    }

    public void setHremark(String hremark) {
        this.hremark = hremark;
    }

    public String getHimg() {
        return himg;
    }

    public void setHimg(String himg) {
        this.himg = himg;
    }

    public Integer getHflag() {
        return hflag;
    }

    public void setHflag(Integer hflag) {
        this.hflag = hflag;
    }

    @Override
    public String toString() {
        return "MyHouse{" +
                "hid=" + hid +
                ", sid=" + sid +
                ", sname='" + sname + '\'' +
                ", aid=" + aid +
                ", aname='" + aname + '\'' +
                ", haddress='" + haddress + '\'' +
                ", hfh='" + hfh + '\'' +
                ", hhx='" + hhx + '\'' +
                ", hmj='" + hmj + '\'' +
                ", hcx='" + hcx + '\'' +
                ", hmoney=" + hmoney +
                ", hwf=" + hwf +
                ", hdx=" + hdx +
                ", hsf=" + hsf +
                ", hmq=" + hmq +
                ", dkd=" + dkd +
                ", skd=" + skd +
                ", mkd=" + mkd +
                ", hjp='" + hjp + '\'' +
                ", hremark='" + hremark + '\'' +
                ", himg='" + himg + '\'' +
                ", hflag=" + hflag +
                ", allPages=" + allPages +
                ", up=" + up +
                ", next=" + next +
                ", current=" + current +
                ", allCount=" + allCount +
                '}';
    }
}
