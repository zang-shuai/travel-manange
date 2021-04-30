package com.tjut.web;

import com.tjut.service.GuiderService;
import com.tjut.entity.Guider;
import com.tjut.service.impl.GuiderServiceImpl;
import com.tjut.util.WriteImgUtils;
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

@WebServlet("/addGuiderServlet")
public class AddGuiderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Guider guider = new Guider();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        long l = System.currentTimeMillis();
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
                    case "gtelephonenumber" -> guider.setGTelephonenumber(item.getString("utf-8"));
                    case "gpassword" -> guider.setGPassword(item.getString("utf-8"));
                    case "ghead" -> {
                        String fileName = item.getName();
                        String absolutePath = "C:\\Users\\zs\\Desktop\\travel\\travelManager\\src\\main\\webapp\\img\\person\\";
                        WriteImgUtils.write(item, absolutePath +l+ fileName);
                        System.out.println(path+l +fileName);
                        WriteImgUtils.write(item, path +l + fileName);
                        System.out.println("上传完成");
                        guider.setGHead("img/person/" +l +item.getName());
                    }
                    case "gname" -> guider.setGName(item.getString("utf-8"));
                    case "gintroduce" -> guider.setGIntroduce(item.getString("utf-8"));
                    case "gage" -> guider.setGAge(Integer.parseInt(item.getString("utf-8")));
                }
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        GuiderService guiderService = new GuiderServiceImpl();
        guiderService.add(guider);
        response.sendRedirect("manageguider.html");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
