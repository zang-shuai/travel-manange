package com.tjut.web;

import com.tjut.entity.User;
import com.tjut.service.UserService;
import com.tjut.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        UserService userService = new UserServiceImpl();
        User user = userService.findUserByTelephoneNumber(request.getParameter("utelephonenumber"));
        if (user != null && user.getUPassword().equals(request.getParameter("upassword"))) {
            HttpSession session = request.getSession();

            session.setAttribute("user", user);




            Cookie cookie = new Cookie("user", user.getUName());
            cookie.setMaxAge(-1);
            response.addCookie(cookie);


            Cookie cookie1 = new Cookie("uid", user.getUId().toString());
            cookie1.setMaxAge(-1);
            response.addCookie(cookie1);


            response.sendRedirect("index.html");
        } else {
            response.sendRedirect(request.getHeader("Referer"));
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
