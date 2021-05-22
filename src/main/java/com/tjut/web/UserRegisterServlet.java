package com.tjut.web;

import com.tjut.entity.User;
import com.tjut.service.UserService;
import com.tjut.service.impl.UserServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/userRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //1、创建一个DiskFileItemFactory工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2、创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解决上传文件名的中文乱码//
        String path = request.getSession().getServletContext().getRealPath("/") + "img\\person\\";
        upload.setHeaderEncoding("UTF-8");
        factory.setSizeThreshold(1024 * 500);//设置内存的临界值为500K
        File linshi = new File(path);//当超过500K的时候，存到一个临时文件夹中
        factory.setRepository(linshi);
        upload.setSizeMax(1024 * 1024 * 500);//设置上传的文件总的大小不能超过500M
        try {
            // 1. 得到 FileItem 的集合 items
            List<FileItem> items = upload.parseRequest(request);
            // 2. 遍历 items:
            for (FileItem item : items) {
                // 若是一个一般的表单域, 打印信息
                switch (item.getFieldName()) {
                    case "utelephonenumber" -> user.setUTelephonenumber(item.getString("utf-8"));
                    case "upassword" -> user.setUPassword(item.getString("utf-8"));
                    case "uhead" -> {
                        String fileName = item.getName();
                        String absolutePath = "C:\\Users\\zs\\Desktop\\travel\\travelManager\\src\\main\\webapp\\img\\person\\";
                        write(item, absolutePath + fileName);
                        write(item, path + fileName);
                        System.out.println("上传完成");
                        user.setUHead("img/person/" + item.getName());
                    }
                    case "uname" -> user.setUName(item.getString("utf-8"));
                    case "uage" -> user.setUAge(Integer.parseInt(item.getString("utf-8")));
                    case "upower" -> user.setUPower(Integer.parseInt(item.getString("utf-8")));
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        UserService userService = new UserServiceImpl();
        try{
            userService.addUser(user);
            response.sendRedirect("index.html");
        }catch (Exception e){
            response.sendRedirect("usserregister.html?rel=0");
        }
    }

    private void write(FileItem item, String fileName) throws IOException {
        long sizeInBytes = item.getSize();
        int len;
        InputStream in = item.getInputStream();
        OutputStream out = new FileOutputStream(fileName);
        byte[] buffer = new byte[Math.toIntExact(sizeInBytes)];
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        out.close();
        in.close();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
