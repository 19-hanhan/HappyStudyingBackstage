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

@WebServlet(name = "OptTeacherHttpServlet", value = "/OptTeacherHttpServlet")
public class OptTeacherHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset = UTF-8");

        PrintWriter out = resp.getWriter();
        TeacherService service = new ImplTeacherService();
        String id = req.getParameter("id");
        String opt = req.getParameter("opt");
        System.out.println(id);
//        System.out.println(opt);
        if (opt.equals("delete")) {
            service.delTeacher(Integer.valueOf(id));
        } else if (opt.equals("update")) {
            String name = req.getParameter("name");
            String sex = req.getParameter("sex");
            String college = req.getParameter("college");
            String title = req.getParameter("title");
            System.out.println(name);
            System.out.println(sex);
            System.out.println(college);
            System.out.println(title);
            service.updateTeacher(new Teacher(id, name, sex, college, title));
        }
        req.getRequestDispatcher("/WEB-INF/teacher/teacher_list.html").forward(req, resp);
    }
}
