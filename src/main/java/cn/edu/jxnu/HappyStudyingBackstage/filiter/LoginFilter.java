package cn.edu.jxnu.HappyStudyingBackstage.filiter;

import cn.edu.jxnu.HappyStudyingBackstage.dao.adminDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImpladminDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

//@WebFilter(urlPatterns = {"/home*"})
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html; charset=UTF-8");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        if (cookies != null) {
            for(Cookie ck: cookies) {
                if("username".equals(ck.getName()))
                    username = ck.getValue();
                if("password".equals(ck.getName()))
                    password = ck.getValue();
            }
        }
        if (username != null && password != null) { // cookie中存在账号密码，自动登录
            System.out.println("有cookie，自动登录");
            adminDao dao = new ImpladminDao();
            Map<String, Object> user;
            try {
                user = dao.findAdminById(Integer.valueOf(username)); // 查找用户
                Exception e = new Exception();
                if (user == null) throw e;
            } catch (Exception e) {
                user = dao.findAdminByEmail(username);
            }
            HttpSession session = request.getSession();
            if (user != null && user.get("a_password").equals(password)) {
                session.setAttribute("user", user);
//                request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
                filterChain.doFilter(servletRequest, servletResponse);
            }
            else {
//                request.getRequestDispatcher("/Login/Error.jsp").forward(request,response);
//                response.sendRedirect("Login/Error.jsp");
                response.sendRedirect("/");
            }
        }
        else {
            HttpSession session = request.getSession();
            Map<String, Object> user = (Map<String, Object>)session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("/");
            }
            else {
                System.out.println("有session，自动登录");
//                request.getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
