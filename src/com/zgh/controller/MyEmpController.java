package com.zgh.controller;

import com.zgh.entity.MyEmp;
import com.zgh.entity.Myjs;
import com.zgh.service.impl.MyEmpServiceImpl;
import com.zgh.utils.JacksonUtils;
import com.zgh.utils.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet("/myemp")
public class MyEmpController extends SystemBaseController{
    private MyEmpServiceImpl empService = new MyEmpServiceImpl();

    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //定义json数据变量
        String jsonStr = null;
        Map<String,Object> pageMap = initData(req);
        //总记录数
        int allCount = empService.queryRecordsCount();
        int allPages = page.getAllPages(allCount,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<MyEmp> list = empService.queryAllRecordsDto(pageMap, MyEmp.class, objects);
        if(list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                MyEmp myEmp = list.get(i);
                MyEmp emp = new MyEmp();
                emp.setEid(myEmp.getEid());
                emp.setPname(myEmp.getPname());
                emp.setJname(myEmp.getJname());
                emp.setErealname(myEmp.getErealname());
                emp.setEname(myEmp.getEname());
                emp.setEtel(myEmp.getEtel());
                emp.setEaddress(myEmp.getEaddress());
                emp.setAllCount(allCount);
                emp.setAllPages(allPages);
                emp.setCurrent(current);
                emp.setUp(up);
                emp.setNext(next);
                resultList.add(emp);
            }
        }
        listWriterToWeb(resp,resultList);
    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //var mypart = "emp.myjs.jid=" + jid + "&emp.mydept.pid=" + pid+ "&emp.ename="+ename+
        // "&emp.epsw="+epsw+"&emp.erealname="+erealname+"&emp.etel="+etel+
        // "&emp.eaddress="+eaddress+"&emp.eremark="+eremark + "&methodName=add";
        String jsonStr = null;
        /**
         * INSERT INTO `dxfwcz`.`myemp`
         * (`EID`, `PID`, `JID`, `ENAME`, `EPSW`, `EREALNAME`, `ETEL`, `EADDRESS`, `EFLAG`, `EREMARK`)
         * VALUES (NULL, ?, 0, 'admin', 'admin', '赵本山', '13995668339', '武汉市洪山区120号', 0, '此人为系统管理员，不可删除');
         * */
        Map<Integer,Object> map = new HashMap<Integer, Object>();
        map.put(0,req.getParameter("emp.mydept.pid"));
        map.put(1,req.getParameter("emp.myjs.jid"));
        map.put(2,req.getParameter("emp.ename"));
        map.put(3,req.getParameter("emp.epsw"));
        map.put(4,req.getParameter("emp.erealname"));
        map.put(5,req.getParameter("emp.etel"));
        map.put(6,req.getParameter("emp.eaddress"));
        map.put(7,req.getParameter("emp.eremark"));
        if (empService.add(map)){
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
        setAccessControlAllow(resp);//跨域请求
        invokeMethodForName(this.getClass(),req,resp);
    }
}
