package com.zgh.controller;

import com.zgh.entity.MyDjsf;
import com.zgh.service.impl.MyDjServiceImpl;
import com.zgh.service.impl.MyDjsfServiceImpl;
import com.zgh.utils.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/mydjsf")
public class MyDjsfController extends SystemBaseController{
    private MyDjsfServiceImpl djsfService = new MyDjsfServiceImpl();
    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonStr = null;
        Map<String, Object> pageMap = initData(req);

        int allCount = djsfService.queryRecordsCount();
        int allPages = page.getAllPages(allCount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<MyDjsf> list = djsfService.queryAllRecordsDto(pageMap, MyDjsf.class, objects);
        if (list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                MyDjsf myDjsf = list.get(i);
                MyDjsf djsf = new MyDjsf();
                djsf.setMid(myDjsf.getMid());
                djsf.setHaddress(myDjsf.getHaddress());
                djsf.setHfh(myDjsf.getHfh());
                djsf.setCname(myDjsf.getCname());
                djsf.setCtel(myDjsf.getCtel());
                djsf.setMbegintime(myDjsf.getMbegintime());
                djsf.setMdate(myDjsf.getMdate());
                djsf.setAllCount(allCount);
                djsf.setAllPages(allPages);
                djsf.setCurrent(current);
                djsf.setUp(up);
                djsf.setNext(next);
                resultList.add(djsf);
            }
        }
        listWriterToWeb(resp,resultList);
    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp);
        invokeMethodForName(this.getClass(),req,resp);
    }
}
