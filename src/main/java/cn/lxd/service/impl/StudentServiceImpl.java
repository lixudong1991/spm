package cn.lxd.service.impl;

import cn.lxd.dao.Studentdao;
import cn.lxd.entity.StuIds;
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
public class StudentServiceImpl implements StudentService{
    @Autowired
    private Studentdao studentdao;

    @Override
    public Student findStuByid(int id) throws Exception {
        return studentdao.findStuByid(id);
    }

    @Override
    public void insertStu(Student student) throws Exception {
        studentdao.insertStu(student);
    }

    @Override
    public int findStuCount(Student student) throws Exception {
        return studentdao.findStuCount(student);
    }

    @Override
    public List<Student> findStByids(StuIds stuIds) throws Exception {
        return studentdao.findStByids(stuIds);
    }
}
