package cn.lxd.ctr;

import cn.lxd.entity.Student;
import cn.lxd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Tomcat on 2017/9/25.
 */
@Controller
public class JsonTest {
    @Autowired
   StudentService studentService;
    @RequestMapping("/requestjson")
    public @ResponseBody Student requestjson(@RequestBody Student student) throws Exception {
        return studentService.findStudentbyId(student.getId());
    }
    @RequestMapping("/responsejson")
    public @ResponseBody Student responsejson(Student student) throws Exception {
        return studentService.findStudentbyId(student.getId());
    }
}
