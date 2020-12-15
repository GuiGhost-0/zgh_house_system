package com.zgh.service.impl;

import com.zgh.dao.impl.MyZcDaoImpl;
import com.zgh.service.BaseService;

import java.util.List;
import java.util.Map;

public class MyZcServiceImpl implements BaseService {
    private MyZcDaoImpl zcDao = new MyZcDaoImpl();
    @Override
    public Integer queryRecordsCount() {
        return zcDao.queryCount(zcDao.getQueryAllSqlCount());
    }

    @Override
    public boolean add(Map map) {
        if (map == null){
            return false;
        }else {
            return zcDao.add(map);
        }
    }

    @Override
    public List queryAllRecordsDto(Map pageMap, Class cls, Object... args) {
        return zcDao.getBaseRecords(zcDao.getQueryALlSql(),pageMap,cls,args);
    }

    @Override
    public List<Map<String, Object>> queryAllRecords(String sql, Map pageMap, Object... args) {
        return null;
    }
}
