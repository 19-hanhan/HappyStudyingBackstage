package cn.edu.jxnu.HappyStudyingBackstage.servlet.home.request;

import cn.edu.jxnu.HappyStudyingBackstage.dao.RequestDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.UserDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplRequestDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Request;
import cn.edu.jxnu.HappyStudyingBackstage.service.RequestService;
import cn.edu.jxnu.HappyStudyingBackstage.service.impl.ImplRequestService;
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

@WebServlet(name = "ExportRequestListHttpServlet", value = "/ExportRequestListHttpServlet")
public class ExportRequestListHttpServlet extends HttpServlet {
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

        RequestService service = new ImplRequestService();
        List<Request> ls = service.findAllRequest();
//        map.put("success", true);
//        map.put("list", ls);
        System.out.println(ls);
        out.println(mapper.writeValueAsString(ls));
    }
}
