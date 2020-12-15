package com.zgh.entity;


/**
 * 部门信息实体类
 * */
public class Dept {
    private long pid;//部门编号
    private String pname;//部门名称
    private long pflag;//部门状态
    private String premark;//备注

    private Integer allPages;
    private Integer up;
    private Integer next;
    private Integer current;
    private Integer allCount;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public long getPflag() {
        return pflag;
    }

    public void setPflag(long pflag) {
        this.pflag = pflag;
    }

    public String getPremark() {
        return premark;
    }

    public void setPremark(String premark) {
        this.premark = premark;
    }

    public Integer getAllPages() {
        return allPages;
    }

    public void setAllPages(Integer allPages) {
        this.allPages = allPages;
    }

    public Integer getUp() {
        return up;
    }

    public void setUp(Integer up) {
        this.up = up;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getAllCount() {
        return allCount;
    }

    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pflag=" + pflag +
                ", premark='" + premark + '\'' +
                ", allPages=" + allPages +
                ", up=" + up +
                ", next=" + next +
                ", current=" + current +
                ", allCount=" + allCount +
                '}';
    }
}
