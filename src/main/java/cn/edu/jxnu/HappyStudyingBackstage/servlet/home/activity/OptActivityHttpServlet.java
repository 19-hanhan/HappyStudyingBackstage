package cn.edu.jxnu.HappyStudyingBackstage.servlet.home.activity;

import cn.edu.jxnu.HappyStudyingBackstage.dao.ActivityDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplActivityDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Activity;
import cn.edu.jxnu.HappyStudyingBackstage.service.ActivityService;
import cn.edu.jxnu.HappyStudyingBackstage.service.impl.ImplActivityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OptActivityHttpServlet", value = "/OptActivityHttpServlet")
public class OptActivityHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset = UTF-8");

        PrintWriter out = resp.getWriter();
        ActivityService service = new ImplActivityService();
        String id = req.getParameter("id");
        String opt = req.getParameter("opt");
        System.out.println(id);
        if (opt.equals("delete")) {
            service.delActivity(Integer.valueOf(id));
        } else if (opt.equals("update")) {
            System.out.println(opt);
            String name = req.getParameter("name");
            String title = req.getParameter("title");
            String college = req.getParameter("college");
            String sticky = req.getParameter("sticky");
            String essence = req.getParameter("essence");
            Activity tmp = new Activity(Integer.valueOf(id), name, title, college, Integer.valueOf(sticky), Integer.valueOf(essence));
            service.updateActivity(tmp);
            System.out.println("666");
        }
        req.getRequestDispatcher("/WEB-INF/activity/activity_list.html").forward(req, resp);
    }
}
