package cn.edu.jxnu.HappyStudyingBackstage.dao;

import cn.edu.jxnu.HappyStudyingBackstage.domain.Activity;
import cn.edu.jxnu.HappyStudyingBackstage.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface ActivityDao {

    public List<Activity> findAllActivity();

    public List<Activity> findActivityByName(String str);

    public int delActivity(int id);

    public int updateActivity(Activity item);

    public List<Activity> findActivityById(int id);

    public int clacActivityCount();
}
