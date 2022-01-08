package cn.edu.jxnu.HappyStudyingBackstage.servlet.home.request;

import cn.edu.jxnu.HappyStudyingBackstage.dao.ActivityDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.RequestDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplActivityDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplRequestDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Activity;
import cn.edu.jxnu.HappyStudyingBackstage.service.ActivityService;
import cn.edu.jxnu.HappyStudyingBackstage.service.RequestService;
import cn.edu.jxnu.HappyStudyingBackstage.service.impl.ImplActivityService;
import cn.edu.jxnu.HappyStudyingBackstage.service.impl.ImplRequestService;
import com.mysql.cj.PreparedQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "PassRequestHttpServlet", value = "/PassRequestHttpServlet")
public class PassRequestHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset = UTF-8");

        String tId = req.getParameter("tActivityId");
        System.out.println("tId = " + tId);
        ActivityService aService = new ImplActivityService();
        List<Activity> ls = aService.findActivityById(Integer.valueOf(tId));
        ls.get(0).setIsAudit(1);
        aService.updateActivity(ls.get(0));

        String id = req.getParameter("id");
        RequestService rService = new ImplRequestService();
//        rService.delRequest(Integer.valueOf(id));

        req.getRequestDispatcher("/WEB-INF/request/request_list.html").forward(req, resp);
    }
}
