package com.tjut.web;

import com.tjut.entity.Guider;
import com.tjut.service.GuiderService;
import com.tjut.service.impl.GuiderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/guiderLoginServlet")
public class GuiderLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        GuiderService guiderService =  new GuiderServiceImpl();
        Guider guider = guiderService.findByTelephoneNumber(request.getParameter("gtelephonenumber"));
        if (guider != null && guider.getGPassword().equals(request.getParameter("gpassword"))) {
//            HttpSession session = request.getSession();
//            session.setAttribute("guider", guider);
//            Cookie cookie = new Cookie("guider", guider.getGName());
//            cookie.setMaxAge(-1);
//            response.addCookie(cookie);
            response.sendRedirect("guider.html?gid="+guider.getGId());
        } else {
            System.out.println("cw");
            response.sendRedirect(request.getHeader("guider.html"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
