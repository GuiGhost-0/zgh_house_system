package com.zgh.demo;

import com.mysql.cj.xdevapi.SessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectonDemo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(getConnection());
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        String drivenClass="com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
        String userName = "root";
        String password = "ghost";
        //加载数据库驱动
        Class.forName(drivenClass);
        //获取Connection对象
        connection = DriverManager.getConnection(url, userName, password);


        return connection;
    }

//    public static SessionFactory getSessionFactory() throws SQLException, ClassNotFoundException {
//
//    }
}
