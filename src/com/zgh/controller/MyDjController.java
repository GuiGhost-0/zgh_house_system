package com.zgh.controller;

import com.zgh.entity.MyDj;
import com.zgh.service.impl.MyDjServiceImpl;
import com.zgh.utils.NumberUtil;
import com.zgh.utils.PageUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/mydj")
public class MyDjController extends SystemBaseController{
    private MyDjServiceImpl djService = new MyDjServiceImpl();
    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, Object> pageMap = initData(req);


        //aid:aid,sid:sid,hid:hid
        String aid = req.getParameter("aid");
        String sid = req.getParameter("sid");
        String hid = req.getParameter("hid");

        Object[] objects = null;
        if(aid != null && sid != null && hid != null){
            objects  = new Object[]{aid,sid,hid};
        }else {
            objects = new Object[]{};
        }





        List<MyDj> list = djService.queryAllRecordsDto(pageMap, MyDj.class, objects);
        if (list != null){

        }
        int allCount = djService.queryCount(objects);
        int allPages = page.getAllPages(allCount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allPages);
        if(list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                MyDj myDj = list.get(i);
                MyDj dj = new MyDj();
                dj.setMid(myDj.getMid());
                dj.setHaddress(myDj.getHaddress());
                dj.setHfh(myDj.getHfh());
                dj.setCname(myDj.getCname());
                dj.setCtel(myDj.getCtel());
                dj.setErealname(myDj.getErealname());
                dj.setMbegintime(myDj.getMbegintime());
                dj.setMyj(myDj.getMyj());
                dj.setMyzj(myDj.getMyzj());
                dj.setHflag(myDj.getHflag());
                dj.setMdate(myDj.getMdate());
                dj.setAllCount(allCount);
                dj.setAllPages(allPages);
                dj.setCurrent(current);
                dj.setUp(up);
                dj.setNext(next);
                resultList.add(dj);
            }
        }
        listWriterToWeb(resp,resultList);
    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonStr = null;
        Map<Integer,Object> map = new HashMap<Integer, Object>();
        //"cid=" + cid  + "&hid=" + hid +
        // "&eid=" + eid + "&myj=" + myj +
        // "&myzj=" + myzj + "&time=" + time +
        // "&doc=" + doc + "&methodName=add";
        /**
         * "INSERT INTO `dxfwcz`.`mydj`" +
         * "(`MID`, `MDATE`, `EID`, `CID`, `HID`, `MIMG`, `MYJ`, `MYZJ`, `MFLAG`, `MBEGINTIME`) " +
         * "VALUES (NULL, ?, 1, ?, ?, NULL, ?, ?, 0, NULL)";
         * */
        map.put(0,req.getParameter("time"));
        map.put(1,req.getParameter("eid"));
        map.put(2,req.getParameter("cid"));
        map.put(3,req.getParameter("hid"));
        map.put(4,req.getParameter("myj"));
        map.put(5,req.getParameter("myzj"));
        if (djService.add(map)){
            jsonStr = "1";
        }else{
            jsonStr = "0";
        }

        responseAddRecords(resp,jsonStr);
    }


    public void queryDq(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        Map<String, Object> pageMap = initData(req);

        int allCount = djService.queryDqRecordsCount();
        int allPages = page.getAllPages(allCount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allPages);

        List<MyDj> list = djService.queryDqDto(pageMap, MyDj.class);
        if (list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                MyDj myDj = list.get(i);
                MyDj dj = new MyDj();
                dj.setMid(myDj.getMid());
                dj.setHaddress(myDj.getHaddress());
                dj.setHfh(myDj.getHfh());
                dj.setCname(myDj.getCname());
                dj.setCtel(myDj.getCtel());
                dj.setMbegintime(myDj.getMbegintime());
                dj.setMdate(myDj.getMdate());
                dj.setAllCount(allCount);
                dj.setAllPages(allPages);
                dj.setCurrent(current);
                dj.setUp(up);
                dj.setNext(next);
                resultList.add(dj);
            }
        }
        listWriterToWeb(resp,resultList);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp);
        invokeMethodForName(this.getClass(),req,resp);
    }
}
