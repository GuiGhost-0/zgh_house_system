package com.zgh.service.impl;

import com.zgh.dao.impl.MyBsDaoImpl;
import com.zgh.entity.MyBs;
import com.zgh.service.BaseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBsServiceImpl implements BaseService {
    private MyBsDaoImpl bsDao = new MyBsDaoImpl();
    @Override
    public Integer queryRecordsCount() {
        return bsDao.queryCount(bsDao.getQueryALlSqlCount());
    }

    @Override
    public boolean add(Map map) {
        if(map == null){
            return false;
        }else {
            return bsDao.add(map);
        }
    }

    @Override
    public List queryAllRecordsDto(Map pageMap, Class cls, Object... args) {
        return bsDao.getBaseRecords(bsDao.getQueryALlSql(),pageMap,cls,args);
    }

    @Override
    public List<Map<String, Object>> queryAllRecords(String sql, Map pageMap, Object... args) {
        return null;
    }
}
