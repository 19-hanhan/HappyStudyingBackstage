package cn.edu.jxnu.HappyStudyingBackstage.servlet.login;

import cn.edu.jxnu.HappyStudyingBackstage.dao.adminDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImpladminDao;
import cn.edu.jxnu.HappyStudyingBackstage.service.adminService;
import cn.edu.jxnu.HappyStudyingBackstage.service.impl.ImpladminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "IndexHttpServlet", value = "/IndexHttpServlet")
public class IndexHttpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset = UTF-8");

//        // 判断Cookie中是否有数据
//        String username = null;
//        String password = null;
//        Cookie[] cookies = request.getCookies();
//        for (Cookie item: cookies) {
//            if ("username".equals(item.getName())) {
//                username = item.getValue();
//            }
//            else if ("password".equals(item.getName())) {
//                password = item.getValue();
//            }
//        }

        // 获取注册数据
        adminService service = new ImpladminService();
        String username = request.getParameter("name"); // 输入的账号
        String password = request.getParameter("pwd"); // 输入的密码
        String verificationCode = request.getParameter("code"); // 输入的验证码值
        System.out.println(username+" "+password+" "+verificationCode);
        String checkboxValue = request.getParameter("saved"); // 复选框值
        System.out.println("saved = "+checkboxValue);

        if (checkboxValue != null) { // 判断是否有选择自动登录，有则用cookie保存
            Cookie ck1 = new Cookie("username", username);
            Cookie ck2 = new Cookie("password", password);
            ck1.setMaxAge(1800);
            ck2.setMaxAge(1800);
            response.addCookie(ck1);
            response.addCookie(ck2);
        }

        PrintWriter out = response.getWriter();
        Map<String, Object> user;
        try {
            user = service.findAdminById(Integer.valueOf(username)); // 查找用户
            Exception e = new Exception();
            if (user == null) throw e;
        } catch (Exception e) {
            user = service.findAdminByEmail(username);
        }
        System.out.println(user);
        HttpSession session = request.getSession();
        String imageCode = (String) session.getAttribute("verificationCode"); // 获取图片验证码字符串
        if (user != null) { // 判断该用户是否查找到了
            if (verificationCode.equalsIgnoreCase(imageCode)) { // 判断验证码是否正确
                if (user.get("a_password").equals(password)) { // 判断密码是否正确
                    session.setAttribute("user", user);
                    System.out.println("登录成功");
//                    request.getRequestDispatcher("/Home").forward(request, response);
//                    response.sendRedirect("Home");
                    out.print("true");
                } else {
                    System.out.println("密码错误");
//                    request.getRequestDispatcher("/Login/Error.jsp").forward(request, response);
//                    response.sendRedirect("Login/Error.jsp");
                    out.print("false");
                }
            } else {
                System.out.println("验证码错误");
//                request.getRequestDispatcher("/Login/Error.jsp").forward(request, response);
//                response.sendRedirect("Login/Error.jsp");
                out.print("false");
            }
        } else {
            System.out.println("没有该用户");
//            request.getRequestDispatcher("/Login/Error.jsp").forward(request, response);
//            response.sendRedirect("Login/Error.jsp");
            out.print("false");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
