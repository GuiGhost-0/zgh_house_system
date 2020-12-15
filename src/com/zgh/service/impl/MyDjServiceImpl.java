package com.zgh.service.impl;

import com.zgh.dao.impl.MyDjDaoImpl;
import com.zgh.entity.MyDj;
import com.zgh.service.BaseService;
import com.zgh.utils.NumberUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDjServiceImpl implements BaseService {
    private MyDjDaoImpl djDao = new MyDjDaoImpl();
    @Override
    public Integer queryRecordsCount() {
        return djDao.queryCount(djDao.getQueryAllSqlCount());
    }

    public Integer queryCount(Object... args){
        if (args != null && args.length == 3){
            Integer aid = NumberUtil.getInteger(args[0]);
            Integer sid = NumberUtil.getInteger(args[1]);
            Integer hid = NumberUtil.getInteger(args[2]);
            if (aid != 0 && sid != 0 && hid != -1){
                return djDao.queryCount(djDao.getQueryAllSqlCount() + " AND b.AID = ? AND b.SID = ? AND a.HID = ?",args);
            }else {
                if (aid != 0){
                    if (sid != 0){
                        return djDao.queryCount(djDao.getQueryAllSqlCount() + " AND b.AID = ? AND b.SID = ?",new Object[]{aid,sid});
                    }else if (hid != -1){
                        return djDao.queryCount(djDao.getQueryAllSqlCount() + " AND b.AID = ? AND a.HID = ?",new Object[]{aid,hid});
                    }else {
                        return djDao.queryCount(djDao.getQueryAllSqlCount() + " AND b.AID = ?",new Object[]{aid});
                    }
                }else if (sid != 0){
                    if (hid != -1){
                        return djDao.queryCount(djDao.getQueryAllSqlCount() + " AND b.SID = ? AND a.HID = ?",new Object[]{sid,hid});
                    }else {
                        return djDao.queryCount(djDao.getQueryAllSqlCount() + " AND b.SID = ?",new Object[]{sid});
                    }
                }else if (hid != -1){
                    return djDao.queryCount(djDao.getQueryAllSqlCount() + " AND a.HID = ?" ,new Object[]{hid});
                }else {
                    return djDao.queryCount(djDao.getQueryAllSqlCount());
                }
            }

        }else {
            return djDao.queryCount(djDao.getQueryAllSqlCount(),args);
        }
    }

    public Integer queryDqRecordsCount(){
        return djDao.queryCount(djDao.getQueryDqSqlCount());
    }

    @Override
    public boolean add(Map map) {
        return djDao.add(map);
    }

    @Override
    public List queryAllRecordsDto(Map pageMap, Class cls, Object... args) {
        if (args != null && args.length == 3){
            Integer aid = NumberUtil.getInteger(args[0]);
            Integer sid = NumberUtil.getInteger(args[1]);
            Integer hid = NumberUtil.getInteger(args[2]);
            if (aid != 0 && sid != 0 && hid != -1){
                return djDao.getBaseRecords(djDao.getQueryAllSql() + " AND b.AID = ? AND b.SID = ? AND a.HID = ?",pageMap,cls,args);
            }else {
                if (aid != 0){
                    if (sid != 0){
                        return djDao.getBaseRecords(djDao.getQueryAllSql() + " AND b.AID = ? AND b.SID = ?",pageMap,cls,new Object[]{aid,sid});
                    }else if (hid != -1){
                        return djDao.getBaseRecords(djDao.getQueryAllSql() + " AND b.AID = ? AND a.HID = ?",pageMap,cls,new Object[]{aid,hid});
                    }else {
                        return djDao.getBaseRecords(djDao.getQueryAllSql() + " AND b.AID = ?",pageMap,cls,new Object[]{aid});
                    }
                }else if (sid != 0){
                    if (hid != -1){
                        return djDao.getBaseRecords(djDao.getQueryAllSql() + " AND b.SID = ? AND a.HID = ?",pageMap,cls,new Object[]{sid,hid});
                    }else {
                        return djDao.getBaseRecords(djDao.getQueryAllSql() + " AND b.SID = ?",pageMap,cls,new Object[]{sid});
                    }
                }else if (hid != -1){
                    return djDao.getBaseRecords(djDao.getQueryAllSql() + " AND a.HID = ?" ,pageMap,cls,new Object[]{hid});
                }else {
                    return djDao.getBaseRecords(djDao.getQueryAllSql(),pageMap,cls);
                }
            }

        }else {
            return djDao.getBaseRecords(djDao.getQueryAllSql(),pageMap,cls,args);
        }
    }

    @Override
    public List<Map<String, Object>> queryAllRecords(String sql, Map pageMap, Object... args) {
        return null;
    }

    public List queryDqDto(Map pageMap,Class cls, Object... args){
        return djDao.getBaseRecords(djDao.getQueryDqSql(),pageMap,cls,args);
    }
}
