package com.zgh.service.impl;

import com.zgh.dao.impl.MySortDaoImpl;
import com.zgh.entity.MySort;
import com.zgh.service.BaseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySortServiceImpl implements BaseService {
    private MySortDaoImpl sortDao = new MySortDaoImpl();
    @Override
    public Integer queryRecordsCount() {
        return sortDao.queryCount(sortDao.getQueryAllSqlCount());
    }

    @Override
    public boolean add(Map map) {
        if(map == null){
            return false;
        }else{
            return sortDao.add(map);
        }

    }

    @Override
    public List queryAllRecordsDto(Map pageMap, Class cls, Object... args) {
        return sortDao.getBaseRecords(sortDao.getQueryAllSql(),pageMap,cls,args);
    }

    @Override
    public List<Map<String, Object>> queryAllRecords(String sql, Map pageMap, Object... args) {
        return null;
    }


}
