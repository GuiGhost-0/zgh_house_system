package com.zgh.dao.impl;

import com.zgh.dao.SystemDao;
import com.zgh.utils.BaseUtils;

import java.util.Map;

public class MyHtDaoImpl extends SystemDao {
    private String queryAllSqlCount = null;
    private String queryAllSql = null;
    private String addRecords = null;


    public String getQueryAllSqlCount() {
        return queryAllSqlCount = "SELECT COUNT(1) FROM myht";
    }

    public String getQueryAllSql() {
        return queryAllSql = "SELECT * FROM myht";
    }

    public String getAddRecords() {
        return addRecords = "INSERT INTO `dxfwcz`.`myht`(`HTID`, `HTNAME`, `HTREMARK`) " +
                "VALUES (NULL, ?, ?)";
    }

    public boolean add(Map map){
        Object[] objects = BaseUtils.mapToObject(map);
        return update(getAddRecords(),objects);
    }
}
