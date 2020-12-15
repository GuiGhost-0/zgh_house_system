package com.zgh.dao.impl;

import com.zgh.dao.SystemDao;
import com.zgh.utils.BaseUtils;

import java.util.Map;

/**
 * 收入表的dao类
 * */
public class MyShouRuDaoImpl extends SystemDao {
    private String queryAllSql = null;
    private String queryRecordsCount = null;
    private String addRecords = null;

    public String getQueryAllSql() {
        return queryAllSql = "SELECT sr.SID,sr.SMONEY,sr.STM,sr.SREMARK,sr.STIME,emp.EREALNAME\n" +
                "FROM myshouru sr,myemp emp\n" +
                "WHERE sr.EID = emp.EID";
    }

    public String getQueryRecordsCount() {
        return queryRecordsCount = "SELECT COUNT(*) FROM myshouru";
    }

    public String getAddRecords() {
        return addRecords = "INSERT INTO `dxfwcz`.`myshouru`" +
                "(`SID`, `EID`, `SMONEY`, `STM`, `STIME`, `SREMARK`) " +
                "VALUES (NULL, ?, ?, ?, now(), ?)";
    }

    public boolean add(Map map){
        Object[] objects = BaseUtils.mapToObject(map);
        return update(getAddRecords(),objects);
    }
}
