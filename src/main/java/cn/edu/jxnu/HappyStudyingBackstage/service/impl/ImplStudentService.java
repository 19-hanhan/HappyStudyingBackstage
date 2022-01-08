package cn.edu.jxnu.HappyStudyingBackstage.service.impl;

import cn.edu.jxnu.HappyStudyingBackstage.dao.StudentDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplStudentDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Student;
import cn.edu.jxnu.HappyStudyingBackstage.service.StudentService;
import cn.edu.jxnu.HappyStudyingBackstage.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class ImplStudentService implements StudentService {

    StudentDao dao = new ImplStudentDao();

    public int addStudent(Student item) {
        return dao.addStudent(item);
    }

    public int delStudent(int id) {
        return dao.delStudent(id);
    }

    public int updateStudent(Student item) {
        return dao.updateStudent(item);
    }

    public List<Student> findAllStudent() {
        return dao.findAllStudent();
    }

    public List<Student> findStudentByName(String str) {
        return dao.findStudentByName("%" + str + "%");
    }

    public Map<String, Object> findStudentById(String id) {
        return dao.findStudentById(id);
    }

    public int clacStudentCount() {
        return dao.clacStudentCount();
    }

}
