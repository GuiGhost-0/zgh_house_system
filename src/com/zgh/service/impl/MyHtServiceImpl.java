package com.zgh.service.impl;

import com.zgh.dao.impl.MyHtDaoImpl;
import com.zgh.service.BaseService;

import java.util.List;
import java.util.Map;

public class MyHtServiceImpl implements BaseService {
    private MyHtDaoImpl htDao  = new MyHtDaoImpl();
    @Override
    public Integer queryRecordsCount() {
        return htDao.queryCount(htDao.getQueryAllSqlCount());
    }

    @Override
    public boolean add(Map map) {
        if (map == null){
            return false;
        }else {
            return htDao.add(map);
        }
    }

    @Override
    public List queryAllRecordsDto(Map pageMap, Class cls, Object... args) {
        return htDao.getBaseRecords(htDao.getQueryAllSql(),pageMap,cls,args);
    }

    @Override
    public List<Map<String, Object>> queryAllRecords(String sql, Map pageMap, Object... args) {
        return null;
    }
}
