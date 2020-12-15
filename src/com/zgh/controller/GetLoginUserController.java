package com.zgh.controller;

import com.zgh.entity.User;
import com.zgh.utils.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/getLoginUser")
public class GetLoginUserController extends SystemBaseController{
    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp);
        User user = (User) req.getSession().getAttribute("loginUser");
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(JacksonUtils.obj2json(user));
    }
}
