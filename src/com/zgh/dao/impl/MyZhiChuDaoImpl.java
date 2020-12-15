package com.zgh.dao.impl;

import com.zgh.dao.SystemDao;
import com.zgh.utils.BaseUtils;

import java.util.Map;

/**
 *  支出表的dao类
 * */
public class MyZhiChuDaoImpl extends SystemDao {
    private String queryAllSql = null;
    private String queryAllRecordsCount = null;
    private String addRecords = null;


    public String getQueryAllSql() {
        return queryAllSql = "SELECT zc.ZID,zc.ZMONEY,zc.ZTM,zc.ZREMARK,zc.ZTIME,emp.EREALNAME\n" +
                "FROM myzhichu zc,myemp emp\n" +
                "WHERE zc.EID = emp.EID";
    }

    public String getQueryAllRecordsCount() {
        return queryAllRecordsCount = "SELECT COUNT(*) FROM myzhichu";
    }

    public String getAddRecords() {
        return addRecords = "INSERT INTO `dxfwcz`.`myzhichu`" +
                "(`ZID`, `EID`, `ZMONEY`, `ZTM`, `ZTIME`, `ZREMARK`) " +
                "VALUES (NULL, ?, ?, ?, now(), ?)";
    }
    public boolean add(Map map){
        return update(getAddRecords(), BaseUtils.mapToObject(map));
    }
}
