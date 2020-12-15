package com.zgh.controller;

import com.zgh.entity.Customer;
import com.zgh.service.impl.CustomServiceImpl;
import com.zgh.utils.NumberUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/custom")
public class CustomController extends SystemBaseController{
    private CustomServiceImpl customService = new CustomServiceImpl();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp);
        invokeMethodForName(CustomController.class,req,resp);
    }

    public void query(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String jsonStr = null;
        Map<String, Object> pageMap = initData(req);

        int allCounts = customService.queryRecordsCount();
        int allPages = page.getAllPages(allCounts,mypages);
        current = NumberUtil.getIntegerValue(pageMap.get("currPage"),1);
        int up = page.getUp(current);
        int next = page.getNext(current,allPages);

        Object[] objects = new Object[]{};
        List<Customer> list = customService.queryAllRecordsDto(pageMap, Customer.class, objects);
        if(list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                Customer customer = list.get(i);
                Customer cus = new Customer();
                cus.setCid(customer.getCid());
                cus.setCname(customer.getCname());
                cus.setCsex(customer.getCsex());
                cus.setCtel(customer.getCtel());
                cus.setCtel1(customer.getCtel1());
                cus.setCcard(customer.getCcard());
                cus.setAllCount(allCounts);
                cus.setAllPages(allPages);
                cus.setCurrent(current);
                cus.setUp(up);
                cus.setNext(next);
                resultList.add(cus);
            }
        }

        listWriterToWeb(resp,resultList);
    }

    public void add(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String jsonStr = null;
        Customer customer = new Customer();
        customer.setCname(req.getParameter("cus.cname"));
        customer.setCsex( req.getParameter("cus.csex"));
        customer.setCtel( req.getParameter("cus.ctel"));
        customer.setCtel1(req.getParameter("cus.ctel1"));
        customer.setCcard(req.getParameter("cus.ccard"));


        if(customService.addCustom(customer)){
            jsonStr = "1";
        }else{
            jsonStr = "0";
        }

        responseAddRecords(resp,jsonStr);
    }
}
