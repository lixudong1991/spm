package cn.lxd.service.impl;

import cn.lxd.dao.Studentdao;
import cn.lxd.entity.StuIds;
import cn.lxd.entity.Student;
import cn.lxd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tomcat on 2017/9/22.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private Studentdao studentdao;

    @Override
    public List<Student> findStudentByName(StuIds stuIds) throws Exception {
        return studentdao.findStByName(stuIds);
    }

    @Override
    @Transactional
    public void changeStudents(StuIds stuIds) throws Exception {
        if (stuIds != null) {
            List<Student> students = stuIds.getStus();
            if (students != null && students.size() > 0) {
                studentdao.updateStubyIds(stuIds);
            }
        }
    }

    @Override
    public Student findStudentbyId(int id) throws Exception {
        return studentdao.findStuByid(id);

    }

    @Override
    @Transactional
    public void deleteStudents(StuIds stuIds) throws Exception {
        if (stuIds != null) {
            List<Integer> ids = stuIds.getIds();
            if (ids == null || ids.size() == 0)
                return;
            studentdao.deleteStusByids(stuIds);
        }
    }

    @Override
    public List<Student> findStusByids(StuIds stuIds) throws Exception {
        return studentdao.findStusByids(stuIds);
    }
}
