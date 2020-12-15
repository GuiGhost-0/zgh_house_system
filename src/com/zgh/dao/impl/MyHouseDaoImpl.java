package com.zgh.dao.impl;

import com.zgh.dao.SystemDao;
import com.zgh.utils.BaseUtils;

import java.util.Map;

public class MyHouseDaoImpl extends SystemDao {
    private String queryAllSqlCount = null;
    private String queryAllSql = null;

    private String addRecords = null;

    public String getQueryAllSqlCount() {
        return queryAllSqlCount = "SELECT COUNT(*)\n" +
                "FROM mysort a,myarea b,myhouse c\n" +
                "WHERE a.SID=c.SID AND b.AID = c.AID";
    }

    public String getQueryAllSql() {
        return queryAllSql = "SELECT a.SNAME,b.ANAME,c.* FROM mysort a,myarea b,myhouse c " +
                "WHERE a.SID=c.SID AND b.AID = c.AID";
    }

    public String getAddRecords() {
        return addRecords = "INSERT INTO `dxfwcz`.`myhouse`" +
                "(`HID`, `SID`, `AID`, `HADDRESS`, `HFH`, `HHX`, `HMJ`, " +
                "`HCX`, `HMONEY`, `HWF`, `HDX`, `HSF`, `HMQ`, `DKD`, " +
                "`SKD`, `MKD`, `HJP`, `HREMARK`, `HIMG`, `HFLAG`) " +
                "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                " 'upload/1.jpg、upload/2.jpg、upload/3.jpg', 0);";
    }

    public boolean add(Map map){
        Object[] objects = BaseUtils.mapToObject(map);
        return update(getAddRecords(),objects);
    }
}
