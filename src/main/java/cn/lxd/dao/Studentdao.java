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
   int findStuCount()throws Exception;
   List<Student> findStByName(StuIds stuIds)throws Exception;
   void updateStubyIds(StuIds stuIds)throws Exception;
   void deleteStusByids(StuIds stuIds)throws Exception;
   List<Student> findStusByids(StuIds stuIds)throws Exception;
}
