package com.zgh.service.impl;

import com.zgh.dao.impl.MyShouRuDaoImpl;
import com.zgh.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 收入表的业务层service
 * */
public class MyShouRuServiceImpl implements BaseService {
    private MyShouRuDaoImpl dao = new MyShouRuDaoImpl();
    @Override
    public Integer queryRecordsCount() {
        return dao.queryCount(dao.getQueryRecordsCount());
    }

    @Override
    public boolean add(Map map) {
        if (map == null){
            return false;
        }else {
            return dao.add(map);
        }
    }

    @Override
    public List queryAllRecordsDto(Map pageMap, Class cls, Object... args) {
        return dao.getBaseRecords(dao.getQueryAllSql(),pageMap,cls,args);
    }

    @Override
    public List<Map<String, Object>> queryAllRecords(String sql, Map pageMap, Object... args) {
        return null;
    }
}
