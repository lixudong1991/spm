package cn.lxd.ctr;

import cn.lxd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Tomcat on 2017/9/22.
 */
@Controller("students")
public class SimpleCtr implements org.springframework.web.servlet.mvc.Controller {
    @Autowired
    private StudentService studentService;


    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.addObject("students", studentService.findStudentByName(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("list");
        return modelAndView;
    }
}
