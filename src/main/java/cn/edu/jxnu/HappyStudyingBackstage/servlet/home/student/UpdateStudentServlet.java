package cn.edu.jxnu.HappyStudyingBackstage.servlet.home.student;

import cn.edu.jxnu.HappyStudyingBackstage.dao.StudentDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplStudentDao;
import cn.edu.jxnu.HappyStudyingBackstage.service.StudentService;
import cn.edu.jxnu.HappyStudyingBackstage.service.impl.ImplStudentService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "UpdateStudentServlet", value = "/UpdateStudentServlet")
public class UpdateStudentServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html; charset=UTF-8");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String id = request.getParameter("id");
        StudentService service = new ImplStudentService();
        Map<String, Object> st = service.findStudentById(id);
        request.setAttribute("student", st);
        request.getRequestDispatcher("/WEB-INF/student/student_update.jsp").forward(request,response);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
