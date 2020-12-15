package com.zgh.controller;


import com.zgh.entity.MyTf;
import com.zgh.service.impl.MyTfServiceImpl;
import com.zgh.utils.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@WebServlet("/mytf")
public class MyTfController extends SystemBaseController{
    private MyTfServiceImpl tfService = new MyTfServiceImpl();
    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonStr = null;
        Map<String, Object> pageMap = initData(req);

        int allCount = tfService.queryRecordsCount();
        int allPages = page.getAllPages(allCount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<MyTf> list = tfService.queryAllRecordsDto(pageMap, MyTf.class, objects);
        if (list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                MyTf myTf = list.get(i);
                MyTf tf = new MyTf();
                tf.setMid(myTf.getMid());
                tf.setHaddress(myTf.getHaddress());
                tf.setHfh(myTf.getHfh());
                tf.setCname(myTf.getCname());
                tf.setCtel(myTf.getCtel());
                tf.setMbegintime(myTf.getMbegintime());
                tf.setMdate(myTf.getMdate());
                tf.setAllCount(allCount);
                tf.setAllPages(allPages);
                tf.setCurrent(current);
                tf.setUp(up);
                tf.setNext(next);
                resultList.add(tf);
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
        invokeMethodForName(MyTfController.class,req,resp);
    }
}
