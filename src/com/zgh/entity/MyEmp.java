package com.zgh.entity;


/**
 * 员工实体类
 * */
public class MyEmp extends BaseDto{
    /**
     * EID` decimal(8, 0) NOT NULL,
     * PID` decimal(8, 0) NULL DEFAULT NULL,
     * JID` decimal(8, 0) NULL DEFAULT NULL,
     * ENAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     * EPSW` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     * EREALNAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     * ETEL` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     * EADDRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     * EFLAG` decimal(8, 0) NULL DEFAULT NULL,
     * EREMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     * */

    private Integer eid;//员工编号
    private Integer pid;//部门编号
    private String pname;//部门名称
    private Integer jid;//角色编号
    private String jname;//角色名称
    private String ename;//员工账号
    private String epsw;//员工密码
    private String erealname;//员工真实姓名
    private String etel;//员工电话
    private String eaddress;//员工住址
    private Integer eflag;//员工状态
    private String eremark;//描述

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEpsw() {
        return epsw;
    }

    public void setEpsw(String epsw) {
        this.epsw = epsw;
    }

    public String getErealname() {
        return erealname;
    }

    public void setErealname(String erealname) {
        this.erealname = erealname;
    }

    public String getEtel() {
        return etel;
    }

    public void setEtel(String etel) {
        this.etel = etel;
    }

    public String getEaddress() {
        return eaddress;
    }

    public void setEaddress(String eaddress) {
        this.eaddress = eaddress;
    }

    public Integer getEflag() {
        return eflag;
    }

    public void setEflag(Integer eflag) {
        this.eflag = eflag;
    }

    public String getEremark() {
        return eremark;
    }

    public void setEremark(String eremark) {
        this.eremark = eremark;
    }

    @Override
    public String toString() {
        return "MyEmp{" +
                "eid=" + eid +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                ", jid=" + jid +
                ", jname='" + jname + '\'' +
                ", ename='" + ename + '\'' +
                ", epsw='" + epsw + '\'' +
                ", erealname='" + erealname + '\'' +
                ", etel='" + etel + '\'' +
                ", eaddress='" + eaddress + '\'' +
                ", eflag=" + eflag +
                ", eremark='" + eremark + '\'' +
                ", allPages=" + allPages +
                ", up=" + up +
                ", next=" + next +
                ", current=" + current +
                ", allCount=" + allCount +
                '}';
    }
}
