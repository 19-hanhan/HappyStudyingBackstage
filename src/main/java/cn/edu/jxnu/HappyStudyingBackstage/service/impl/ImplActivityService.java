package cn.edu.jxnu.HappyStudyingBackstage.service.impl;

import cn.edu.jxnu.HappyStudyingBackstage.dao.ActivityDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplActivityDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Activity;
import cn.edu.jxnu.HappyStudyingBackstage.service.ActivityService;
import cn.edu.jxnu.HappyStudyingBackstage.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ImplActivityService implements ActivityService {

    ActivityDao dao = new ImplActivityDao();

    public List<Activity> findAllActivity() {
        return dao.findAllActivity();
    }

    public List<Activity> findActivityByName(String str) {
        return dao.findActivityByName("%" + str + "%");
    }

    public int delActivity(int id) {
        return dao.delActivity(id);
    }

    public int updateActivity(Activity item) {
        return dao.updateActivity(item);
    }

    public List<Activity> findActivityById(int id) {
        return dao.findActivityById(id);
    }

    public int clacActivityCount() {
        return dao.clacActivityCount();
    }
}
