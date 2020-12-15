package com.zgh.utils;

import java.util.Map;

public class BaseUtils {
    public static Object[] mapToObject(Map map){
        if (map != null && map.size()>0){
            Object[] objects = new Object[map.size()];
            for (int i = 0; i < objects.length; i++) {
                objects[i]=map.get(i);
            }
            return objects;
        }else {
            return null;
        }
    }
}
