package com.zgh.service;

/**
 * 基础Service接口
 * */
import java.util.List;
import java.util.Map;

public interface BaseService<T> {
    /**
     * 查询记录总数
     * */
    Integer queryRecordsCount();
    /**
     * 查询所有记录 返回List集合，list集合类型为Map<String,Object>
     * */
    List<Map<String,Object>> queryAllRecords(String sql,Map<String,Object> pageMap,Object... args);

    boolean add(Map map);
    /**
     * 转换为T类型的数据
     * */
    List<T> queryAllRecordsDto(Map<String,Object> pageMap,Class cls,Object... args);
}
