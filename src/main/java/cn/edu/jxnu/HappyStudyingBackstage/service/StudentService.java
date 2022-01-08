package cn.edu.jxnu.HappyStudyingBackstage.service;

import cn.edu.jxnu.HappyStudyingBackstage.domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    public int addStudent(Student item);

    public int delStudent(int id);

    public int updateStudent(Student item);

    public List<Student> findAllStudent();

    public List<Student> findStudentByName(String str);

    public Map<String, Object> findStudentById(String id);

    public int clacStudentCount();

}
