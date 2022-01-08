package cn.edu.jxnu.HappyStudyingBackstage.servlet.home.user;

import cn.edu.jxnu.HappyStudyingBackstage.dao.UserDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplUserDao;
import cn.edu.jxnu.HappyStudyingBackstage.service.UserService;
import cn.edu.jxnu.HappyStudyingBackstage.service.impl.ImplUserService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "UpdateUserServlet", value = "/UpdateUserServlet")
public class UpdateUserServlet implements Servlet {
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
        UserService service = new ImplUserService();
        Map<String, Object> ur = service.findUserById(id);
        request.setAttribute("user", ur);
        request.getRequestDispatcher("/WEB-INF/user/user_update.jsp").forward(request,response);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
