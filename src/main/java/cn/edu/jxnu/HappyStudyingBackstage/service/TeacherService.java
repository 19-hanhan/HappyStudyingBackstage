package cn.edu.jxnu.HappyStudyingBackstage.service;

import cn.edu.jxnu.HappyStudyingBackstage.domain.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService {

    public int addTeacher(Teacher item);

    public int delTeacher(int id);

    public int updateTeacher(Teacher item);

    public List<Teacher> findAllTeacher();

    public List<Teacher> findTeacherByName(String str);

    public Map<String, Object> findTeacherById(int id);

    public int clacTeacherCount();

}
