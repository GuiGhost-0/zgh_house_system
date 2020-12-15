package com.zgh.service.impl;

import com.zgh.dao.impl.MyBiaoDaoImpl;
import com.zgh.entity.MyBiao;
import com.zgh.service.BaseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBiaoServiceImpl implements BaseService {
    private MyBiaoDaoImpl biaoDao = new MyBiaoDaoImpl();
    @Override
    public Integer queryRecordsCount() {
        return biaoDao.queryCount(biaoDao.getQueryAllSqlCount());
    }

    @Override
    public boolean add(Map map) {
        if (map == null){
            return false;
        }else {
            return biaoDao.add(map);
        }
    }

    @Override
    public List queryAllRecordsDto(Map pageMap, Class cls, Object... args) {
        return biaoDao.getBaseRecords(biaoDao.getQueryAllSql(),pageMap,cls,args);
    }

    @Override
    public List<Map<String, Object>> queryAllRecords(String sql, Map pageMap, Object... args) {
        return null;
    }

}
