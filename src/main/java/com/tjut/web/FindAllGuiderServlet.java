package com.tjut.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjut.entity.Guider;
import com.tjut.entity.Tourist;
import com.tjut.service.GuiderService;
import com.tjut.service.TouristService;
import com.tjut.service.impl.GuiderServiceImpl;
import com.tjut.service.impl.TouristServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllGuiderServlet")
public class FindAllGuiderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");


        GuiderService guiderService=new GuiderServiceImpl();
        List<Guider> all = guiderService.findAll();


        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(all);
        System.out.println(json);
        response.getWriter().write(json);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
