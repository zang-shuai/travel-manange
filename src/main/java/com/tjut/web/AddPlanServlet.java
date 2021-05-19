package com.tjut.web;

import com.tjut.entity.Plan;
import com.tjut.util.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addPlanServlet")
public class AddPlanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Plan plan=new Plan();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        Integer tourist = Integer.valueOf(request.getParameter("tourist"));
        Float pprice = Float.valueOf(request.getParameter("pprice"));
        Integer pmaxcount = Integer.valueOf(request.getParameter("pmaxcount"));
        String pstartdate =request.getParameter("pstartdate");
        String penddate = request.getParameter("penddate");
        Integer guider = Integer.valueOf(request.getParameter("guider"));
        String vehicle = request.getParameter("vehicle");

        plan.setTId(tourist);
        plan.setGId(guider);
        plan.setPCount(0);
        plan.setPMaxCount(pmaxcount);
        plan.setPStartDate(DateUtils.string2Date(pstartdate));
        plan.setPEndDate(DateUtils.string2Date(penddate));
        plan.setPPrice(pprice);





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
