package com.zgh.dao;

import com.zgh.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public abstract class SystemDao extends BaseDao{

    public final List<Map<String,Object>> query(String sql,Map<String,Object> pageMap,
                                                Object... args){
        return JdbcUtil.query(sql,pageMap,args);
    }

    /**
     * 查询记录数
     * */
    public final int queryCount(String sql,Object... args){
        int count = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if(args != null && args.length>=1){
                for (int i = 0; i < args.length; i++) {
//                    System.out.println(args[i]);
                    preparedStatement.setObject(i+1,args[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                count = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(connection,preparedStatement,resultSet);
        }
        return count;
    }


    public boolean update(String sql, Object... args){
        return JdbcUtil.update(sql, args);
    }

}
