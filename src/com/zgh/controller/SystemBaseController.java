package com.zgh.controller;

import com.zgh.common.Constants;
import com.zgh.utils.JacksonUtils;
import com.zgh.utils.PageUtils;
import com.zgh.utils.Pages;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class SystemBaseController extends HttpServlet {
    protected static final long serialVersionID = 1L;
    protected Pages page = new Pages();//创建一个分页的对象
    protected int current;//当前页
    protected int mypages = Constants.PAGE_SIZE_DEFAULT;//每页显示的记录数
    protected List resultList;//结果集
    protected String methodName;

    public abstract void query(HttpServletRequest req,HttpServletResponse resp) throws IOException;
    public abstract void add(HttpServletRequest req,HttpServletResponse resp) throws IOException;


    protected void invokeMethodForName(Class clazz,HttpServletRequest req,HttpServletResponse resp){
        try {
            methodName  = req.getParameter("methodName");
            if(methodName != null && methodName.length()>0){
                Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
                method.invoke(clazz.newInstance(),req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 重写doGet方法，默认调用doPost方法
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req,resp);
    }

    /**
     * 定义抽象方法doPost方法，方便继续重写
     */
    @Override
    protected abstract void doPost(HttpServletRequest req,
                                   HttpServletResponse resp)
            throws ServletException, IOException;

    protected void setAccessControlAllow(HttpServletResponse response){
        /*允许跨域的主机地址*/
        response.setHeader("Access-Control-Allow-Origin","*");
        /*允许跨域的请求方法GET、POST、HEAD等*/
        response.setHeader("Access-Control-Allow-Methods","*");
        /*重新预检验跨域的缓存时间*/
        response.setHeader("Access-Control-Max-Age","1800");
        /*允许跨域的请求头*/
        response.setHeader("Access-Control-Allow-Headers","*");
        /*是否携带cookie*/
        response.setHeader("Access-Control-Allow-Credentials","true");
    }

    protected Map<String,Object> initData(HttpServletRequest request){
        resultList = new ArrayList();
        Map<String,Object> pageMap = PageUtils.getPageParams(request);
        return pageMap;
    }

    protected void listWriterToWeb(HttpServletResponse response, List resultSet) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(JacksonUtils.obj2json(resultList));
    }

    protected void responseAddRecords(HttpServletResponse response,String jsonStr) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(JacksonUtils.obj2json(jsonStr));
    }
}
