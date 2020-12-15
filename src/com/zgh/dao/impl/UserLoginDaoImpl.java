package com.zgh.dao.impl;

import com.zgh.dao.SystemDao;
import com.zgh.utils.BaseUtils;

import java.util.Map;

public class UserLoginDaoImpl extends SystemDao {
    private String querySql = "select EID,ENAME,EPSW from myemp where ENAME=? AND EPSW=?";
    private String querySqlById = "select EID,ENAME,EPSW from myemp where EID=?";
    private String updatePswSql = "UPDATE `dxfwcz`.`myemp` SET  `EPSW` = ? WHERE `EID` = ?";

    public String getQuerySql() {
        return querySql;
    }

    public String getQuerySqlById() {
        return querySqlById;
    }

    public String getUpdatePswSql() {
        return updatePswSql;
    }

    public boolean update(Map map){
        Object[] objects = BaseUtils.mapToObject(map);
        return update(getUpdatePswSql(),objects);
    }
}
