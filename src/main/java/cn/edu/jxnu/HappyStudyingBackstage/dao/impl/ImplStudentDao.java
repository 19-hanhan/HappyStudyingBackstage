package cn.edu.jxnu.HappyStudyingBackstage.dao.impl;

import cn.edu.jxnu.HappyStudyingBackstage.dao.StudentDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Student;
import cn.edu.jxnu.HappyStudyingBackstage.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class ImplStudentDao implements StudentDao {

    static JdbcTemplate jt;

    static {
        jt = new JdbcTemplate(JDBCUtil.getDataSource());
    }

    public int addStudent(Student item) {
        String sql = "INSERT INTO t_student (s_id, s_name, s_sex, s_college, s_class) VALUES (?, ?, ?, ?, ?)";
        return jt.update(sql, item.getsId(), item.getsName(), item.getsSex(), item.getsCollege(), item.getsClass());
    }

    public int delStudent(int id) {
        String sql = "DELETE FROM t_student WHERE s_id = ?";
        return jt.update(sql, id);
    }

    public int updateStudent(Student item) {
        String sql = "UPDATE t_student SET s_name = ?, s_sex = ?, s_college = ?, s_class = ? where s_id = ?";
        return jt.update(sql, item.getsName(), item.getsSex(), item.getsCollege(), item.getsClass(), item.getsId());
    }

    public List<Student> findAllStudent() {
        String sql = "SELECT * FROM t_student";
        List<Student> ls = jt.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        return ls;
    }

    public List<Student> findStudentByName(String str) {
        String sql = "SELECT * FROM t_student WHERE a_name LIKE ?";
        List<Student> ls = jt.query(sql, new BeanPropertyRowMapper<Student>(Student.class), str);
        return ls;
    }

    public Map<String, Object> findStudentById(String id) {
        try {
            String sql = "SELECT * FROM t_student WHERE s_id = ?";
            Map<String, Object> item = jt.queryForMap(sql, id);
            return item;
        } catch (Exception e) {
            return null;
        }
    }

    public int clacStudentCount() {
        String sql = "SELECT COUNT(*) AS count FROM t_student";
        int cnt = jt.queryForObject(sql.toString(), Integer.class);
        return cnt;
    }

}
