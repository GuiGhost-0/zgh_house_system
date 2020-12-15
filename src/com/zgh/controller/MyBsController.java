package com.zgh.controller;

import com.zgh.entity.MyBs;
import com.zgh.service.impl.MyBsServiceImpl;
import com.zgh.utils.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/mybs")
public class MyBsController extends SystemBaseController{
    private MyBsServiceImpl bsService = new MyBsServiceImpl();
    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonStr = null;
        Map<String, Object> pageMap = initData(req);

        int allCount = bsService.queryRecordsCount();
        int allPages = page.getAllPages(allCount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<MyBs> list = bsService.queryAllRecordsDto(pageMap, MyBs.class, objects);
        if(list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                MyBs myBs = list.get(i);
                MyBs bs = new MyBs();
                bs.setBid(myBs.getBid());
                bs.setHaddress(myBs.getHaddress());
                bs.setHfh(myBs.getHfh());
                bs.setBremark(myBs.getBremark());
                bs.setMtime(myBs.getMtime());
                bs.setErealname(myBs.getErealname());
                bs.setAllCount(allCount);
                bs.setAllPages(allPages);
                bs.setCurrent(current);
                bs.setUp(up);
                bs.setNext(next);
                resultList.add(bs);
            }
        }
        listWriterToWeb(resp,resultList);
    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonStr = null;
        Map<Integer,Object> map = new HashMap<Integer, Object>();
        int i = 0;
        //mypart = "bs.hid="+hid+"&bs.bremark="+bremark + "&bs.eid=" + eid + "&methodName=add"
        //INSERT INTO `dxfwcz`.`mybs`
        // (`BID`, `HID`, `MTIME`, `BREMARK`, `EID`)
        // VALUES (NULL, ?, NOW(), ?, ?);
        map.put(i++,req.getParameter("bs.hid"));
        map.put(i++,req.getParameter("bs.bremark"));
        map.put(i,req.getParameter("bs.eid"));

        if(bsService.add(map)){
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
