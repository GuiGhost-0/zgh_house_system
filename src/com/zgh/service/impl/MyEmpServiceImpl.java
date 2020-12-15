package com.zgh.service.impl;

import com.zgh.dao.impl.MyEmpDaoImpl;
import com.zgh.entity.MyEmp;
import com.zgh.service.BaseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyEmpServiceImpl implements BaseService {
    private MyEmpDaoImpl empDao = new MyEmpDaoImpl();
    @Override
    public Integer queryRecordsCount() {
        return empDao.queryCount(empDao.getQueryAllSqlCount());
    }

    @Override
    public boolean add(Map map) {
        return empDao.add(map);
    }

    @Override
    public List queryAllRecordsDto(Map pageMap, Class cls, Object... args) {
        return empDao.getBaseRecords(empDao.getQueryAllSql(),pageMap,cls);
    }

    @Override
    public List<Map<String, Object>> queryAllRecords(String sql, Map pageMap, Object... args) {
        return null;
    }
}
