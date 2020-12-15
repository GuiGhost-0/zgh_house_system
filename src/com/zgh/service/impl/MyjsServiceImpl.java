package com.zgh.service.impl;

import com.zgh.dao.impl.MyjsDao;
import com.zgh.entity.Myjs;
import com.zgh.service.BaseService;
import com.zgh.utils.NumberUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 岗位信息的service
 * */

public class MyjsServiceImpl implements BaseService {
    MyjsDao myjsDao = new MyjsDao();
    @Override
    public Integer queryRecordsCount() {
        return myjsDao.queryCount(myjsDao.getQueryAllSqlCount());
    }

    @Override
    public boolean add(Map map) {
        if (map == null)
            return false;
        else
            return myjsDao.add(map);
    }

    @Override
    public List queryAllRecordsDto(Map pageMap, Class clzz, Object... args) {
        List baseRecords = myjsDao.getBaseRecords(myjsDao.getQueryAllSql(), pageMap, clzz, args);
        return baseRecords;
    }

//    @Override
//    public List<Myjs> queryAllRecordsDto(Map pageMap, Object... args) {
//        List<Map<String, Object>> list = queryAllRecords(myjsDao.getQueryAllSql(), pageMap, args);
//        List<Myjs> myjsList = new ArrayList<>();
//        if(list != null && !list.isEmpty()){
//            for (int i = 0; i < list.size(); i++) {
//                Myjs myjs = new Myjs();
//                Map<String, Object> map = list.get(i);
//                myjs.setJid(NumberUtil.getInteger(map.get("JID")));
//                myjs.setJname((String) map.get("JNAME"));
//                myjsList.add(myjs);
//            }
//        }
//        return myjsList;
//    }

    @Override
    public List<Map<String, Object>> queryAllRecords(String sql, Map pageMap, Object... args) {
        List<Map<String, Object>> query = myjsDao.query(sql, pageMap,args);
        return query;
    }

}
