package com.zgh.controller;

import com.zgh.entity.User;
import com.zgh.service.impl.UserLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/updatePsw")
public class UpdatePswController extends SystemBaseController{

    private UserLoginServiceImpl loginService = new UserLoginServiceImpl();
    @Override
    public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

    @Override
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlAllow(resp);
        invokeMethodForName(this.getClass(),req,resp);
    }

    public void checkOldPsw(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String jsonStr = null;
        String uid = req.getParameter("uid");
        Object[] objects = new Object[]{uid};
        User user = loginService.queryAllById(new HashMap(), User.class, objects);
        jsonStr = user.getEpsw();
        responseAddRecords(resp,jsonStr);
    }

    public void updatePsw(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String jsonStr = null;
        //psw:newpsw,eid:uid,methodName:"updatePsw"
        String psw = req.getParameter("psw");
        String eid = req.getParameter("eid");
//        "UPDATE `dxfwcz`.`myemp` SET  `EPSW` = ? WHERE `EID` = ?";
        Map<Integer,Object> map = new HashMap<Integer, Object>();
        map.put(0,psw);
        map.put(1,eid);
        if(loginService.update(map)){
            jsonStr = "1";
        }else {
            jsonStr = "0";
        }
        responseAddRecords(resp,jsonStr);
    }
}
