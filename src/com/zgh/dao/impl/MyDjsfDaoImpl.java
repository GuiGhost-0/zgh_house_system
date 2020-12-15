package com.zgh.dao.impl;

import com.zgh.dao.SystemDao;

/**
 * 登记收费dao类
 * */
public class MyDjsfDaoImpl extends SystemDao {
    private String queryAllSql = null;
    private String queryAllSqlCount= null;

    public String getQueryAllSql() {
        return queryAllSql = "SELECT sf.MID,house.HADDRESS,house.HFH,cus.CNAME,cus.CTEL,sf.MBEGINTIME,dj.MDATE\n" +
                "FROM mysf sf,mydj dj,mycus cus,myhouse house\n" +
                "WHERE sf.MID = dj.MID AND dj.HID = house.HID AND dj.CID = cus.CID";
    }

    public String getQueryAllSqlCount() {
        return queryAllSqlCount = "SELECT COUNT(*) FROM mysf";
    }
}
