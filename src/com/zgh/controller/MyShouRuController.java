package com.zgh.controller;

import com.zgh.entity.MyShouRu;
import com.zgh.service.impl.MyShouRuServiceImpl;
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
 * 收入表控制器controller
 * */
@WebServlet("/myshouru")
public class MyShouRuController extends SystemBaseController{
    private MyShouRuServiceImpl service = new MyShouRuServiceImpl();
    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, Object> pageMap = initData(req);

        int allCount = service.queryRecordsCount();
        int allPages = page.getAllPages(allCount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<MyShouRu> list = service.queryAllRecordsDto(pageMap, MyShouRu.class, objects);
        if (list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                MyShouRu myShouRu = list.get(i);
                MyShouRu shouRu = new MyShouRu();
                shouRu.setSid(myShouRu.getSid());
                shouRu.setSmoney(myShouRu.getSmoney());
                shouRu.setStm(myShouRu.getStm());
                shouRu.setSremark(myShouRu.getSremark());
                shouRu.setStime(myShouRu.getStime());
                shouRu.setErealname(myShouRu.getErealname());
                shouRu.setAllCount(allCount);
                shouRu.setAllPages(allPages);
                shouRu.setCurrent(current);
                shouRu.setUp(up);
                shouRu.setNext(next);
                resultList.add(shouRu);
            }
        }
        listWriterToWeb(resp,resultList);
    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonStr = null;

        Map<Integer,Object> map = new HashMap<Integer, Object>();

        //mypart = "sr.smoney=" + smoney +
        // "&sr.stm="+stm+"&sr.sremark="+sremark +
        // "&sr.eid=" + eid + "&methodName=add"

        //INSERT INTO `dxfwcz`.`myshouru`
        //(`SID`, `EID`, `SMONEY`, `STM`, `STIME`, `SREMARK`)
        //VALUES (NULL, ?, ?, ?, now(), ?);

        int i = 0;
        map.put(i++,req.getParameter("sr.eid"));
        map.put(i++,req.getParameter("sr.smoney"));
        map.put(i++,req.getParameter("sr.stm"));
        map.put(i,req.getParameter("sr.sremark"));

        if (service.add(map)){
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
