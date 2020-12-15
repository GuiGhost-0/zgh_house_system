package com.zgh.dao;


import com.fasterxml.jackson.databind.util.BeanUtil;
import com.zgh.utils.JdbcUtil;
import com.zgh.utils.SystemStringUtils;
import org.apache.commons.beanutils.BeanUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 抽象基类Dao
* */
public abstract class BaseDao<T> {

    //获取数据库表中的记录，
    public final List<T> getBaseRecords(String sql, Map<String, Object> pageMap, Class<T> clazz, Object... args){
        //新建一个list集合，list集合中的类型为T（运行时由用户传递的）
        List<T> list = new ArrayList<>();
        //新建一个Connection对象（用于存放数据库的连接）
        Connection connection = null;
        //新建一个PreparedStatement对象（预处理对象：用于执行sql语句）
        PreparedStatement preparedStatement = null;
        //结果集对象，用于存放由PreparedStatement对象执行完后得到的结果集
        ResultSet resultSet = null;
        try {
            //通过JdbcUtil工具类获取数据库的连接
            connection = JdbcUtil.getConnection();
            //获取分页查询的参数
            Object start = pageMap.get("start");
            Object pageSize = pageMap.get("pageSize");

            //根据传入的pageMap来判断是否需要对该sql语句进行分页查询，并用PreparedStatement对象执行相应的sql语句
            if(pageMap != null && start != null && pageSize != null){
                preparedStatement = connection.prepareStatement(sql + " limit " + start + "," + pageSize);
            }else{
                preparedStatement = connection.prepareStatement(sql);
            }
            //根据传入的Object[]中的值为sql语句中的占位符（？）赋值
            if(args != null && args.length>=1){
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i+1,args[i]);
                }
            }
            //通过PreparedStatement对象的结果集并赋给ResultSet
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                T bean = clazz.newInstance();//得到T的实例化对象
                getRecordToBean(resultSet,bean);//将结果集中的数据转化为实体类
                list.add(bean);//把bean对象添加到List集合中
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(connection,preparedStatement,resultSet);
        }

        return list;
    }

    //将数据库表中的记录转为实体类
    private void getRecordToBean(ResultSet resultSet,Object bean){
        Map<String,Object> map = new HashMap<>();
        try {
            //获取结果集元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //结果集列数
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);//列名
                Object columnValue = resultSet.getObject(i);//值
                columnName = SystemStringUtils.convertString(columnName);//字母大写转小写
                map.put(columnName,columnValue);//把结果集中的值以键值对的形式存储到map集合中
            }
            /*
            * BeanUtils.populate(bean,map)方法会遍历Map<key,value> 中的key，
            * 如果bean中有对应的属性，就把这个key对应的value值赋给bean中对应的属性
            *
            * */
            BeanUtils.populate(bean,map);
//            System.out.println(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer queryMaxMid(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Integer mid = null;
        try {
            String sql = "SELECT MAX(MID) FROM mydj";
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                mid = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtil.close(connection,preparedStatement,resultSet);
        }
        return mid;
    }
}
