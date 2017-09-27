package cn.lxd.ctr;

import cn.lxd.entity.Student;
import cn.lxd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    /*RESTful风格url
    大括号里的值为占位符，@PathVariable将占位符处的值与参数绑定
    */
    @RequestMapping("/responsejson/{id}")
    public @ResponseBody Student responsejson(@PathVariable("id") Integer id) throws Exception {
        return studentService.findStudentbyId(id);
    }
}
