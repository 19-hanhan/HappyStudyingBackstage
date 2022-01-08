package cn.edu.jxnu.HappyStudyingBackstage.servlet.home.admin;

import cn.edu.jxnu.HappyStudyingBackstage.dao.adminDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImpladminDao;
import cn.edu.jxnu.HappyStudyingBackstage.service.adminService;
import cn.edu.jxnu.HappyStudyingBackstage.service.impl.ImpladminService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdminListHttpServlet", value = "/admin_list.do")
public class AdminListHttpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();

        adminService service = new ImpladminService();
        List<Map<String, Object>> ls = service.findAllAdmin();
        map.put("success", true);
        map.put("list", ls);
        map.put("count", service.clacAdminCount());
        out.println(mapper.writeValueAsString(map));
    }
}
