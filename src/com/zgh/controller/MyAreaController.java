package com.zgh.controller;

import com.fasterxml.jackson.databind.node.NullNode;
import com.zgh.entity.MyArea;
import com.zgh.service.impl.MyAreaServiceImpl;
import com.zgh.utils.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet("/myarea")
public class MyAreaController extends SystemBaseController{
    private MyAreaServiceImpl areaService = new MyAreaServiceImpl();

    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, Object> pageMap = initData(req);

        int allCount = areaService.queryRecordsCount();
        int allPages = page.getAllPages(allCount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<MyArea> list = areaService.queryAllRecordsDto(pageMap, MyArea.class, objects);
        if(list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                MyArea myArea = list.get(i);
                MyArea area = new MyArea();
                area.setAid(myArea.getAid());
                area.setAname(myArea.getAname());
                area.setAllCount(allCount);
                area.setAllPages(allPages);
                area.setCurrent(current);
                area.setUp(up);
                area.setNext(next);
                resultList.add(area);
            }
        }
        listWriterToWeb(resp,resultList);
    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonStr = null;
        //var mypart = "area.aname=" + aname +  "&methodName=add";
        Map<Integer,Object> map = new HashMap<Integer, Object>();
        map.put(0,req.getParameter("area.aname"));
        if(areaService.add(map)){
            jsonStr = "1";
        }else {
            jsonStr = "0";
        }

        responseAddRecords(resp,jsonStr);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp);
        invokeMethodForName(this.getClass(),req,resp);
    }
}
