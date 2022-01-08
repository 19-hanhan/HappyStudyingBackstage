package cn.edu.jxnu.HappyStudyingBackstage.service;

import cn.edu.jxnu.HappyStudyingBackstage.domain.admin;

import java.util.List;
import java.util.Map;

public interface adminService {

    public int addAdmin(admin item);

    public int delAdmin(int id);

    public int updateAdmin(admin item);

    public List<Map<String, Object>> findAllAdmin();

    public List<Map<String, Object>> findAdminByName(String str);

    public Map<String, Object> findAdminById(int id);

    public int clacAdminCount();

    public Map<String, Object> findAdminByEmail(String email);
}
