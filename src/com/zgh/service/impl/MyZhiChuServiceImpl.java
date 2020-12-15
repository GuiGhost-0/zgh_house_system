package com.zgh.service.impl;

import com.zgh.dao.impl.MyZhiChuDaoImpl;
import com.zgh.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 支出表的service类
 * */

public class MyZhiChuServiceImpl implements BaseService {
    private MyZhiChuDaoImpl zhiChuDao = new MyZhiChuDaoImpl();
    @Override
    public Integer queryRecordsCount() {
        return zhiChuDao.queryCount(zhiChuDao.getQueryAllRecordsCount());
    }

    @Override
    public boolean add(Map map) {
        if (map == null){
            return false;
        }else {
            return zhiChuDao.add(map);
        }
    }

    @Override
    public List queryAllRecordsDto(Map pageMap, Class cls, Object... args) {
        return zhiChuDao.getBaseRecords(zhiChuDao.getQueryAllSql(),pageMap,cls,args);
    }

    @Override
    public List<Map<String, Object>> queryAllRecords(String sql, Map pageMap, Object... args) {
        return null;
    }
}
