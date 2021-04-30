package com.tjut.web;

import com.tjut.dao.VehicleService;
import com.tjut.entity.Tourist;
import com.tjut.entity.TouristImg;
import com.tjut.entity.Vehicle;
import com.tjut.service.impl.VehicleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addVehicleServlet")
public class AddVehicleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vehicle v = new Vehicle();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String vtype = request.getParameter("vtype");
        String vcapacity = request.getParameter("vcapacity");
        System.out.println(vtype);
        System.out.println(vcapacity);
        v.setVType(vtype);
        v.setVCapacity(Integer.valueOf(vcapacity));
        VehicleService vs = new VehicleServiceImpl();
        vs.add(v);

        response.sendRedirect("managevehicle.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
