package cn.edu.jxnu.HappyStudyingBackstage.dao.impl;

import cn.edu.jxnu.HappyStudyingBackstage.dao.TeacherDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Teacher;
import cn.edu.jxnu.HappyStudyingBackstage.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class ImplTeacherDao implements TeacherDao {

    static JdbcTemplate jt;

    static {
        jt = new JdbcTemplate(JDBCUtil.getDataSource());
    }

    public int addTeacher(Teacher item) {
        String sql = "INSERT INTO t_teacher (t_id, t_name, t_sex, t_college, t_title) VALUES (?, ?, ?, ?, ?)";
        return jt.update(sql, item.gettId(), item.gettName(), item.gettSex(), item.gettCollege(), item.gettTitle());
    }

    public int delTeacher(int id) {
        String sql = "DELETE FROM t_teacher WHERE t_id = ?";
        return jt.update(sql, id);
    }

    public int updateTeacher(Teacher item) {
        String sql = "UPDATE t_teacher SET t_name = ?, t_sex = ?, t_college = ?, t_title = ? where t_id = ?";
        return jt.update(sql, item.gettName(), item.gettSex(), item.gettCollege(), item.gettTitle(), item.gettId());
    }

    public List<Teacher> findAllTeacher() {
        String sql = "SELECT * FROM t_teacher";
        List<Teacher> ls = jt.query(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class));
        return ls;
    }

    public List<Teacher> findTeacherByName(String str) {
        String sql = "SELECT * FROM t_teacher WHERE t_name LIKE ?";
        List<Teacher> ls = jt.query(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class), str);
        return ls;
    }

    public Map<String, Object> findTeacherById(int id) {
        try {
            String sql = "SELECT * FROM t_teacher WHERE t_id = ?";
            Map<String, Object> item = jt.queryForMap(sql, id);
            return item;
        } catch (Exception e) {
            return null;
        }
    }

    public int clacTeacherCount() {
        String sql = "SELECT COUNT(*) AS count FROM t_teacher";
        int cnt = jt.queryForObject(sql.toString(), Integer.class);
        return cnt;
    }

}
