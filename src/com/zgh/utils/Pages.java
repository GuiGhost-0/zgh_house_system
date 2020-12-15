package com.zgh.utils;

/**
 * @author admin
 * @version 1.0
 * @desc 分页
 */
public class Pages
{
    /**
     * 获取总页数
     * @param allcount
     * @param mypages
     * @return
     */
    public int getAllPages(int allcount,int mypages)
    {
        int allpages=0;
        //java中 "%"与 "/"之间的区别
        //区别：
        //1、运算符上的区别：（a）%是求模运算符；（b）是除运算符
        //2、用法上的区别：（b）%是求余运算，即2%10=2，10%2=0，10%3=1
        // /是普通的除号，即10/2=5。
        int x=allcount%mypages;
        if(x==0)
        {
            allpages=allcount/mypages;
        }
        else
        {
            allpages=allcount/mypages+1;
        }
        return allpages;
    }

    /**
     * 上一页
     * @param current
     * @return
     */
    public  int getUp(int current)
    {
        int up=0;
        int y=current-1;
        if(y<=0)
        {
            up=1;
        }
        else
        {
            up=current-1;
        }
        return up;
    }

    /**
     * 下一页
     * @param current
     * @param allpages
     * @return
     */
    public  int getNext(int current,int allpages)
    {
        int next=0;
        int k=current+1;
        if(k>=allpages)
        {
            next=allpages;
        }
        else
        {
            next=current+1;
        }
        return next;
    }
}
