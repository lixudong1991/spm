package cn.lxd.ctr;

import cn.lxd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Tomcat on 2017/9/22.
 */
@Controller
public class AnnotationCtr {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/stus")
    public ModelAndView getStus(){
        ModelAndView modelAndView=new ModelAndView();
        try {
            modelAndView.addObject("students",studentService.findStByids(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("list");
        return modelAndView;
    }
}
