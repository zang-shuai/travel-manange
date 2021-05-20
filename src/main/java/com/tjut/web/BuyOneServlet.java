package com.tjut.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjut.entity.BuyResult;
import com.tjut.entity.Orders;
import com.tjut.entity.Plan;
import com.tjut.entity.WorkTime;
import com.tjut.service.OrdersService;
import com.tjut.service.PlanService;
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

@WebServlet("/buyOneServlet")
public class BuyOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println("1++++++++++++++++++++++++++++++++++++++++++++");

        int rel = 0;
        OrdersService ordersService = new OrdersServiceImpl();
        PlanService planService = new PlanServiceImpl();

            /*
                购买结果
                1. 已经购买：购买失败
                2. 已经满员，购买失败
                3. 时间冲突，购买失败
                4. 购买成功
            */

        Integer pid = Integer.valueOf(request.getParameter("pid"));
        Integer uid = Integer.valueOf(request.getParameter("uid"));
        Integer sid = Integer.valueOf(request.getParameter("insurance"));
        System.out.println(pid);

        /*
        1. 查询相应计划
        2. 查询相应用户其他订单
        3. 判断计划是否满员
        4. 判断用户时间是否冲突
         */


        Plan plan = planService.findByPId(pid);
        List<Orders> userOrders = ordersService.findByUId(uid);
        boolean flag = false;
        Date pStartDate = plan.getPStartDate();
        Date pEndDate = plan.getPEndDate();
        Date today = new Date();
//        如果这个日期在Date参数之前返回一个小于0的值 ;  如果这个日期在Date参数之后返回一个大于0的值
        List<WorkTime> usersTime = ordersService.findUsersTime(uid);
        System.out.println("2++++++++++++++++++++++++++++++++++++++++++++");



        if (usersTime.size() == 0) {
            flag = true;
        } else if (DateUtils.compareDate(pEndDate, usersTime.get(0).getPstartdate())) {
            flag = true;
        } else if (DateUtils.compareDate(usersTime.get(usersTime.size() - 1).getPenddate(), pStartDate)) {
            flag = true;
        } else {
            for (int i = 0; i < usersTime.size() - 1; i++) {
                int p1 = usersTime.get(i).getPenddate().compareTo(pStartDate);//<0
                int p2 = usersTime.get(i + 1).getPstartdate().compareTo(pEndDate);//>0
                if (p1 < 0 && p2 > 0) {
                    flag = true;
                    break;
                }
            }
        }
        System.out.println("3++++++++++++++++++++++++++++++++++++++++++++");


        Integer pCount = plan.getPCount();
        if (pCount > plan.getPMaxCount()) {
            rel = 1;
//            buyResult.setWhy("抱歉，已经满员了，建议交换");
        } else if (!flag) {
            rel = 2;
//            buyResult.setWhy("该时间段内你还有其他旅游计划");
        } else {
            rel = 3;
            Orders orders = new Orders();
            orders.setSId(sid);
            orders.setUId(uid);
            orders.setPId(pid);
            orders.setOBuyDate(today);
            planService.plusOne(pid);
            ordersService.add(orders);
            System.out.println(orders);
        }
//        request.getRequestDispatcher("afterbuy.html"+"&rel="+rel).forward(request, response);
//        request.getDispatcherHeader(B.jsp").forward(request,response);
        response.sendRedirect("afterbuy.html"+"?rel="+rel);
//        System.out.println("可以执行重定向代码");
//        response.sendRedirect("afterbuy.html");
//        response.sendRedirect("index.html");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
