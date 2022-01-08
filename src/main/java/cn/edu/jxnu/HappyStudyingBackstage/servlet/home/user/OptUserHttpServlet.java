package cn.edu.jxnu.HappyStudyingBackstage.servlet.home.user;

import cn.edu.jxnu.HappyStudyingBackstage.dao.UserDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplUserDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.User;
import cn.edu.jxnu.HappyStudyingBackstage.service.UserService;
import cn.edu.jxnu.HappyStudyingBackstage.service.impl.ImplUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OptUserHttpServlet", value = "/OptUserHttpServlet")
public class OptUserHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset = UTF-8");

        PrintWriter out = resp.getWriter();
        UserService service = new ImplUserService();
        String id = req.getParameter("id");
        String opt = req.getParameter("opt");
        System.out.println(id);
        System.out.println(opt);
        if (opt.equals("delete")) {
            service.delUser(Integer.valueOf(id));
        } else if (opt.equals("update")) {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String pwd = req.getParameter("pwd");
            String post = req.getParameter("post");
            String no = req.getParameter("no");
            String subDivision = req.getParameter("subDivision");
            String diamond = req.getParameter("diamond");
            User tmp = new User(Integer.valueOf(id), name, email, pwd, post, no, subDivision, diamond);
            service.updateUser(tmp);
        }
        req.getRequestDispatcher("/WEB-INF/user/user_list.html").forward(req, resp);
    }
}
