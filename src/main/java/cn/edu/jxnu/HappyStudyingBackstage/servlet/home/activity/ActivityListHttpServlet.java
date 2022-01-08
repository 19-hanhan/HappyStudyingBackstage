package cn.edu.jxnu.HappyStudyingBackstage.servlet.home.activity;

import cn.edu.jxnu.HappyStudyingBackstage.dao.ActivityDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplActivityDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Activity;
import cn.edu.jxnu.HappyStudyingBackstage.service.ActivityService;
import cn.edu.jxnu.HappyStudyingBackstage.service.impl.ImplActivityService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ActivityListHttpServlet", value = "/activity_list.do")
public class ActivityListHttpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();

        ActivityService service = new ImplActivityService();
        List<Activity> ls = service.findAllActivity();
        System.out.println(ls);
        map.put("success", true);
        map.put("list", ls);
        map.put("count", service.clacActivityCount());
//        System.out.println(map);
        out.println(mapper.writeValueAsString(map));
    }
}
