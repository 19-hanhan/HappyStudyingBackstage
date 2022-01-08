package cn.edu.jxnu.HappyStudyingBackstage.service.impl;

import cn.edu.jxnu.HappyStudyingBackstage.dao.adminDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImpladminDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.admin;
import cn.edu.jxnu.HappyStudyingBackstage.service.adminService;
import cn.edu.jxnu.HappyStudyingBackstage.util.JDBCUtil;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class ImpladminService implements adminService {

    adminDao dao = new ImpladminDao();

    public int addAdmin(admin item) {
        return dao.addAdmin(item);
    }

    public int delAdmin(int id) {
        return dao.delAdmin(id);
    }

    public int updateAdmin(admin item) {
        return dao.updateAdmin(item);
    }

    public List<Map<String, Object>> findAllAdmin() {
        return dao.findAllAdmin();
    }

    public List<Map<String, Object>> findAdminByName(String str) {
        return dao.findAdminByName("%" + str + "%");
    }

    public Map<String, Object> findAdminById(int id) {
        return dao.findAdminById(id);
    }

    public int clacAdminCount() {
        return dao.clacAdminCount();
    }

    public Map<String, Object> findAdminByEmail(String email) {
        return dao.findAdminByEmail(email);
    }
}
