package com.zgh.dao.impl;

import com.zgh.dao.SystemDao;
import com.zgh.utils.BaseUtils;

import java.util.Map;

public class MyDjDaoImpl extends SystemDao {
    private String addRecords = null;
    private String queryAllSql = null;
    private String queryAllSqlCount = null;
    private String queryDqSql = null;
    private String queryDqSqlCount = null;

    public String getQueryDqSqlCount() {
        return queryDqSqlCount = "SELECT COUNT(1)\n" +
                "FROM mydj a,myhouse b,myemp c,mycus d\n" +
                "where a.HID = b.HID AND a.EID = c.EID AND a.CID = d.CID AND a.MDATE <= NOW()";
    }

    public String getQueryDqSql() {
        return queryDqSql = "SELECT a.MID,b.HADDRESS,b.HFH,d.CNAME,d.CTEL,c.EREALNAME,a.MBEGINTIME,a.MYJ,a.MYZJ,a.MFLAG,a.MDATE\n" +
                "FROM mydj a,myhouse b,myemp c,mycus d\n" +
                "where a.HID = b.HID AND a.EID = c.EID AND a.CID = d.CID AND a.MDATE <= NOW()";
    }

    public String getAddRecords() {
        //var mypart = "cid=" + cid  + "&hid=" + hid  +
        // "&myj=" + myj + "&myzj=" + myzj +
        // "&time=" + time + "&doc=" + doc;
        return addRecords="INSERT INTO `dxfwcz`.`mydj`" +
                "(`MID`, `MDATE`, `EID`, `CID`, `HID`, `MIMG`, `MYJ`, `MYZJ`, `MFLAG`, `MBEGINTIME`) " +
                "VALUES (NULL, ?, ?, ?, ?, NULL, ?, ?, 1, NOW())";

        //INSERT INTO `dxfwcz`.`mydj`(`MID`, `MDATE`, `EID`, `CID`, `HID`, `MIMG`, `MYJ`, `MYZJ`, `MFLAG`, `MBEGINTIME`)
        // VALUES (1, '2020-11-11', 1, 1, 1, NULL, 2000, 3500, 0, NOW());
    }

    public String getQueryAllSql() {
        return queryAllSql="SELECT a.MID,b.HADDRESS,b.HFH,d.CNAME,d.CTEL,c.EREALNAME,a.MBEGINTIME,a.MYJ,a.MYZJ,b.HFLAG,a.MDATE\n" +
                "FROM mydj a,myhouse b,myemp c,mycus d\n" +
                "where a.HID = b.HID AND a.EID = c.EID AND a.CID = d.CID";
    }

    public String getQueryAllSqlCount() {
        return queryAllSqlCount="SELECT COUNT(1)\n" +
                "FROM mydj a,myhouse b,myemp c,mycus d\n" +
                "where a.HID = b.HID AND a.EID = c.EID AND a.CID = d.CID";
    }

    public boolean add(Map map){
        Object[] objects = BaseUtils.mapToObject(map);
        int mid = queryMaxMid()+1;
        update("UPDATE myhouse SET hflag=1 WHERE hid = " + objects[3]);
//        System.out.println("UPDATE myhouse SET hflag=1 WHERE hid = " + objects[3]);
        update("INSERT INTO `dxfwcz`.`mysf`(`YID`, `MID`, `EID`, `MYZJ`, `MBEGINTIME`) " +
                "VALUES (NULL, " + mid + ", " + objects[1] + ", " + objects[5] + ", now())");
//        System.out.println("INSERT INTO `dxfwcz`.`mysf`(`YID`, `MID`, `EID`, `MYZJ`, `MBEGINTIME`) " +
//                "VALUES (NULL, 7, " + objects[1] + ", " + objects[5] + ", now())");
        return update(getAddRecords(),objects);
    }
}
