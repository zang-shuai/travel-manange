package com.tjut.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjut.entity.Plan;
import com.tjut.service.GuiderService;
import com.tjut.service.PlanService;
import com.tjut.service.TouristService;
import com.tjut.service.UserService;
import com.tjut.service.impl.GuiderServiceImpl;
import com.tjut.service.impl.PlanServiceImpl;
import com.tjut.service.impl.TouristServiceImpl;
import com.tjut.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllPlanServlet")
public class FindAllPlanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        
        
        
        
        PlanService planService=new PlanServiceImpl();
        GuiderService guiderService=new GuiderServiceImpl();
        TouristService touristService=new TouristServiceImpl();

        List<Plan> all = planService.findAll();
        for(Plan p:all){
//            System.out.println(p.getGId()+"--"+guiderService.getNameById(p.getGId()));
//            System.out.println(p.getTId());
            p.setGName(guiderService.getNameById(p.getGId()));
            p.setTName(touristService.getNameById(p.getTId()));
        }


        System.out.println(all);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(all);
        System.out.println(json);
        response.getWriter().write(json);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
