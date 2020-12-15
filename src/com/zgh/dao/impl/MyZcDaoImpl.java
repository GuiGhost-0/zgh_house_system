package com.zgh.dao.impl;

import com.zgh.dao.SystemDao;
import com.zgh.utils.BaseUtils;

import java.util.Map;

public class MyZcDaoImpl extends SystemDao {
    private String queryALlSql = null;
    private String queryAllSqlCount = null;
    private String addRecords = null;

    public String getQueryALlSql() {
        return queryALlSql = "SELECT * FROM myzc";
    }

    public String getQueryAllSqlCount() {
        return queryAllSqlCount = "SELECT COUNT(1) FROM myzc";
    }

    public String getAddRecords() {
        return addRecords = "INSERT INTO `dxfwcz`.`myzc`(`CID`, `CTITLE`, `CTIME`, `CREMARK`) " +
                "VALUES (NULL, ?, NOW(), ?)";
    }

    public boolean add(Map map){
        Object[] objects = BaseUtils.mapToObject(map);
        return update(getAddRecords(),objects);
    }
}
