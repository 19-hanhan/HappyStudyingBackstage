package cn.edu.jxnu.HappyStudyingBackstage.servlet.home.teacher;

import cn.edu.jxnu.HappyStudyingBackstage.dao.TeacherDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.adminDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplTeacherDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Student;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Teacher;
import cn.edu.jxnu.HappyStudyingBackstage.domain.admin;
import cn.edu.jxnu.HappyStudyingBackstage.service.TeacherService;
import cn.edu.jxnu.HappyStudyingBackstage.service.impl.ImplTeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddTeacherHttpServlet", value = "/AddTeacherHttpServlet")
public class AddTeacherHttpServlet extends HttpServlet {
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
        TeacherService service = new ImplTeacherService();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String college = req.getParameter("college");
        String title = req.getParameter("title");
        Teacher add = new Teacher(id, name, sex, college, title);
        System.out.println(add);
        int flag = service.addTeacher(add);
        if (flag == 0) {
            out.print("false");
        }
        else {
            out.print("true");
        }
    }
}
