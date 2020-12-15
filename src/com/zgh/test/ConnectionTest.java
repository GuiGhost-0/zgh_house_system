package com.zgh.test;

import com.zgh.utils.JdbcUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectionTest {
    public static void main(String[] args) {
        System.out.println(JdbcUtil.getConnection());
        String sql = "select * from xx";
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("start",0);
        pageMap.put("pageSize",2);
        List<Map<String, Object>> list = JdbcUtil.query(sql, pageMap);
        System.out.println(list.toString());


        Object[] upVaules = new Object[]{1};
        String upSql = "update xx set name = '鬼鬼' where id = ?";
        if(JdbcUtil.update(upSql,upVaules)){
            System.out.println("修改成功");
            List<Map<String, Object>> list1 = JdbcUtil.query("select * from xx where id = ?", new HashMap<>(),upVaules);
            System.out.println(list1.toString());
        }


    }
}
