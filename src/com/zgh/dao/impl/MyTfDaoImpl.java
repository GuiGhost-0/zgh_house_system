package com.zgh.dao.impl;

import com.zgh.dao.SystemDao;

public class MyTfDaoImpl extends SystemDao {
    private String queryAllSql = null;
    private String queryAllSqlCount = null;

    public String getQueryAllSql() {
        return queryAllSql = "SELECT tf.MID,house.HADDRESS,house.HFH,cus.CNAME,cus.CTEL,dj.MBEGINTIME,dj.MDATE\n" +
                "FROM mytf tf,mydj dj,mycus cus,myhouse house\n" +
                "WHERE tf.MID = dj.MID AND dj.HID = house.HID AND dj.CID = cus.CID";
    }

    public String getQueryAllSqlCount() {
        return queryAllSqlCount = "SELECT COUNT(*) FROM mytf";
    }
}
