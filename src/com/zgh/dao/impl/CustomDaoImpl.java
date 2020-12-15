package com.zgh.dao.impl;

import com.zgh.dao.SystemDao;
import com.zgh.entity.Customer;

public class CustomDaoImpl extends SystemDao {
    private String queryALlSqlCount = null;
    private String queryAllSql = null;
    private String addRecords = null;

    public String getQueryALlSqlCount() {
        return "select count(*) from mycus";
    }

    public String getQueryAllSql() {
        return "select * from mycus where 1=1";
    }

    public String getAddRecords() {
        return "insert into mycus(CID,CNAME,CSEX,CTEL,CTEL1,CCARD)" +
                "value (null,?,?,?,?,?)";
    }

    public boolean addCustom(Customer dto){
        int length = 5;
        Object[] objects = new Object[length];
        objects[0] = dto.getCname();
        objects[1] = dto.getCsex();
        objects[2] = dto.getCtel();
        objects[3] = dto.getCtel1();
        objects[4] = dto.getCcard();
        return update(getAddRecords(),objects);
    }
}
