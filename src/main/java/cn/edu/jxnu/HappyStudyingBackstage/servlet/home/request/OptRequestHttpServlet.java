package cn.edu.jxnu.HappyStudyingBackstage.servlet.home.request;

import cn.edu.jxnu.HappyStudyingBackstage.dao.RequestDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.UserDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplRequestDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Request;
import cn.edu.jxnu.HappyStudyingBackstage.domain.User;
import cn.edu.jxnu.HappyStudyingBackstage.service.RequestService;
import cn.edu.jxnu.HappyStudyingBackstage.service.impl.ImplRequestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OptRequestHttpServlet", value = "/OptRequestHttpServlet")
public class OptRequestHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset = UTF-8");

        PrintWriter out = resp.getWriter();
        RequestService service = new ImplRequestService();
        String id = req.getParameter("id");
        System.out.println(id);
        service.delRequest(Integer.valueOf(id));
        req.getRequestDispatcher("/WEB-INF/request/request_list.html").forward(req, resp);
    }
}
