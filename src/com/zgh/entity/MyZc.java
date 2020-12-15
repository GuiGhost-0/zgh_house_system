package com.zgh.entity;

public class MyZc extends BaseDto{
    //`CID` decimal(8, 0) NOT NULL,
    //  `CTITLE` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    //  `CTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    //  `CREMARK` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
    private Integer cid;
    private String ctitle;
    private String ctime;
    private String cremark;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getCremark() {
        return cremark;
    }

    public void setCremark(String cremark) {
        this.cremark = cremark;
    }

    @Override
    public String toString() {
        return "MyZc{" +
                "cid=" + cid +
                ", ctitle='" + ctitle + '\'' +
                ", ctime='" + ctime + '\'' +
                ", cremark='" + cremark + '\'' +
                ", allPages=" + allPages +
                ", up=" + up +
                ", next=" + next +
                ", current=" + current +
                ", allCount=" + allCount +
                '}';
    }
}
