package cn.edu.jxnu.HappyStudyingBackstage.dao.impl;

import cn.edu.jxnu.HappyStudyingBackstage.dao.UserDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.User;
import cn.edu.jxnu.HappyStudyingBackstage.util.JDBCUtil;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class ImplUserDao implements UserDao {

    static JdbcTemplate jt;

    static {
        jt = new JdbcTemplate(JDBCUtil.getDataSource());
    }

    public List<Map<String, Object>> findAllUser() {
        String sql = "SELECT * FROM t_user";
        List<Map<String, Object>> ls = jt.queryForList(sql);
        return ls;
    }

    public List<Map<String, Object>> findUserByName(String str) {
        String sql = "SELECT * FROM t_user WHERE u_name LIKE ?";
        str = "%" + str + "%";
        List<Map<String, Object>> ls = jt.queryForList(sql, str);
        return ls;
    }

    public int delUser(int id) {
        String sql = "DELETE FROM t_user WHERE u_id = ?";
        return jt.update(sql, id);
    }

    public int updateUser(User item) {
        String sql = "UPDATE t_admin SET u_name = ?, u_email = ?, u_password = ?, is_post = ?, u_no = ?, u_sub_division = ?, u_diamond_number = ? where u_id = ?";
        return jt.update(sql, item.getuName(), item.getaEmail(), item.getuPassword(), item.getIsPost(), item.getuNo(), item.getuSubDivision(), item.getuDiamondNumber(), item.getuId());
    }

    public Map<String, Object> findUserById(int id) {
        try {
            String sql = "SELECT * FROM t_user WHERE u_id = ?";
            Map<String, Object> item = jt.queryForMap(sql, id);
            return item;
        } catch (Exception e) {
            return null;
        }
    }

    public int clacUserCount() {
        String sql = "SELECT COUNT(*) AS count FROM t_user";
        int cnt = jt.queryForObject(sql.toString(), Integer.class);
        return cnt;
    }
}
