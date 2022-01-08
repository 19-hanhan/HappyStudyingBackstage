package cn.edu.jxnu.HappyStudyingBackstage.dao.impl;

import cn.edu.jxnu.HappyStudyingBackstage.dao.RequestDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Request;
import cn.edu.jxnu.HappyStudyingBackstage.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class ImplRequestDao implements RequestDao {

    static JdbcTemplate jt;

    static {
        jt = new JdbcTemplate(JDBCUtil.getDataSource());
    }

    public int delRequest(int id) {
        String sql = "DELETE FROM t_activity_top_request WHERE t_id = ?";
        return jt.update(sql, id);
    }

    public List<Request> findAllRequest() {
        String sql = "SELECT * FROM t_activity_top_request";
        List<Request> ls = jt.query(sql, new BeanPropertyRowMapper<Request>(Request.class));
        return ls;
    }

    public Map<String, Object> findRequestById(int id) {
        try {
            String sql = "SELECT * FROM t_activity_top_request WHERE t_id = ?";
            Map<String, Object> item = jt.queryForMap(sql, id);
            return item;
        } catch (Exception e) {
            return null;
        }
    }

    public int clacRequestCount() {
        String sql = "SELECT COUNT(*) AS count FROM t_activity_top_request";
        int cnt = jt.queryForObject(sql.toString(), Integer.class);
        return cnt;
    }
}
