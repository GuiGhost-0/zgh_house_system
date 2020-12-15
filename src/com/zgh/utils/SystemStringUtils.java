package com.zgh.utils;

import org.springframework.util.StringUtils;

/**
 * 
* @Title: SystemStringUtils.java
* @Description: 系统字符串工具类
* @author admin
* @date 2020年6月13日 下午3:33:41
* @version V1.0
 */
public final class SystemStringUtils extends StringUtils {
    /**
     * @desc 英文字符串大写转小写或者英文字符串小写转大写（字符串都是大写或者字符串都是小写）
     * @param str
     * @return
     */
    public static String convertString(String str)
    {
        String upStr = str.toUpperCase();
        String lowStr = str.toLowerCase();
        StringBuffer buf = new StringBuffer(str.length());
        for(int i=0;i < str.length();i++)
        {
            if(str.charAt(i)==upStr.charAt(i))
            {
                buf.append(lowStr.charAt(i));
            }
            else
            {
                buf.append(upStr.charAt(i));
            }
        }
        return   buf.toString();
    }

    public static void main(String[] args) {
        //PNAME
        String str = "PNAME";
        if(SystemStringUtils.isEmpty(str)){
            System.out.println("字符串为空或者为null");
        }else{
            System.out.println("isEmpty str=" + str);
        }
        System.out.println("str=" + convertString(str));
        str = "pname";
        System.out.println("str lower =" + convertString(str));
    }
}