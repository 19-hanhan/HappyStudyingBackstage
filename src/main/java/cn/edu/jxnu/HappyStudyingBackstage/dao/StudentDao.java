package cn.edu.jxnu.HappyStudyingBackstage.dao;

import cn.edu.jxnu.HappyStudyingBackstage.domain.Request;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Student;
import cn.edu.jxnu.HappyStudyingBackstage.domain.admin;
import cn.edu.jxnu.HappyStudyingBackstage.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    public int addStudent(Student item);

    public int delStudent(int id);

    public int updateStudent(Student item);

    public List<Student> findAllStudent();

    public List<Student> findStudentByName(String str);

    public Map<String, Object> findStudentById(String id);

    public int clacStudentCount();

}
