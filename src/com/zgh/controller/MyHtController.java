package com.zgh.controller;

import com.zgh.entity.MyHt;
import com.zgh.service.impl.MyHtServiceImpl;
import com.zgh.utils.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet("/myht")
public class MyHtController extends SystemBaseController{
    private MyHtServiceImpl htService = new MyHtServiceImpl();
    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, Object> pageMap = initData(req);

        int allCount = htService.queryRecordsCount();
        int allPages = page.getAllPages(allCount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allPages);

        List<MyHt> list = htService.queryAllRecordsDto(pageMap, MyHt.class);

        if (list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                MyHt myHt = list.get(i);
                MyHt ht = new MyHt();
                ht.setHtid(myHt.getHtid());
                ht.setHtname(myHt.getHtname());
                ht.setHtremark(myHt.getHtremark());
                ht.setAllCount(allCount);
                ht.setAllPages(allPages);
                ht.setCurrent(current);
                ht.setUp(up);
                ht.setNext(next);
                resultList.add(ht);
            }
        }
        listWriterToWeb(resp,resultList);
    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonStr = null;

        //var mypart = "ht.hrname=" + hname + "&ht.hremark=" + hremark + "&methodName=add";

        Map<Integer,Object> map = new HashMap<Integer, Object>();
        int i = 0;
        map.put(i++,req.getParameter("ht.hrname"));
        map.put(i,req.getParameter("ht.hremark"));
        if (htService.add(map)){
            jsonStr = "1";
        }else {
            jsonStr = "0";
        }
        responseAddRecords(resp,jsonStr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp);
        invokeMethodForName(this.getClass(),req,resp);
    }
}
