package cn.edu.jxnu.HappyStudyingBackstage.service.impl;

import cn.edu.jxnu.HappyStudyingBackstage.dao.TeacherDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplTeacherDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Teacher;
import cn.edu.jxnu.HappyStudyingBackstage.service.TeacherService;
import cn.edu.jxnu.HappyStudyingBackstage.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class ImplTeacherService implements TeacherService {

    TeacherDao dao = new ImplTeacherDao();

    public int addTeacher(Teacher item) {
        return dao.addTeacher(item);
    }

    public int delTeacher(int id) {
        return dao.delTeacher(id);
    }

    public int updateTeacher(Teacher item) {
        return dao.updateTeacher(item);
    }

    public List<Teacher> findAllTeacher() {
        return dao.findAllTeacher();
    }

    public List<Teacher> findTeacherByName(String str) {
        return dao.findTeacherByName("%" + str + "%");
    }

    public Map<String, Object> findTeacherById(int id) {
        return dao.findTeacherById(id);
    }

    public int clacTeacherCount() {
        return dao.clacTeacherCount();
    }

}
