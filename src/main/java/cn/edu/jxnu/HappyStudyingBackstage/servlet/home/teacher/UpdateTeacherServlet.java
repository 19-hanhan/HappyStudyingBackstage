package cn.edu.jxnu.HappyStudyingBackstage.servlet.home.teacher;

import cn.edu.jxnu.HappyStudyingBackstage.dao.TeacherDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.adminDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplTeacherDao;
import cn.edu.jxnu.HappyStudyingBackstage.service.TeacherService;
import cn.edu.jxnu.HappyStudyingBackstage.service.impl.ImplTeacherService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "UpdateTeacherServlet", value = "/UpdateTeacherServlet")
public class UpdateTeacherServlet implements Servlet {
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

        int id = Integer.valueOf(request.getParameter("id"));
        TeacherService service = new ImplTeacherService();
        Map<String, Object> ad = service.findTeacherById(id);
        request.setAttribute("teacher", ad);
        request.getRequestDispatcher("/WEB-INF/teacher/teacher_update.jsp").forward(request,response);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
