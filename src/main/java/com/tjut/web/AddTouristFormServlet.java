package com.tjut.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjut.entity.Guider;
import com.tjut.entity.Tourist;
import com.tjut.entity.TouristImg;
import com.tjut.entity.User;
import com.tjut.service.TouristService;
import com.tjut.service.UserService;
import com.tjut.service.impl.GuiderServiceImpl;
import com.tjut.service.impl.TouristServiceImpl;
import com.tjut.service.impl.UserServiceImpl;
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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addTouristFormServlet")
public class AddTouristFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Tourist tourist = new Tourist();
        List<TouristImg> touristImgs = new ArrayList<>();

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");


        //1、创建一个DiskFileItemFactory工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2、创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解决上传文件名的中文乱码//
        String path = request.getSession().getServletContext().getRealPath("/") + "img\\";
        upload.setHeaderEncoding("UTF-8");
        factory.setSizeThreshold(1024 * 500);//设置内存的临界值为500K
        File linshi = new File(path);//当超过500K的时候，存到一个临时文件夹中
        factory.setRepository(linshi);
        upload.setSizeMax(1024 * 1024 * 500);//设置上传的文件总的大小不能超过500M
        String touristName = "";
        try {
            // 1. 得到 FileItem 的集合 items
            List<FileItem> items = upload.parseRequest(request);
            File file;
            String imgDir = "";
            // 2. 遍历 items:
            String absolutePath = "C:\\Users\\zs\\Desktop\\travel\\travelManager\\src\\main\\webapp\\img\\tourist\\";
            for (FileItem item : items) {
                switch (item.getFieldName()) {
                    case "tname" -> {
                        touristName = item.getString("utf-8");
                        tourist.setTName(touristName);
                        imgDir = touristName + System.currentTimeMillis();
                        tourist.setTIdSecond(imgDir);
                        file = new File(absolutePath + imgDir);
                        if (!file.exists()) {//如果文件夹不存在
                            file.mkdir();//创建文件夹
                        }
                        File f = new File(path + "tourist\\" + imgDir);
                        if (!f.exists()) {//如果文件夹不存在
                            f.mkdir();//创建文件夹
                        }

                    }
                    case "timage" -> {
                        long l = System.currentTimeMillis();
                        String fileName = l + item.getName();
                        WriteImgUtils.write(item, absolutePath + imgDir + "\\" + fileName);
                        WriteImgUtils.write(item, path + "tourist\\" + imgDir + "\\" + fileName);
                        System.out.println("上传完成");
                        TouristImg touristImg = new TouristImg();
                        touristImg.setTAddress("img/tourist/" + imgDir + "/" + fileName);
                        touristImgs.add(touristImg);
                    }
                    case "tintroduce" -> tourist.setTIntroduce(item.getString("utf-8"));
                    case "tprice" -> tourist.setTPrice(Float.valueOf(item.getString("utf-8")));
                }
            }
            tourist.setTouristImg(touristImgs);
            TouristService touristService = new TouristServiceImpl();
            touristService.addTourist(tourist);

            response.sendRedirect("managetourist.html");
        } catch (FileUploadException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
