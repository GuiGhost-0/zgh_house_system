package com.zgh.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/backout")
public class BackOut extends SystemBaseController{
    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

    public void backOut(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        setAccessControlAllow(resp);
        String jsonStr = null;
        Cookie[] cookies = req.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            System.out.println("cookieName=" + cookies[i].getName() + ",cookieValue=" + cookies[i].getValue());
        }
        if (cookies.length >0){
            jsonStr = "1";
        }else {
            jsonStr = "0";
        }
        responseAddRecords(resp,jsonStr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        /*允许跨域的主机地址*/
        resp.setHeader("Access-Control-Allow-Origin","guigui.com");
        /*允许跨域的请求方法GET、POST、HEAD等*/
        resp.setHeader("Access-Control-Allow-Methods","*");
        /*重新预检验跨域的缓存时间*/
        resp.setHeader("Access-Control-Max-Age","1800");
        /*允许跨域的请求头*/
        resp.setHeader("Access-Control-Allow-Headers","*");
        /*是否携带cookie*/
        resp.setHeader("Access-Control-Allow-Credentials","true");
        String jsonStr = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            for (int i = 0; i < cookies.length; i++) {
                System.out.println("cookieName=" + cookies[i].getName() + ",cookieValue=" + cookies[i].getValue());
            }
        }else {
            System.out.println("cookie=null");
        }

        if (cookies != null &&cookies.length >0){
            jsonStr = "1";
        }else {
            jsonStr = "0";
        }
        responseAddRecords(resp,jsonStr);
    }
}
