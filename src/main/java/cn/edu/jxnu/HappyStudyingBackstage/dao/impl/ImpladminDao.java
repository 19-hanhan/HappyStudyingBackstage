package cn.edu.jxnu.HappyStudyingBackstage.dao.impl;

import cn.edu.jxnu.HappyStudyingBackstage.dao.adminDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.admin;
import cn.edu.jxnu.HappyStudyingBackstage.util.JDBCUtil;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class ImpladminDao implements adminDao {

    static JdbcTemplate jt;

    static {
        jt = new JdbcTemplate(JDBCUtil.getDataSource());
    }

    public int addAdmin(admin item) {
        String sql = "INSERT INTO t_admin (a_password, a_name, a_email) VALUES (?, ?, ?)";
        return jt.update(sql, item.getaPassword(), item.getaName(), item.getaEmail());
    }

    public int delAdmin(int id) {
        String sql = "DELETE FROM t_admin WHERE a_id = ?";
        return jt.update(sql, id);
    }

    public int updateAdmin(admin item) {
        String sql = "UPDATE t_admin SET a_password = ?, a_name = ?, a_email = ? where a_id = ?";
        return jt.update(sql, item.getaPassword(), item.getaName(), item.getaEmail(), item.getaId());
    }

    public List<Map<String, Object>> findAllAdmin() {
        String sql = "SELECT * FROM t_admin";
        List<Map<String, Object>> ls = jt.queryForList(sql);
        return ls;
    }

    public List<Map<String, Object>> findAdminByName(String str) {
        String sql = "SELECT * FROM t_admin WHERE a_name LIKE ?";
        List<Map<String, Object>> ls = jt.queryForList(sql, str);
        return ls;
    }

    public Map<String, Object> findAdminById(int id) {
        try {
            String sql = "SELECT * FROM t_admin WHERE a_id = ?";
            Map<String, Object> item = jt.queryForMap(sql, id);
            return item;
        } catch (Exception e) {
            return null;
        }
    }

    public int clacAdminCount() {
        String sql = "SELECT COUNT(*) AS count FROM t_admin";
        int cnt = jt.queryForObject(sql.toString(), Integer.class);
        return cnt;
    }

    public Map<String, Object> findAdminByEmail(String email) {
        try {
            String sql = "SELECT * FROM t_admin WHERE a_email = ?";
            Map<String, Object> item = jt.queryForMap(sql, email);
            return item;
        } catch (Exception e) {
            return null;
        }
    }
}
