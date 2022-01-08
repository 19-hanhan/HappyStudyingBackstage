package cn.edu.jxnu.HappyStudyingBackstage.service;

import cn.edu.jxnu.HappyStudyingBackstage.domain.Activity;

import java.util.List;

public interface ActivityService {

    public List<Activity> findAllActivity();

    public List<Activity> findActivityByName(String str);

    public int delActivity(int id);

    public int updateActivity(Activity item);

    public List<Activity> findActivityById(int id);

    public int clacActivityCount();
}
