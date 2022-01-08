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

@WebServlet(name = "AddStudentHttpServlet", value = "/AddStudentHttpServlet")
public class AddStudentHttpServlet extends HttpServlet {
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
        StudentService service = new ImplStudentService();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String college = req.getParameter("college");
        String sClass = req.getParameter("sClass");
        Student add = new Student(id, name, sex, college, sClass);
        System.out.println(add);
        int flag = service.addStudent(add);
        if (flag == 0) {
            out.print("false");
        }
        else {
            out.print("true");
        }
    }
}
