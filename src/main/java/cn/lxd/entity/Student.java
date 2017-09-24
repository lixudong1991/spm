package cn.lxd.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Tomcat on 2017/9/20.
 */
public class Student {
    private Integer id;
    @NotNull(message = "{student.number.null.error}")
    private Integer number;
    @Size(min = 1,max = 20,message = "{student.name.length.error}")
    private String name;
    private Date birthday;
    private int age;
    private String sex;
    private int classid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
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
