package cn.edu.jxnu.HappyStudyingBackstage.servlet.home.admin;

import cn.edu.jxnu.HappyStudyingBackstage.domain.admin;
import cn.edu.jxnu.HappyStudyingBackstage.service.adminService;
import cn.edu.jxnu.HappyStudyingBackstage.service.impl.ImpladminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OptAdminHttpServlet", value = "/OptAdminHttpServlet")
public class OptAdminHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset = UTF-8");

        PrintWriter out = resp.getWriter();
        adminService service = new ImpladminService();
        String id = req.getParameter("id");
        String opt = req.getParameter("opt");
        System.out.println(id);
        System.out.println(opt);
        if (opt.equals("delete")) {
            service.delAdmin(Integer.valueOf(id));
        } else if (opt.equals("update")) {
            String name = req.getParameter("name");
            String pwd = req.getParameter("pwd");
            String email = req.getParameter("email");
            service.updateAdmin(new admin(Integer.valueOf(id), pwd, name, email));
        }
        req.getRequestDispatcher("/WEB-INF/admin/admin_list.html").forward(req, resp);
    }
}
