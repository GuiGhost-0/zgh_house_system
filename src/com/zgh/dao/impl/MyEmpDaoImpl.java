package com.zgh.dao.impl;

import com.zgh.dao.SystemDao;
import com.zgh.utils.BaseUtils;

import java.util.Map;

public class MyEmpDaoImpl extends SystemDao {
    private String queryAllSql = null;
    private String queryAllSqlCount = null;
    private String addRecords = null;

    public String getQueryAllSql() {
        return queryAllSql="SELECT a.*,b.PNAME,c.JNAME FROM myemp a,mydept b,myjs c where a.PID = b.PID and a.JID = c.JID";
    }

    public String getQueryAllSqlCount() {
        return queryAllSqlCount="select count(*) from myemp";
    }

    public String getAddRecords() {
        return addRecords="INSERT INTO `dxfwcz`.`myemp`" +
                "(`EID`, `PID`, `JID`, `ENAME`, `EPSW`, `EREALNAME`, `ETEL`, `EADDRESS`, `EFLAG`, `EREMARK`) " +
                "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, 0, ?);";
    }

    public boolean add(Map map){
        Object[] objects = BaseUtils.mapToObject(map);
        return update(getAddRecords(),objects);
    }
}
