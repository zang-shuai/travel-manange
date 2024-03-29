package com.tjut.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjut.entity.Guider;
import com.tjut.entity.Plan;
import com.tjut.entity.Purchase;
import com.tjut.service.GuiderService;
import com.tjut.service.PlanService;
import com.tjut.service.impl.GuiderServiceImpl;
import com.tjut.service.impl.PlanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/purchaseOrderServlet")
public class PurchaseOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Integer pid = Integer.valueOf(request.getParameter("pid"));
        System.out.println(pid);



        PlanService planService=new PlanServiceImpl();
        Plan p = planService.findByPId(pid);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        response.getWriter().write(json);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
