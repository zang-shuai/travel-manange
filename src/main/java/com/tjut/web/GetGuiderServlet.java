package com.tjut.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjut.entity.Guider;
import com.tjut.service.GuiderService;
import com.tjut.service.impl.GuiderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getGuiderServlet")
public class GetGuiderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        /*
        获取用户的个人信息
        获取用户的所有订单
         */
        String gid = request.getParameter("gid");
        GuiderService guiderService = new GuiderServiceImpl();
        Guider guider = guiderService.findById(Integer.valueOf(gid));
        ObjectMapper mapper = new ObjectMapper();


        String json = mapper.writeValueAsString(guider);
        System.out.println(json);
        response.getWriter().write(json);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
