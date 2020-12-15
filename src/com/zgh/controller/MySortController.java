package com.zgh.controller;

import com.zgh.entity.MySort;
import com.zgh.entity.Myjs;
import com.zgh.service.impl.MySortServiceImpl;
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
@WebServlet("/mysort")
public class MySortController extends SystemBaseController{
    private MySortServiceImpl sortService = new MySortServiceImpl();

    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, Object> pageMap = initData(req);

        int allCount = sortService.queryRecordsCount();
        int allPages = page.getAllPages(allCount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<MySort> list = sortService.queryAllRecordsDto(pageMap, MySort.class, objects);
        if(list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                MySort mySort = list.get(i);
                MySort sort = new MySort();
                sort.setSid(mySort.getSid());
                sort.setSname(mySort.getSname());
                sort.setAllCount(allCount);
                sort.setAllPages(allPages);
                sort.setCurrent(current);
                sort.setUp(up);
                sort.setNext(next);
                resultList.add(sort);
            }
        }

        listWriterToWeb(resp,resultList);
    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonStr = null;
        //var mypart = "sort.sname=" + sname +  "&methodName=add";
//        INSERT INTO `dxfwcz`.`mysort`(`SID`, `SNAME`) VALUES (NULL, '标准住宅');
        Map<Integer,Object> map = new HashMap<Integer, Object>();
        map.put(0,req.getParameter("sort.sname"));
        if (sortService.add(map)){
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
