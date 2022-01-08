package cn.edu.jxnu.HappyStudyingBackstage.servlet.home.admin;

import cn.edu.jxnu.HappyStudyingBackstage.dao.adminDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImpladminDao;
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

@WebServlet(name = "AddAdminHttpServlet", value = "/AddAdminHttpServlet")
public class AddAdminHttpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset = UTF-8");
//        resp.setContentType("application/json; charset=utf-8");
//        System.out.println("I am in?");

        PrintWriter out = resp.getWriter();
        adminService service = new ImpladminService();
        String pwd = req.getParameter("pwd");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        admin add = new admin(pwd, name, email);
        System.out.println(add);
        int flag = service.addAdmin(add);
        if (flag == 0) {
            out.print("false");
        }
        else {
            out.print("true");
        }
    }
}
