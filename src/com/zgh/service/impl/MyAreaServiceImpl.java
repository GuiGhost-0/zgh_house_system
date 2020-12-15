package com.zgh.service.impl;

import com.zgh.dao.impl.MyAreaDaoImpl;
import com.zgh.entity.MyArea;
import com.zgh.service.BaseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAreaServiceImpl implements BaseService {
    private MyAreaDaoImpl areaDao = new MyAreaDaoImpl();
    @Override
    public Integer queryRecordsCount() {
        return areaDao.queryCount(areaDao.getQueryAllSqlCount());
    }

    @Override
    public boolean add(Map map) {
        return areaDao.add(map);
    }

    @Override
    public List queryAllRecordsDto(Map pageMap, Class cls, Object... args) {
        return areaDao.getBaseRecords(areaDao.getQueryAllSql(),pageMap,cls,args);
    }

    @Override
    public List<Map<String, Object>> queryAllRecords(String sql, Map pageMap, Object... args) {
        return null;
    }
}
