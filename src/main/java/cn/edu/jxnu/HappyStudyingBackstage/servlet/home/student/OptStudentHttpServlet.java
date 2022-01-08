package cn.edu.jxnu.HappyStudyingBackstage.servlet.home.student;

import cn.edu.jxnu.HappyStudyingBackstage.dao.StudentDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplStudentDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Student;
import cn.edu.jxnu.HappyStudyingBackstage.service.StudentService;
import cn.edu.jxnu.HappyStudyingBackstage.service.impl.ImplStudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OptStudentHttpServlet", value = "/OptStudentHttpServlet")
public class OptStudentHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset = UTF-8");

        PrintWriter out = resp.getWriter();
        StudentService service = new ImplStudentService();
        String id = req.getParameter("id");
        String opt = req.getParameter("opt");
        System.out.println(id);
        System.out.println(opt);
        if (opt.equals("delete")) {
            service.delStudent(Integer.valueOf(id));
        } else if (opt.equals("update")) {
            String name = req.getParameter("name");
            String sex = req.getParameter("sex");
            String college = req.getParameter("college");
            String sClass = req.getParameter("sClass");
            service.updateStudent(new Student(id, name, sex, college, sClass));
        }
        req.getRequestDispatcher("/WEB-INF/student/student_list.html").forward(req, resp);
    }
}
