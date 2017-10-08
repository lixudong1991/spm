package cn.lxd.service;

import cn.lxd.entity.StuIds;
import cn.lxd.entity.Student;

import java.util.List;

/**
 * Created by Tomcat on 2017/9/22.
 */
public interface StudentService {
    List<Student> findStudentByName(StuIds stuIds) throws Exception;
    void changeStudents(StuIds stuIds) throws Exception;
    Student findStudentbyId(int id) throws Exception;
    void deleteStudents(StuIds stuIds) throws Exception;
    List<Student> findStusByids(StuIds stuIds)throws Exception;
    void addStu(Student student)throws Exception;
}
