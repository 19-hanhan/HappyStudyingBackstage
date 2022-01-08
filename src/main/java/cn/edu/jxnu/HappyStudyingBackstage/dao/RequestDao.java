package cn.edu.jxnu.HappyStudyingBackstage.dao;

import cn.edu.jxnu.HappyStudyingBackstage.domain.Activity;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Request;
import cn.edu.jxnu.HappyStudyingBackstage.domain.admin;
import cn.edu.jxnu.HappyStudyingBackstage.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface RequestDao {

    public int delRequest(int id);

    public List<Request> findAllRequest();

    public Map<String, Object> findRequestById(int id);

    public int clacRequestCount();
}
