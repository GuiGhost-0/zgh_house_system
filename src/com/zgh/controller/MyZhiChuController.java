package com.zgh.controller;

import com.zgh.entity.MyZhiChu;
import com.zgh.service.impl.MyZhiChuServiceImpl;
import com.zgh.utils.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 支出表的控制器类Controller
 * */
@WebServlet("/myzhichu")
public class MyZhiChuController extends SystemBaseController{
    private MyZhiChuServiceImpl zhiChuService = new MyZhiChuServiceImpl();
    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, Object> pageMap = initData(req);

        int allCount = zhiChuService.queryRecordsCount();
        int allPages = page.getAllPages(allCount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<MyZhiChu> list = zhiChuService.queryAllRecordsDto(pageMap, MyZhiChu.class, objects);
        if(list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                MyZhiChu myZhiChu = list.get(i);
                MyZhiChu zhiChu = new MyZhiChu();
                zhiChu.setZid(myZhiChu.getZid());
                zhiChu.setZmoney(myZhiChu.getZmoney());
                zhiChu.setZtm(myZhiChu.getZtm());
                zhiChu.setZtime(myZhiChu.getZtime());
                zhiChu.setZremark(myZhiChu.getZremark());
                zhiChu.setErealname(myZhiChu.getErealname());
                zhiChu.setAllCount(allCount);
                zhiChu.setAllPages(allPages);
                zhiChu.setCurrent(current);
                zhiChu.setUp(up);
                zhiChu.setNext(next);
                resultList.add(zhiChu);
            }
        }
        listWriterToWeb(resp,resultList);
    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonStr = null;
        Map<Integer,Object> map = new HashMap<Integer, Object>();
        int i = 0;
        //mypart = "zc.zmoney="+zmoney+
        //"&zc.ztm="+ztm+"&zc.zremark="+zremark +
        //"&zc.eid=" + eid + "&methodName=add"

        //INSERT INTO `dxfwcz`.`myzhichu`" +
        //"(`ZID`, `EID`, `ZMONEY`, `ZTM`, `ZTIME`, `ZREMARK`) " +
        //"VALUES (NULL, ?, ?, ?, now(), ?)
        map.put(i++,req.getParameter("zc.eid"));
        map.put(i++,req.getParameter("zc.zmoney"));
        map.put(i++,req.getParameter("zc.ztm"));
        map.put(i,req.getParameter("zc.zremark"));

        if (zhiChuService.add(map)){
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
