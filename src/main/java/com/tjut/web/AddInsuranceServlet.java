package com.tjut.web;

import com.tjut.entity.Insurance;
import com.tjut.service.InsuranceService;
import com.tjut.service.impl.InsuranceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addInsuranceServlet")
public class AddInsuranceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Insurance insurance = new Insurance();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        Float sprice = Float.valueOf(request.getParameter("sprice"));
        String sname = request.getParameter("sname");

        insurance.setSName(sname);
        insurance.setSPrice(sprice);

        InsuranceService vs = new InsuranceServiceImpl();
        vs.add(insurance);

        response.sendRedirect("manageinsurance.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
