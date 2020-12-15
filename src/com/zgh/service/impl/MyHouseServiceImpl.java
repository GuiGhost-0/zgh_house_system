package com.zgh.service.impl;

import com.zgh.dao.impl.MyHouseDaoImpl;
import com.zgh.entity.MyHouse;
import com.zgh.service.BaseService;
import com.zgh.utils.NumberUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyHouseServiceImpl implements BaseService {
    private MyHouseDaoImpl houseDao = new MyHouseDaoImpl();
    @Override
    public Integer queryRecordsCount() {
        return houseDao.queryCount(houseDao.getQueryAllSqlCount());
    }

    public Integer queryCount(Object... args){
        if (args.length==0){
            return houseDao.queryCount(houseDao.getQueryAllSqlCount());
        }else {
            if (args.length == 1){
                return houseDao.queryCount(houseDao.getQueryAllSqlCount() + " AND c.AID=?",args);
            }else {
                int aid = NumberUtil.getInteger(args[0]);//01
                int sid = NumberUtil.getInteger(args[1]);//00
                int zt = NumberUtil.getInteger(args[2]);//0
                if (aid != 0 && sid != 0 && zt != -1){
                    return houseDao.queryCount(houseDao.getQueryAllSqlCount() + " AND c.AID=? AND c.SID = ? AND c.HFLAG = ?",args);
                }else {
                    if (aid != 0){//aid != 0
                        if (sid != 0){//aid != 0 && sid != 0&& zt == 0
                            return houseDao.queryCount(houseDao.getQueryAllSqlCount() + " AND c.AID=? AND c.SID = ?",new Object[]{aid,sid});
                        }else {//aid != 0 && sid ==0
                            if (zt != -1){//aid != 0 && sid ==0 && zt!=0
                                return houseDao.queryCount(houseDao.getQueryAllSqlCount() + " AND c.AID=? AND c.HFLAG = ?",new Object[]{aid,zt});
                            }else {//aid != 0 && sid ==0 && zt==0、
                                return houseDao.queryCount(houseDao.getQueryAllSqlCount() + " AND c.AID=?",new Object[]{aid});
                            }
                        }
//                        return houseDao.getBaseRecords(houseDao.getQueryAllSql() + " AND c.SID = ? AND c.HFLAG = ?",pageMap,cls,args);
                    }else if (sid != 0){//aid == 0 && sid != 0
                        if (zt != -1){//aid == 0 && sid != 0 && zt!=0
                            return houseDao.queryCount(houseDao.getQueryAllSqlCount() + " AND c.SID = ? AND c.HFLAG = ?",new Object[]{sid,zt});
                        }else {//aid == 0 && sid != 0 && zt == 0
                            return houseDao.queryCount(houseDao.getQueryAllSqlCount() + " AND c.SID = ?",new Object[]{sid});
                        }
//                        return houseDao.getBaseRecords(houseDao.getQueryAllSql() + " AND c.AID=? AND c.HFLAG = ?",pageMap,cls,args);
                    }else if (zt != -1){//aid==0 && sid==0 && zt!=0
                        return houseDao.queryCount(houseDao.getQueryAllSqlCount() + " AND c.HFLAG = ?",new Object[]{zt});
                    }else {//aid==0 && sid==0 && zt==0
                        return houseDao.queryCount(houseDao.getQueryAllSqlCount());
                    }

                }

            }
        }
    }

    @Override
    public boolean add(Map map) {
        if(map == null){
            return false;
        }else {
            return houseDao.add(map);
        }

    }

    @Override
    public List queryAllRecordsDto(Map pageMap, Class cls, Object... args) {
//        if (args != null && args.length>0){
//            return houseDao.getBaseRecords(houseDao.getQueryAllSql() + " AND c.AID=?",pageMap,cls,args);
//        }else{
//            return houseDao.getBaseRecords(houseDao.getQueryAllSql(),pageMap,cls,args);
//        }

        if (args.length==0){
            return houseDao.getBaseRecords(houseDao.getQueryAllSql(),pageMap,cls);
        }else {
            if (args.length == 1){
                return houseDao.getBaseRecords(houseDao.getQueryAllSql() + " AND c.AID=? AND c.HFLAG = 0",pageMap,cls,args);
            }else {
                int aid = NumberUtil.getInteger(args[0]);//01
                int sid = NumberUtil.getInteger(args[1]);//00
                int zt = NumberUtil.getInteger(args[2]);//0
                if (aid != 0 && sid != 0 && zt != -1){
                    return houseDao.getBaseRecords(houseDao.getQueryAllSql() + " AND c.AID=? AND c.SID = ? AND c.HFLAG = ?",pageMap,cls,args);
                }else {
                    if (aid != 0){//aid != 0
                        if (sid != 0){//aid != 0 && sid != 0&& zt == 0
                            return houseDao.getBaseRecords(houseDao.getQueryAllSql() + " AND c.AID=? AND c.SID = ?",pageMap,cls,new Object[]{aid,sid});
                        }else {//aid != 0 && sid ==0
                            if (zt != -1){//aid != 0 && sid ==0 && zt!=0
                                return houseDao.getBaseRecords(houseDao.getQueryAllSql() + " AND c.AID=? AND c.HFLAG = ?",pageMap,cls,new Object[]{aid,zt});
                            }else {//aid != 0 && sid ==0 && zt==0
                                return houseDao.getBaseRecords(houseDao.getQueryAllSql() + " AND c.AID=?",pageMap,cls,new Object[]{aid});
                            }
                        }
//                        return houseDao.getBaseRecords(houseDao.getQueryAllSql() + " AND c.SID = ? AND c.HFLAG = ?",pageMap,cls,args);
                    }else if (sid != 0){//aid == 0 && sid != 0
                        if (zt != -1){//aid == 0 && sid != 0 && zt!=0
                            return houseDao.getBaseRecords(houseDao.getQueryAllSql() + " AND c.SID = ? AND c.HFLAG = ?",pageMap,cls,new Object[]{sid,zt});
                        }else {//aid == 0 && sid != 0 && zt == 0

                            return houseDao.getBaseRecords(houseDao.getQueryAllSql() + " AND c.SID = ?",pageMap,cls,new Object[]{sid});
                        }
//                        return houseDao.getBaseRecords(houseDao.getQueryAllSql() + " AND c.AID=? AND c.HFLAG = ?",pageMap,cls,args);
                    }else if (zt != -1){//aid==0 && sid==0 && zt!=0
                        return houseDao.getBaseRecords(houseDao.getQueryAllSql() + " AND c.HFLAG = ?",pageMap,cls,new Object[]{zt});
                    }else {//aid==0 && sid==0 && zt==0
                        return houseDao.getBaseRecords(houseDao.getQueryAllSql(),pageMap,cls);
                    }

                }

            }
        }


    }

    public List queryAidNoZeroDto(Map pageMap,Class cls,Object... args){
        if (args.length == 1){
            return houseDao.getBaseRecords(houseDao.getQueryAllSql() + " AND c.AID = ?",pageMap,cls,args);
        }else {
            return houseDao.getBaseRecords(houseDao.getQueryAllSql() + " AND c.AID = ? AND c.SID = ?",pageMap,cls,args);
        }
    }

    public List querySidNoZeroDto(Map pageMap,Class cls,Object... args){
        if (args.length==1){
            return houseDao.getBaseRecords(houseDao.getQueryAllSql() + " AND c.SID = ?",pageMap,cls,args);
        }else {
            return houseDao.getBaseRecords(houseDao.getQueryAllSql() + " AND c.AID = ? AND c.SID = ?",pageMap,cls,args);
        }
    }

    @Override
    public List<Map<String, Object>> queryAllRecords(String sql, Map pageMap, Object... args) {
        return null;
    }


}
