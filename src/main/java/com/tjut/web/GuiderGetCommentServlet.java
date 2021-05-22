package com.tjut.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjut.entity.Comment;
import com.tjut.entity.SelectComment;
import com.tjut.service.CommentService;
import com.tjut.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/guiderGetCommentServlet")
public class GuiderGetCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Integer pid = Integer.valueOf(request.getParameter("pid"));
        System.out.println(pid);
        CommentService commentService = new CommentServiceImpl();
        List<Comment> comments = commentService.findByPId(pid);
        System.out.println(comments);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(comments);
        response.getWriter().write(json);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
