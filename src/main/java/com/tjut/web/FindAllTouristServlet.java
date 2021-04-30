package com.tjut.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjut.entity.Tourist;
import com.tjut.entity.User;
import com.tjut.service.TouristService;
import com.tjut.service.UserService;
import com.tjut.service.impl.TouristServiceImpl;
import com.tjut.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllTouristServlet")
public class FindAllTouristServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        TouristService touristService=new TouristServiceImpl();
        List<Tourist> all = touristService.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(all);
        System.out.println(json);
        response.getWriter().write(json);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
