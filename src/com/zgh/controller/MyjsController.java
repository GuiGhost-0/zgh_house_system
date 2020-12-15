package com.zgh.controller;

import com.zgh.entity.Myjs;
import com.zgh.service.impl.MyjsServiceImpl;
import com.zgh.utils.JacksonUtils;
import com.zgh.utils.NumberUtil;
import com.zgh.utils.PageUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet("/myjs")
public class MyjsController extends SystemBaseController{
    private MyjsServiceImpl myjsService = new MyjsServiceImpl();

    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //定义json数据变量
        String jsonStr = null;
        Map<String,Object> pageMap = initData(req);
        //总记录数
        int allCount = myjsService.queryRecordsCount();
        int allPages = page.getAllPages(allCount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<Myjs> myjsList = myjsService.queryAllRecordsDto(pageMap,Myjs.class,objects);
        for (int i = 0; i < myjsList.size(); i++) {
            Myjs myjs = myjsList.get(i);
            Myjs dto  = new Myjs();
            dto.setJid(myjs.getJid());
            dto.setJname(myjs.getJname());
            dto.setAllCount(allCount);
            dto.setAllPages(allPages);
            dto.setCurrent(current);
            dto.setNext(next);
            dto.setUp(up);
            resultList.add(dto);
        }
        listWriterToWeb(resp,resultList);
    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonStr = null;
        Map<Integer,Object> map = new HashMap<Integer, Object>();
        map.put(0,req.getParameter("js.jname"));
        if (myjsService.add(map)){
            jsonStr = "1";
        }else{
            jsonStr = "0";
        }
        responseAddRecords(resp,jsonStr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp);//跨域请求
        invokeMethodForName(this.getClass(),req,resp);
    }
}
