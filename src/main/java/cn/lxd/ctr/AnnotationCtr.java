package cn.lxd.ctr;

import cn.lxd.entity.Student;
import cn.lxd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tomcat on 2017/9/22.
 */
@Controller
@RequestMapping("/stu")
public class AnnotationCtr {
    @Autowired
    private StudentService studentService;
    //返回ModelAndView
    @RequestMapping(value = "/stus", method = {RequestMethod.GET})
    public ModelAndView getStus() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.findAllStudent());
        modelAndView.setViewName("list");
        return modelAndView;
    }
    //返回string
    @RequestMapping(value = "/stusa", method = {RequestMethod.GET})
    public String getStusa(Model model) {
        model.addAttribute("students", studentService.findAllStudent());
        return "list";
    }
    //无返回值，可以响应json数据
    @RequestMapping(value = "/stusb", method = {RequestMethod.GET})
    public void getStusb(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("students", studentService.findAllStudent());
        try {
            request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*@RequestParam: 简单类型的参数绑定,包括int,long,double,short,float,char,boolean,byte,String,
     *可以指定value值，表示request传入的叫value值的参数与这个方法参数绑定,如果不加这个注解，
     *那么参数名要和request传入参数同名,还可以指定required值，表示是否必须传入此参数,还可以通过defaultValue
     * 设置默认值，表示如果没有传入这个参数，就可以将这个默认值传给方法参数
     */
    @RequestMapping(value = "/edit", method = {RequestMethod.GET})
    public String editStu(Model model, @RequestParam(value = "id",required =true)Integer stuid) {
        model.addAttribute("student", studentService.findStudentbyId(stuid));
        return "edit";
    }

    /*自定义类型参数绑定必须保证自定义类型的参数名和input标签中提交的name属性值一致,并且如果含有日期类型，必须自定义参数转换器*/
    @RequestMapping(value = "/editsubmit", method = {RequestMethod.POST})
    public String editStuSubmit(Integer id, Student student) {
        studentService.changeStudent(id,student);
        return "redirect:stus.action";
    }

}
