package com.tjut.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjut.entity.WorkTime;
import com.tjut.entity.WorkTimeTable;
import com.tjut.service.PlanService;
import com.tjut.service.impl.PlanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/findFreeGuiderServlet")
public class FindFreeGuiderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 查找所有计划
         * 找到所有计划时间和导游
         * 找到所有导游及他们的工作时间
         * */


//        Date startTime = new Date();
//        Date endTime = new Date();
//        startTime.setTime(Long.parseLong(request.getParameter("startTime")));
//        endTime.setTime(Long.parseLong(request.getParameter("endTime")));
        PlanService planService = new PlanServiceImpl();
        List<WorkTimeTable> allGuidersWorkTime = planService.getAllGuidersWorkTime();
//        System.out.println(allGuidersWorkTime);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(allGuidersWorkTime);
        System.out.println(json);
        response.getWriter().write(json);
//        for (WorkTimeTable ws : allGuidersWorkTime) {
//            List<WorkTime> l = ws.getL();
//            List<Date> times = new ArrayList<>();
//            Date now = new Date();
//            times.add(now);
//            for (WorkTime t : l) {
//                times.add(t.getStart());
//                times.add(t.getEnd());
//            }
//            times.add(getMonthDate(now, 1));
//            boolean flag = false;
//            for (int i = 0; i < times.size() - 1; i++) {
//                if (times.get(i).compareTo(startTime) > 0 && times.get(i + 1).compareTo(endTime) < 0 && ((i & 1) == 0)) {
//                    flag = true;
//                    break;
//                }
//            }
//
//
//        }
    }

    public static Date getMonthDate(Date startDate, int month) {
        LocalDateTime localDateTime = startDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime().plusMonths(month);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
