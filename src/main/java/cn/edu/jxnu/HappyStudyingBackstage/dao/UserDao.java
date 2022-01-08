package cn.edu.jxnu.HappyStudyingBackstage.dao;

import cn.edu.jxnu.HappyStudyingBackstage.domain.User;
import cn.edu.jxnu.HappyStudyingBackstage.domain.admin;
import cn.edu.jxnu.HappyStudyingBackstage.util.JDBCUtil;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public List<Map<String, Object>> findAllUser();

    public List<Map<String, Object>> findUserByName(String str);

    public int delUser(int id);

    public int updateUser(User item);

    public Map<String, Object> findUserById(int id);

    public int clacUserCount();
}
