package com.tjut.web;

import com.tjut.entity.Comment;
import com.tjut.entity.Orders;
import com.tjut.entity.Plan;
import com.tjut.entity.WorkTime;
import com.tjut.service.CommentService;
import com.tjut.service.OrdersService;
import com.tjut.service.PlanService;
import com.tjut.service.impl.CommentServiceImpl;
import com.tjut.service.impl.OrdersServiceImpl;
import com.tjut.service.impl.PlanServiceImpl;
import com.tjut.util.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@WebServlet("/commendServlet")
public class CommendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");


        Integer pid = Integer.valueOf(request.getParameter("pid"));
        Integer oid = Integer.valueOf(request.getParameter("oid"));
        Integer uid = Integer.valueOf(request.getParameter("uid"));
        Integer ctype = Integer.valueOf(request.getParameter("ctype"));
        String comment = request.getParameter("comment");

        OrdersService ordersService = new OrdersServiceImpl();
        PlanService planService = new PlanServiceImpl();
        CommentService commentService=new CommentServiceImpl();
        Comment c=new Comment();
        c.setPId(pid);
        c.setUId(uid);
        c.setContent(comment);
        c.setCType(ctype);

        commentService.add(c);




        response.sendRedirect("userdetails.html?"+"uid="+uid);


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
