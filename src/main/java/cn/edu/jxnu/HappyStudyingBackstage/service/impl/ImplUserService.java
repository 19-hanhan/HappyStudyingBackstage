package cn.edu.jxnu.HappyStudyingBackstage.service.impl;

import cn.edu.jxnu.HappyStudyingBackstage.dao.UserDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplUserDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.User;
import cn.edu.jxnu.HappyStudyingBackstage.service.UserService;
import cn.edu.jxnu.HappyStudyingBackstage.util.JDBCUtil;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class ImplUserService implements UserService {

    UserDao dao = new ImplUserDao();

    public List<Map<String, Object>> findAllUser() {
        return dao.findAllUser();
    }

    public List<Map<String, Object>> findUserByName(String str) {
        return dao.findUserByName("%" + str + "%");
    }

    public int delUser(int id) {
        return dao.delUser(id);
    }

    public int updateUser(User item) {
        return dao.updateUser(item);
    }

    public Map<String, Object> findUserById(int id) {
        return dao.findUserById(id);
    }

    public int clacUserCount() {
        return dao.clacUserCount();
    }
}
