package cn.edu.jxnu.HappyStudyingBackstage.dao;

import cn.edu.jxnu.HappyStudyingBackstage.domain.Student;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Teacher;
import cn.edu.jxnu.HappyStudyingBackstage.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface TeacherDao {

    public int addTeacher(Teacher item);

    public int delTeacher(int id);

    public int updateTeacher(Teacher item);

    public List<Teacher> findAllTeacher();

    public List<Teacher> findTeacherByName(String str);

    public Map<String, Object> findTeacherById(int id);

    public int clacTeacherCount();

}
