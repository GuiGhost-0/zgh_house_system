package com.zgh.controller;

import com.zgh.entity.MyBiao;
import com.zgh.service.impl.MyBiaoServiceImpl;
import com.zgh.utils.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet("/mybiao")
public class MyBiaoController extends SystemBaseController{
    private MyBiaoServiceImpl biaoService = new MyBiaoServiceImpl();
    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, Object> pageMap = initData(req);

        int allCount = biaoService.queryRecordsCount();
        int allPages = page.getAllPages(allCount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<MyBiao> list = biaoService.queryAllRecordsDto(pageMap, MyBiao.class, objects);
        if (list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                MyBiao myBiao = list.get(i);
                MyBiao biao = new MyBiao();
                biao.setBid(myBiao.getBid());
                biao.setHaddress(myBiao.getHaddress());
                biao.setHfh(myBiao.getHfh());
                biao.setDkd(myBiao.getDkd());
                biao.setSkd(myBiao.getSkd());
                biao.setMkd(myBiao.getMkd());
                biao.setMtime(myBiao.getMtime());
                biao.setErealname(myBiao.getErealname());
                biao.setAllCount(allCount);
                biao.setAllPages(allPages);
                biao.setCurrent(current);
                biao.setUp(up);
                biao.setNext(next);
                resultList.add(biao);
            }
        }
        listWriterToWeb(resp,resultList);

    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonStr = null;

        //"biao.skd="+skd+"&biao.dkd="+dkd+
        // "&biao.mkd="+mkd+"&biao.hid="+hid +
        // "&eid=" + eid + "&methodName=add"
        Map<Integer,Object> map = new HashMap<Integer, Object>();
        //INSERT INTO `dxfwcz`.`mybiao`
        // (`BID`, `HID`, `DKD`, `SKD`, `MKD`, `MTIME`, `EID`)
        // VALUES (NULL, ?, ?, ?, ?, NOW(), ?);
        int i = 0;
        map.put(i++,req.getParameter("biao.hid"));
        map.put(i++,req.getParameter("biao.dkd"));
        map.put(i++,req.getParameter("biao.skd"));
        map.put(i++,req.getParameter("biao.mkd"));
        map.put(i,req.getParameter("eid"));

        if (biaoService.add(map)){
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
