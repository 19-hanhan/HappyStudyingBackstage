package cn.edu.jxnu.HappyStudyingBackstage.service;

import cn.edu.jxnu.HappyStudyingBackstage.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public List<Map<String, Object>> findAllUser();

    public List<Map<String, Object>> findUserByName(String str);

    public int delUser(int id);

    public int updateUser(User item);

    public Map<String, Object> findUserById(int id);

    public int clacUserCount();
}
