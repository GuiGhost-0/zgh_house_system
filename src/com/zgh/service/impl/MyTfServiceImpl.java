package com.zgh.service.impl;

import com.zgh.dao.impl.MyTfDaoImpl;
import com.zgh.entity.MyTf;
import com.zgh.service.BaseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTfServiceImpl implements BaseService {
    private MyTfDaoImpl tfDao = new MyTfDaoImpl();

    @Override
    public Integer queryRecordsCount() {
        return tfDao.queryCount(tfDao.getQueryAllSqlCount());
    }

    @Override
    public boolean add(Map map) {
        return false;
    }

    @Override
    public List queryAllRecordsDto(Map pageMap, Class cls, Object... args) {
        return tfDao.getBaseRecords(tfDao.getQueryAllSql(), pageMap, cls, args);
    }

    @Override
    public List<Map<String, Object>> queryAllRecords(String sql, Map pageMap, Object... args) {
        return null;
    }

}
