package com.tjut.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjut.entity.Orders;
import com.tjut.entity.User;
import com.tjut.service.OrdersService;
import com.tjut.service.UserService;
import com.tjut.service.impl.OrdersServiceImpl;
import com.tjut.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getUserOrdersServlet")
public class GetUserOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        /*
        获取用户的个人信息
        获取用户的所有订单
         */
        String uid = request.getParameter("uid");
        OrdersService ordersService = new OrdersServiceImpl();
        List<Orders> orders = ordersService.findByUId(Integer.valueOf(uid));
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(orders);
        System.out.println(json);
        response.getWriter().write(json);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
