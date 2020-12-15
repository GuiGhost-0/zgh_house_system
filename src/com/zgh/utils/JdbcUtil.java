package com.zgh.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

/*
* Jdbc工具类
* */

public class JdbcUtil {
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;

    /*
    * 获取数据库连接对象
    * */
    public static Connection getConnection(){
        Properties properties = new Properties();
        try {
            //使用输入流对象获取jdbc.properties文件
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
            //将通过InputStream对象获取的jdbc.properties文件导入到properties对象中
            properties.load(inputStream);
            //通过properties对象中的方法获取jdbc.properties文件中相应的值
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String userName = properties.getProperty("username");
            String password = properties.getProperty("password");
            Class.forName(driver);//加载数据库的驱动
            //使用DriverManager对象中的getConnection方法获取相应的数据库连接
            connection = DriverManager.getConnection(url,userName,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    /*
    * 查询方法，可分页
    * */
    public static List<Map<String,Object>> query(String sql,Map<String,Object> pageMap,Object... objects){
        List<Map<String,Object>> mapList = new ArrayList<>();
        try {
            connection = getConnection();
            Object start = pageMap.get("start");
            Object pageSize = pageMap.get("pageSize");
            if(pageMap != null && start != null && pageMap != null){
                preparedStatement = connection.prepareStatement(sql + " limit " + start + "," + pageSize);
            }else{
                preparedStatement = connection.prepareStatement(sql);
            }

           if(objects != null && objects.length>=1){
               for (int i = 0; i < objects.length; i++) {
                   preparedStatement.setObject(i+1,objects[i]);
               }
           }

            resultSet = preparedStatement.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while(resultSet.next()){
                Map<String,Object> map = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    map.put(metaData.getColumnName(i),resultSet.getObject(i));
                }
                mapList.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(connection,preparedStatement,resultSet);
        }

        return mapList;
    }

    /*
    * 通用方法：可用于update、insert、delete
    * */
    public static boolean update(String sql,Object... args){
        int k = 0;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if(args != null && args.length>=1){
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i+1,args[i]);
                }
            }
            k = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(connection,preparedStatement,null);
        }

        return k>0;
    }




    /*
    * 用于关闭Connection、PreparedStatement、ResultSet资源
    * */
    public static void close(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){

        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
