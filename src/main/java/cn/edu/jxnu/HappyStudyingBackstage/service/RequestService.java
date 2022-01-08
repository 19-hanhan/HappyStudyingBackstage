package cn.edu.jxnu.HappyStudyingBackstage.service;

import cn.edu.jxnu.HappyStudyingBackstage.domain.Request;

import java.util.List;
import java.util.Map;

public interface RequestService {

    public int delRequest(int id);

    public List<Request> findAllRequest();

    public Map<String, Object> findRequestById(int id);

    public int clacRequestCount();
}
