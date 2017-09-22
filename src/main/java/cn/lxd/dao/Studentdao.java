package cn.lxd.dao;

import cn.lxd.entity.StuIds;
import cn.lxd.entity.Student;

import java.util.List;

/**
 * Created by Tomcat on 2017/9/21.
 */
public interface Studentdao {
   Student findStuByid(int id)throws Exception;
   void insertStu(Student student)throws Exception;
   int findStuCount(Student student)throws Exception;
   List<Student> findStByids(StuIds stuIds)throws Exception;
}
