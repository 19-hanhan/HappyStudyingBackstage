package cn.edu.jxnu.HappyStudyingBackstage.servlet.home.teacher;

import cn.edu.jxnu.HappyStudyingBackstage.dao.TeacherDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.adminDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplTeacherDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Teacher;
import cn.edu.jxnu.HappyStudyingBackstage.service.TeacherService;
import cn.edu.jxnu.HappyStudyingBackstage.service.impl.ImplTeacherService;
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

@WebServlet(name = "TeacherListHttpServlet", value = "/teacher_list.do")
public class TeacherListHttpServlet extends HttpServlet {

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

        TeacherService service = new ImplTeacherService();
        List<Teacher> ls = service.findAllTeacher();
        map.put("success", true);
        map.put("list", ls);
        map.put("count", service.clacTeacherCount());
        out.println(mapper.writeValueAsString(map));
    }
}
