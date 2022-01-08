package cn.edu.jxnu.HappyStudyingBackstage.servlet.home.user;

import cn.edu.jxnu.HappyStudyingBackstage.dao.UserDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplUserDao;
import cn.edu.jxnu.HappyStudyingBackstage.service.UserService;
import cn.edu.jxnu.HappyStudyingBackstage.service.impl.ImplUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ExportUserListHttpServlet", value = "/ExportUserListHttpServlet")
public class ExportUserListHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
//        Map<String, Object> map = new HashMap<>();

        UserService service = new ImplUserService();
        List<Map<String, Object>> ls = service.findAllUser();
//        map.put("success", true);
//        map.put("list", ls);
        System.out.println(ls);
        out.println(mapper.writeValueAsString(ls));
    }
}
