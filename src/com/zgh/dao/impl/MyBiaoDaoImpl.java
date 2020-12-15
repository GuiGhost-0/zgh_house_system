package com.zgh.dao.impl;

import com.zgh.dao.SystemDao;
import com.zgh.utils.BaseUtils;

import java.util.Map;

public class MyBiaoDaoImpl extends SystemDao {
    private String queryAllSql = null;
    private String queryAllSqlCount = null;
    private String addRecords = null;

    public String getQueryAllSql() {
        return queryAllSql = "SELECT biao.BID,house.HADDRESS,house.HFH,biao.DKD,biao.SKD,biao.MKD,biao.MTIME,emp.EREALNAME\n" +
                "FROM mybiao biao,myhouse house,myemp emp\n" +
                "WHERE biao.HID = house.HID AND biao.EID = emp.EID";
    }

    public String getQueryAllSqlCount() {
        return queryAllSqlCount = "SELECT COUNT(*) FROM mybiao";
    }

    public String getAddRecords() {
        return addRecords = "INSERT INTO `dxfwcz`.`mybiao`" +
                "(`BID`, `HID`, `DKD`, `SKD`, `MKD`, `MTIME`, `EID`) " +
                "VALUES (NULL, ?, ?, ?, ?, NOW(), ?)";
    }

    public boolean add(Map map){
        Object[] objects = BaseUtils.mapToObject(map);
        return update(getAddRecords(),objects);
    }
}
