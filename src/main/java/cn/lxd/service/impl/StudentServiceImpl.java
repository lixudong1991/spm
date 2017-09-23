package cn.lxd.service.impl;

import cn.lxd.dao.Studentdao;
import cn.lxd.entity.Student;
import cn.lxd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tomcat on 2017/9/22.
 */
@Component
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private Studentdao studentdao;

    @Override
    public List<Student> findAllStudent() {
        try {
            return studentdao.findStByids(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void changeStudent(Integer id, Student student) {
        try {
            if (student != null && id != null) {
                student.setId(id);
                studentdao.updateStubyId(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student findStudentbyId(int id) {
        try {
            return studentdao.findStuByid(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
