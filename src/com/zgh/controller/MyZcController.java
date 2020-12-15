package com.zgh.controller;

import com.zgh.entity.MyZc;
import com.zgh.service.impl.MyZcServiceImpl;
import com.zgh.utils.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet("/myzc")
public class MyZcController extends SystemBaseController{
    private MyZcServiceImpl zcService = new MyZcServiceImpl();
    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, Object> pageMap = initData(req);

        int allCount = zcService.queryRecordsCount();
        int allPages = page.getAllPages(allCount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allPages);

        List<MyZc> list = zcService.queryAllRecordsDto(pageMap, MyZc.class);
        if (list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                MyZc myZc = list.get(i);
                MyZc zc = new MyZc();
                zc.setCid(myZc.getCid());
                zc.setCtitle(myZc.getCtitle());
                zc.setCtime(myZc.getCtime());
                zc.setCremark(myZc.getCremark());
                zc.setAllCount(allCount);
                zc.setAllPages(allPages);
                zc.setCurrent(current);
                zc.setUp(up);
                zc.setNext(next);
                resultList.add(zc);
            }
        }

        listWriterToWeb(resp,resultList);
    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonStr = null;

        //mypart = "zc.ctitle=" + ctitle + "&zc.remark=" + cremark+ "&methodName=add"
        //INSERT INTO `dxfwcz`.`myzc`(`CID`, `CTITLE`, `CTIME`, `CREMARK`) " +
        //                "VALUES (NULL, ?, NOW(), ?)
        Map<Integer,Object> map = new HashMap<Integer, Object>();
        int i = 0;
        map.put(i++,req.getParameter("zc.ctitle"));
        map.put(i,req.getParameter("zc.remark"));

        if (zcService.add(map)){
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
