package com.zgh.controller;

import com.zgh.entity.MyHouse;
import com.zgh.service.impl.MyHouseServiceImpl;
import com.zgh.utils.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet("/myhouse")
public class MyHouseController extends SystemBaseController{
    private MyHouseServiceImpl houseService = new MyHouseServiceImpl();

    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, Object> pageMap = initData(req);
        //aid:aid,sid:sid,zt:zt
        String aid = req.getParameter("aid");
        String sid = req.getParameter("sid");
        String zt = req.getParameter("zt");
        Object[] objects = null;
        if (aid != null && sid != null && zt != null){
            objects = new Object[]{aid,sid,zt};
        }else {
            if (aid != null){
                objects = new Object[]{aid};
            }else {
                objects = new Object[]{};
            }
        }
        int allCount = houseService.queryCount(objects);
        int allPages = page.getAllPages(allCount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allPages);

        List<MyHouse> list = houseService.queryAllRecordsDto(new HashMap(), MyHouse.class,objects);
        if(list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                MyHouse myHouse = list.get(i);
                MyHouse house = new MyHouse();
                house.setHid(myHouse.getHid());
                house.setSname(myHouse.getSname());
                house.setAname(myHouse.getAname());
                house.setHaddress(myHouse.getHaddress());
                house.setHfh(myHouse.getHfh());
                house.setHhx(myHouse.getHhx());
                house.setHmj(myHouse.getHmj());
                house.setHcx(myHouse.getHcx());
                house.setHmoney(myHouse.getHmoney());
                house.setHflag(myHouse.getHflag());
                house.setAllCount(allCount);
                house.setAllPages(allPages);
                house.setCurrent(current);
                house.setUp(up);
                house.setNext(next);
                resultList.add(house);
            }
        }

        listWriterToWeb(resp,resultList);
    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonStr = null;
        //          "house.sid":sid,
        //		  "house.aid":aid,        //		  "house.haddress":haddress,
        //		  "house.hfh":hfh,
        // 		  "house.hhx":hhx,
        //		  "house.hmj":hmj,
        // 		  "house.hcx":hcx,
        //		  "house.hmoney":hmoney,
        // 		  "house.hwf":hwf,
        //		  "house.hdx":hdx,
        // 		  "house.hsf":hsf,
        //		  "house.hmq":hmq,
        // 		  "house.dkd":dkd,
        //		  "house.skd":skd,
        // 		  "house.mkd":mkd,
        //		  "house.hjp":hjp,        //		  "house.hremark":hremark

        /**
         * INSERT INTO `dxfwcz`.`myhouse`
         * (`HID`, `SID`, `AID`, `HADDRESS`, `HFH`, `HHX`, `HMJ`, `HCX`,
         * `HMONEY`, `HWF`, `HDX`, `HSF`, `HMQ`, `DKD`, `SKD`, `MKD`,
         * `HJP`, `HREMARK`, `HIMG`, `HFLAG`)
         * VALUES (NULL, ?, ?, ?, ?, ?, ?, ?,
         * ?, ?, ?, ?, ?, ?, ?, ?,
         * ?'upload/1.jpg、upload/2.jpg、upload/3.jpg', '0', NULL);
         * */
        Map<Integer,Object> map = new HashMap<Integer, Object>();
        int i = 0;
        map.put(i++,req.getParameter("house.sid"));
        map.put(i++,req.getParameter("house.aid"));
        map.put(i++,req.getParameter("house.haddress"));
        map.put(i++,req.getParameter("house.hfh"));
        map.put(i++,req.getParameter("house.hhx"));
        map.put(i++,req.getParameter("house.hmj"));
        map.put(i++,req.getParameter("house.hcx"));
        map.put(i++,req.getParameter("house.hmoney"));
        map.put(i++,req.getParameter("house.hwf"));
        map.put(i++,req.getParameter("house.hdx"));
        map.put(i++,req.getParameter("house.hsf"));
        map.put(i++,req.getParameter("house.hmq"));
        map.put(i++,req.getParameter("house.dkd"));
        map.put(i++,req.getParameter("house.skd"));
        map.put(i++,req.getParameter("house.mkd"));
        map.put(i++,req.getParameter("house.hjp"));
        map.put(i,req.getParameter("house.hremark"));
        if (houseService.add(map)){
            jsonStr = "1";
        }else {
            jsonStr = "0";
        }
        responseAddRecords(resp,jsonStr);
    }

    public void aidNoZeroQuery(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        Map<String, Object> pageMap = initData(req);

        String aid = req.getParameter("aid");
        String sid = req.getParameter("sid");

        Object[] objects = null;

        if (NumberUtil.getInteger(sid) != 0){
            objects = new Object[]{aid,sid};
        }else {
            objects = new Object[]{aid};
        }


        List<MyHouse> list = houseService.queryAidNoZeroDto(pageMap, MyHouse.class, objects);

        for (int i = 0; i < list.size(); i++) {
            MyHouse myHouse = list.get(i);
            MyHouse house = new MyHouse();
            house.setHid(myHouse.getHid());
            house.setHaddress(myHouse.getHaddress());
            resultList.add(house);
        }

        listWriterToWeb(resp,resultList);

    }

    public void sidNoZeroQuery(HttpServletRequest req,HttpServletResponse resp) throws IOException {

        Map<String, Object> pageMap = initData(req);

        String aid = req.getParameter("aid");
        String sid = req.getParameter("sid");

        Object[] objects = null;

        if(NumberUtil.getInteger(aid) != 0){
            objects = new Object[]{aid,sid};
        }else {
            objects = new Object[]{sid};
        }

        List<MyHouse> list = houseService.querySidNoZeroDto(pageMap, MyHouse.class, objects);

        for (int i = 0; i < list.size(); i++) {
            MyHouse myHouse = list.get(i);
            MyHouse house = new MyHouse();
            house.setHid(myHouse.getHid());
            house.setHaddress(myHouse.getHaddress());
            resultList.add(house);
        }

        listWriterToWeb(resp,resultList);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp);
        resp.setContentType("text/html;charset=utf-8");
        invokeMethodForName(this.getClass(),req,resp);
    }
}
