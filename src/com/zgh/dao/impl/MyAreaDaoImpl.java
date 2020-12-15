package com.zgh.dao.impl;

import com.zgh.dao.SystemDao;
import com.zgh.utils.BaseUtils;

import java.util.Map;

public class MyAreaDaoImpl extends SystemDao {
    private String queryAllSql = null;
    private String queryAllSqlCount = null;
    private String addRecords = null;

    public String getQueryAllSql() {
        return queryAllSql="select * from myarea where 1=1";
    }

    public String getQueryAllSqlCount() {
        return queryAllSqlCount="select count(*) from myarea";
    }

    public String getAddRecords() {
        return addRecords="INSERT INTO `dxfwcz`.`myarea`(`AID`, `ANAME`) VALUES (NULL, ?)";
    }

    public boolean add(Map map){
        Object[] objects = BaseUtils.mapToObject(map);
        return update(getAddRecords(),objects);
    }
}
