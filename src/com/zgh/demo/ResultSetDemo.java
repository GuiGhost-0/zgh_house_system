package com.zgh.demo;

import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSetDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        List<Map<String, Object>> resultList = getResultList();
        System.out.println(resultList.toString());
    }

    public static List<Map<String,Object>> getResultList() throws SQLException, ClassNotFoundException {
        List<Map<String,Object>> list = new ArrayList<>();
        //得到resultSet结果集
        ResultSet resultSet = PreparedStatementDemo.getResultSet();
        System.out.println("resultSet：" + resultSet);
        //获取结果集元数据
        ResultSetMetaData metaData = resultSet.getMetaData();
        //获取列数
        int columnCount = metaData.getColumnCount();
        //打印列数
        System.out.println("列数：" + columnCount);
        while(resultSet.next()){
            Map<String,Object> map = new HashMap<>();
            for(int i = 1;i<=columnCount;i++){
                map.put(metaData.getColumnName(i),resultSet.getObject(i));
            }
            list.add(map);
        }
        return list;
    }
}
