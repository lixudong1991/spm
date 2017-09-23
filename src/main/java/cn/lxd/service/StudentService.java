package cn.lxd.service;

import cn.lxd.entity.Student;

import java.util.List;

/**
 * Created by Tomcat on 2017/9/22.
 */
public interface StudentService {
    List<Student> findAllStudent();
    void changeStudent(Integer id,Student student);
    Student findStudentbyId(int id);
}
