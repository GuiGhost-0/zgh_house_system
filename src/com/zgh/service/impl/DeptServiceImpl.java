package com.zgh.service.impl;

import com.zgh.dao.impl.DeptBaseDaoImpl;
import com.zgh.dao.impl.DeptSystemDaoImpl;
import com.zgh.entity.Dept;
import com.zgh.utils.NumberUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 部门信息serviceImpl
 * */
public class DeptServiceImpl {
    DeptBaseDaoImpl deptBaseDao = new DeptBaseDaoImpl();
    DeptSystemDaoImpl deptSystemDao = new DeptSystemDaoImpl();

    String queryAllSql = "select * from mydept where 1=1";
    String queryAllSqlCount = "select count(*) from mydept";

    /**
     * 查询总记录数
     */
    public Integer queryRecordsTotal(){
        String sql = "select count(*) from mydept";
        return deptSystemDao.queryCount(sql);
    }

    public List<Map<String,Object>> queryRecordsList(Map<String,Object> pageMap,Object... args){
        List<Map<String, Object>> list = deptSystemDao.query(queryAllSql, pageMap, args);
//        System.out.println("List<Map<String,Object>> queryRecords(Obejct[] args)" + list);
        return list;
    }

    public boolean add(Dept dept){
       return deptSystemDao.add(dept);
    }

    public List<Dept> queryRecordsListDto(Map<String,Object> pageMap,Object... args){
        List<Map<String, Object>> queryList = queryRecordsList(pageMap, args);
//        System.out.println(queryList);
        List<Dept> resultList = new ArrayList<Dept>();
        if(queryList != null && !queryList.isEmpty()){
            for (int i = 0; i < queryList.size(); i++) {
                Map<String, Object> map = queryList.get(i);
                Dept dept = new Dept();
                dept.setPid(NumberUtil.getLong(map.get("PID")));
                dept.setPname((String) map.get("PNAME"));
                dept.setPflag(NumberUtil.getLong(map.get("PFLAG")));
                dept.setPremark((String) map.get("PREMARK"));
                resultList.add(dept);
            }
        }
        return resultList;
    }
}
