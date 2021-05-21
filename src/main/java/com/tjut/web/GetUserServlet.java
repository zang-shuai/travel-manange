package com.tjut.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjut.entity.Orders;
import com.tjut.entity.Plan;
import com.tjut.entity.User;
import com.tjut.service.*;
import com.tjut.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getUserServlet")
public class GetUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        /*
        获取用户的个人信息
        获取用户的所有订单
         */
        String uid = request.getParameter("uid");
        UserService userService = new UserServiceImpl();
        User user = userService.findById(Integer.valueOf(uid));
        ObjectMapper mapper = new ObjectMapper();


        String json = mapper.writeValueAsString(user);
        System.out.println(json);
        response.getWriter().write(json);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
