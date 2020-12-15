package com.zgh.service.impl;

import com.zgh.dao.impl.MyDjsfDaoImpl;
import com.zgh.entity.MyDjsf;
import com.zgh.service.BaseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDjsfServiceImpl implements BaseService {
    private MyDjsfDaoImpl djsfDao = new MyDjsfDaoImpl();
    @Override
    public Integer queryRecordsCount() {
        return djsfDao.queryCount(djsfDao.getQueryAllSqlCount());
    }

    @Override
    public boolean add(Map map) {
        return false;
    }

    @Override
    public List queryAllRecordsDto(Map pageMap, Class cls, Object... args) {
        return djsfDao.getBaseRecords(djsfDao.getQueryAllSql(),pageMap,cls,args);
    }

    @Override
    public List<Map<String, Object>> queryAllRecords(String sql, Map pageMap, Object... args) {
        return null;
    }
}
