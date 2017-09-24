package cn.lxd.entity;

import java.util.List;

/**
 * Created by Tomcat on 2017/9/21.
 */
public class StuIds {
   private Student student;
   private List<Integer> ids;
   private List<Student> stus;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<Student> getStus() {
        return stus;
    }

    public void setStus(List<Student> stus) {
        this.stus = stus;
    }
}
