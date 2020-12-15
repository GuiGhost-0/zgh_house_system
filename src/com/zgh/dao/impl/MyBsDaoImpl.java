package com.zgh.dao.impl;

import com.zgh.dao.SystemDao;
import com.zgh.utils.BaseUtils;

import java.util.Map;

public class MyBsDaoImpl extends SystemDao {
    private String queryALlSql = null;
    private String queryALlSqlCount = null;
    private String addRecords = null;

    public String getQueryALlSql() {
        return queryALlSql = "SELECT bs.BID,house.HADDRESS,house.HFH,bs.BREMARK,bs.MTIME,emp.EREALNAME\n" +
                "FROM mybs bs,myhouse house,myemp emp\n" +
                "WHERE bs.HID = house.HID AND bs.EID = emp.EID";
    }

    public String getQueryALlSqlCount() {
        return queryALlSqlCount = "SELECT COUNT(*) FROM mybs";
    }

    public String getAddRecords() {
        return addRecords = "INSERT INTO `dxfwcz`.`mybs`" +
                "(`BID`, `HID`, `MTIME`, `BREMARK`, `EID`) " +
                "VALUES (NULL, ?, NOW(), ?, ?)";
    }

    public boolean add(Map map){
        Object[] objects = BaseUtils.mapToObject(map);
        return update(getAddRecords(),objects);
    }
}
