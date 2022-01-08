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

@WebServlet(name = "FindActivityHttpServlet", value = "/FindActivityHttpServlet")
public class FindActivityHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset = UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();

        ActivityService service = new ImplActivityService();
        String key = req.getParameter("key");
        List<Activity> ls = service.findActivityByName(key);
        map.put("success", true);
        map.put("list", ls);
        System.out.println(ls);
        out.println(mapper.writeValueAsString(map));
    }
}
