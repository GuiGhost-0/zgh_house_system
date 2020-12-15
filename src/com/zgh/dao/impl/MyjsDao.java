package com.zgh.dao.impl;

/**
 * 岗位信息表的dao类
 * */
import com.zgh.dao.SystemDao;
import com.zgh.utils.BaseUtils;

import java.util.Map;
import java.util.Set;

public class MyjsDao extends SystemDao {
    private String queryAllSqlCount = null;
    private String queryAllSql = null;
    private String addRecords = null;

    public String getQueryAllSqlCount() {
        String sql = "select count(*) from myjs";
        queryAllSqlCount = sql;
        return queryAllSqlCount;
    }

    public String getQueryAllSql() {
        String sql = "select * from myjs where 1 = 1";
        queryAllSql = sql;
        return queryAllSql;
    }

    public String getAddRecords() {
        return "INSERT INTO dxfwcz.myjs(JID,JNAME) VALUES (null, ?)";
    }

    public boolean add(Map map){
        Object[] objects = BaseUtils.mapToObject(map);
        return update(getAddRecords(),objects);
    }
}
