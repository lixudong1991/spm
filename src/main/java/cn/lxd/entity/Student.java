package cn.lxd.entity;

import java.util.Date;

/**
 * Created by Tomcat on 2017/9/20.
 */
public class Student {
    private int id;
    private int number;
    private String name;
    private Date birthday;
    private int age;
    private String sex;
    private int classid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int cid) {
        this.classid = cid;
    }

    @Override
    public String toString() {
        return "Student[" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", cid=" + classid +
                ']';
    }
}
