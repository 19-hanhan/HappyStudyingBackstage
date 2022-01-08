package cn.edu.jxnu.HappyStudyingBackstage.service.impl;

import cn.edu.jxnu.HappyStudyingBackstage.dao.RequestDao;
import cn.edu.jxnu.HappyStudyingBackstage.dao.impl.ImplRequestDao;
import cn.edu.jxnu.HappyStudyingBackstage.domain.Request;
import cn.edu.jxnu.HappyStudyingBackstage.service.RequestService;
import cn.edu.jxnu.HappyStudyingBackstage.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class ImplRequestService implements RequestService {

    RequestDao dao = new ImplRequestDao();

    public int delRequest(int id) {
        return dao.delRequest(id);
    }

    public List<Request> findAllRequest() {
        return dao.findAllRequest();
    }

    public Map<String, Object> findRequestById(int id) {
        return dao.findRequestById(id);
    }

    public int clacRequestCount() {
        return dao.clacRequestCount();
    }
}
