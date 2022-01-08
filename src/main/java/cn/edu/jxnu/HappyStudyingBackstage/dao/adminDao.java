package cn.edu.jxnu.HappyStudyingBackstage.dao;

import cn.edu.jxnu.HappyStudyingBackstage.domain.admin;
import cn.edu.jxnu.HappyStudyingBackstage.util.JDBCUtil;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface adminDao {

    public int addAdmin(admin item);

    public int delAdmin(int id);

    public int updateAdmin(admin item);

    public List<Map<String, Object>> findAllAdmin();

    public List<Map<String, Object>> findAdminByName(String str);

    public Map<String, Object> findAdminById(int id);

    public int clacAdminCount();

    public Map<String, Object> findAdminByEmail(String email);
}
