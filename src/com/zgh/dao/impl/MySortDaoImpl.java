package com.zgh.dao.impl;

import com.zgh.dao.SystemDao;
import com.zgh.utils.BaseUtils;

import java.rmi.MarshalledObject;
import java.util.Map;

public class MySortDaoImpl extends SystemDao {
    private String queryAllSql =null;
    private String queryAllSqlCount =null;
    private String addRecords = null;

    public String getQueryAllSql() {
        return queryAllSql= "select * from mysort where 1=1";
    }

    public String getQueryAllSqlCount() {
        return queryAllSqlCount= "select count(*) from mysort";
    }

    public String getAddRecords() {
        return addRecords = "INSERT INTO `dxfwcz`.`mysort`(`SID`, `SNAME`) VALUES (NULL, ?)";
    }

    public boolean add(Map map){
        Object[] objects = BaseUtils.mapToObject(map);
        return update(getAddRecords(),objects);
    }
}
