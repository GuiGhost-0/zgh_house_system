package com.zgh.dao.impl;

import com.zgh.dao.SystemDao;
import com.zgh.entity.Dept;

import java.util.List;
import java.util.Map;

/**
 * 部门Dao，继承字SystemDao
 * */
public class DeptSystemDaoImpl extends SystemDao {
    private String addRecords = "insert into mydept(PID,PNAME,PREMARK) value(null,?,?)";

    public String getAddRecords() {
        return addRecords;
    }

    public boolean add(Dept dept){
        Object[] objects = new Object[]{dept.getPname(),dept.getPremark()};
        if(dept == null){
            return false;
        }else{
            return update(addRecords,objects);
        }
    }
}
