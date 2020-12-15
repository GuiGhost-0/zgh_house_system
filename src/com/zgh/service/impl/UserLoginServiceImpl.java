package com.zgh.service.impl;

import com.zgh.dao.impl.UserLoginDaoImpl;
import com.zgh.entity.User;
import com.zgh.service.BaseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserLoginServiceImpl implements BaseService {
    private UserLoginDaoImpl loginDao = new UserLoginDaoImpl();
    @Override
    public Integer queryRecordsCount() {
        return null;
    }

    @Override
    public boolean add(Map map) {
        return false;
    }

    @Override
    public List queryAllRecordsDto(Map pageMap, Class cls, Object... args) {
        return loginDao.getBaseRecords(loginDao.getQuerySql(),pageMap,cls,args);
    }

    public User queryAllById(Map pageMap, Class cls, Object... args){
        List baseRecords = loginDao.getBaseRecords(loginDao.getQuerySqlById(), pageMap, cls, args);
        return (User) baseRecords.get(0);
    }

    public boolean update(Map map){
        return loginDao.update(map);
    }

    @Override
    public List<Map<String, Object>> queryAllRecords(String sql, Map pageMap, Object... args) {
        return null;
    }

}
