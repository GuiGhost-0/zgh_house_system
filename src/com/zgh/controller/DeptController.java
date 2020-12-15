package com.zgh.controller;

import com.zgh.entity.Dept;
import com.zgh.service.impl.DeptServiceImpl;
import com.zgh.utils.JacksonUtils;
import com.zgh.utils.NumberUtil;
import com.zgh.utils.PageUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/dept")
public class DeptController extends SystemBaseController{
    private DeptServiceImpl deptService = new DeptServiceImpl();



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp);
        invokeMethodForName(this.getClass(),req,resp);
    }

    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //定义json数据变量
        String jsonStr = null;
        resultList = new ArrayList();
        Map<String,Object> pageMap = PageUtils.getPageParams(req);
        //总记录数
        int allCounts = deptService.queryRecordsTotal();
        int allPages = page.getAllPages(allCounts,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<Dept> depts = deptService.queryRecordsListDto(pageMap, objects);
        for (int i = 0; i < depts.size(); i++) {
            Dept dept = depts.get(i);
            Dept dto = new Dept();
            dto.setPid(dept.getPid());
            dto.setPname(dept.getPname());
            dto.setPflag(dept.getPflag());
            dto.setPremark(dept.getPremark());
            dto.setAllCount(allCounts);
            dto.setAllPages(allPages);
            dto.setCurrent(current);
            dto.setUp(up);
            dto.setNext(next);
            resultList.add(dto);
        }

        listWriterToWeb(resp,resultList);
    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String jsonStr = null;
        //"dept.pname=" + pname + "&dept.premark=" + premark+ "methodName=add";

        Dept dept = new Dept();
        dept.setPname(req.getParameter("dept.pname"));
        dept.setPremark(req.getParameter("dept.premark"));


        if(deptService.add(dept)){
            jsonStr = "1";
        }else{
            jsonStr = "0";
        }

        responseAddRecords(resp,jsonStr);
    }

}
