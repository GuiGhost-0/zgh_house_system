package com.zgh.service.impl;

import com.zgh.dao.impl.CustomDaoImpl;
import com.zgh.entity.Customer;
import com.zgh.service.BaseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomServiceImpl implements BaseService {
    private CustomDaoImpl customDao = new CustomDaoImpl();


    public boolean addCustom(Customer dto){
        if(dto == null){
            return false;
        }else{
            return customDao.addCustom(dto);
        }
    }


    @Override
    public Integer queryRecordsCount() {
        return customDao.queryCount(customDao.getQueryALlSqlCount());
    }

    @Override
    public boolean add(Map map) {
        return false;
    }

    @Override
    public List queryAllRecordsDto(Map pageMap, Class cls, Object... args) {
        return customDao.getBaseRecords(customDao.getQueryAllSql(),pageMap,cls,args);
    }

    @Override
    public List<Map<String, Object>> queryAllRecords(String sql, Map pageMap, Object... args) {
        return null;
    }
}
