package cn.edu.jxnu.HappyStudyingBackstage.dao.impl;

import cn.edu.jxnu.HappyStudyingBackstage.dao.ActivityDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Activity;
import cn.edu.jxnu.HappyStudyingBackstage.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ImplActivityDao implements ActivityDao {

    static JdbcTemplate jt;

    static {
        jt = new JdbcTemplate(JDBCUtil.getDataSource());
    }

    public List<Activity> findAllActivity() {
        String sql = "SELECT * FROM t_activities";
        List ls = jt.query(sql, new BeanPropertyRowMapper<Activity>(Activity.class));
        return ls;
    }

    public List<Activity> findActivityByName(String str) {
        String sql = "SELECT * FROM t_activities WHERE a_title LIKE ?";
        List ls = jt.query(sql, new BeanPropertyRowMapper<Activity>(Activity.class), str);
        return ls;
    }

    public int delActivity(int id) {
        String sql = "DELETE FROM t_activities WHERE a_id = ?";
        return jt.update(sql, id);
    }

    public int updateActivity(Activity item) {
        String sql = "UPDATE t_activities SET a_user_id = ?, a_user_name = ?, a_title = ? a_colleges = ?, is_sticky = ?, is_essence = ?, is_audit = ? where a_id = ?";
        return jt.update(sql, item.getaUserId(), item.getaUserName(), item.getaTitle(), item.getaColleges(), item.getIsSticky(), item.getIsEssence(), item.getIsAudit(), item.getaId());
    }

    public List<Activity> findActivityById(int id) {
        String sql = "SELECT * FROM t_activities WHERE a_id = ?";
        List<Activity> item = jt.query(sql, new BeanPropertyRowMapper<Activity>(Activity.class), id);
        return item;
    }

    public int clacActivityCount() {
        String sql = "SELECT COUNT(*) AS count FROM t_activities";
        int cnt = jt.queryForObject(sql.toString(), Integer.class);
        return cnt;
    }
}
