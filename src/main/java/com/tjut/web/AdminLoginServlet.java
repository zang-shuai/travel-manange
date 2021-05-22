package com.tjut.web;

import com.tjut.entity.Guider;
import com.tjut.entity.User;
import com.tjut.service.GuiderService;
import com.tjut.service.UserService;
import com.tjut.service.impl.GuiderServiceImpl;
import com.tjut.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        UserService userService = new UserServiceImpl();
        User user = userService.findUserByTelephoneNumber(request.getParameter("utelephonenumber"));
        System.out.println(user);
        if (user != null && user.getUPassword().equals(request.getParameter("upassword"))&&user.getUPower()==0) {
            response.sendRedirect("admin.html");
        } else {
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
