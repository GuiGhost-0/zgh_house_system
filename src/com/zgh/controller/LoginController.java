package com.zgh.controller;

import com.zgh.entity.User;
import com.zgh.service.impl.UserLoginServiceImpl;
import com.zgh.utils.JacksonUtils;
import com.zgh.utils.NumberUtil;
import com.zgh.utils.SystemStringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/login")
public class LoginController extends SystemBaseController {
    private UserLoginServiceImpl loginService = new UserLoginServiceImpl();

    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp);
        String jsonStr = null;

        String name = req.getParameter("name");
        String psw = req.getParameter("psw");
        if (SystemStringUtils.isEmpty(name) || SystemStringUtils.isEmpty(psw)){
            jsonStr = "0";
            responseAddRecords(resp,jsonStr);
        }else {
            Object[] objects = new Object[]{name,psw};
            List<User> list = loginService.queryAllRecordsDto(new HashMap(), User.class,objects);
            if(list!=null && !list.isEmpty()){
                User user = list.get(0);
                String uid = String.valueOf(user.getEid());
                Cookie loginCookie = new Cookie("loginCookie", uid);
                jsonStr = uid;
                loginCookie.setPath("/");//这个值要设置，所有的
                loginCookie.setDomain("guigui.com");//设置为guigui.com域名下的项目共同使用
                loginCookie.setMaxAge(30*60*60);
                resp.addCookie(loginCookie);
            }else{
                jsonStr = "0";
            }
            responseAddRecords(resp,jsonStr);
        }






    }
}
