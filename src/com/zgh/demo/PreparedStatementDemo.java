package com.zgh.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class PreparedStatementDemo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        ResultSet resultSet = getResultSet();
        System.out.println(resultSet);

    }
    /*
     * 获取从数据库中查找的值
     * */
    public static ResultSet getResultSet() throws SQLException, ClassNotFoundException {
        String sql = "select * from xx where 1 = ?";
        Object[] objects = {1};
        ResultSet resultSet = null;
        //获取Connection对象
        Connection connection = JdbcConnectonDemo.getConnection();
        //获取预处理对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if(objects!=null && objects.length>=1){
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i+1,objects[i]);
            }
        }
        //得到结果集
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

}
