package com.zgh.entity;
/**
 *  收入表的实体类
 * */
public class MyShouRu extends BaseDto{
    //`SID` decimal(8, 0) NOT NULL,
    //  `EID` decimal(8, 0) NULL DEFAULT NULL,
    //  `SMONEY` float NULL DEFAULT NULL,
    //  `STM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    //  `STIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    //  `SREMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,

    private Integer sid;//收入编号
    private Integer eid;//经办人编号
    private Float smoney;//收入金额
    private String stm;//收入条目
    private String stime;//收入时间
    private String sremark;//收入说明
    private String erealname;//经办人姓名

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Float getSmoney() {
        return smoney;
    }

    public void setSmoney(Float smoney) {
        this.smoney = smoney;
    }

    public String getStm() {
        return stm;
    }

    public void setStm(String stm) {
        this.stm = stm;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getSremark() {
        return sremark;
    }

    public void setSremark(String sremark) {
        this.sremark = sremark;
    }

    public String getErealname() {
        return erealname;
    }

    public void setErealname(String erealname) {
        this.erealname = erealname;
    }

    @Override
    public String toString() {
        return "MyShouRu{" +
                "sid=" + sid +
                ", eid=" + eid +
                ", smoney=" + smoney +
                ", stm='" + stm + '\'' +
                ", stime='" + stime + '\'' +
                ", sremark='" + sremark + '\'' +
                ", erealname='" + erealname + '\'' +
                ", allPages=" + allPages +
                ", up=" + up +
                ", next=" + next +
                ", current=" + current +
                ", allCount=" + allCount +
                '}';
    }
}
