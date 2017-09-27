package cn.lxd.ctr;

import cn.lxd.entity.StuIds;
import cn.lxd.entity.Student;
import cn.lxd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ModelAndView getStus(){
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.addObject("students", studentService.findStudentByName(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("list");
        return modelAndView;
    }
    //包装类型参数绑定input标签中name属性值为 属性名.属性名方式
    @RequestMapping(value = "/stusa", method = {RequestMethod.GET,RequestMethod.POST})
    public String getStusa(Model model, StuIds stuIds) {
        try {
            model.addAttribute("students", studentService.findStudentByName(stuIds));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "list";
    }
    //无返回值，可以响应json数据
    @RequestMapping(value = "/stusb", method = {RequestMethod.GET})
    public void getStusb(HttpServletRequest request, HttpServletResponse response) throws Exception {
            request.setAttribute("students", studentService.findStudentByName(null));
            request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
    }


    /*@RequestParam: 简单类型的参数绑定,包括int,long,double,short,float,char,boolean,byte,String,
     *可以指定value值，表示request传入的叫value值的参数与这个方法参数绑定,如果不加这个注解，
     *那么参数名要和request传入参数同名,还可以指定required值，表示是否必须传入此参数,还可以通过defaultValue
     * 设置默认值，表示如果没有传入这个参数，就可以将这个默认值传给方法参数
     */
    @RequestMapping(value = "/edit", method = {RequestMethod.GET})
    public String editStu(Model model, @RequestParam(value = "id",required =true)Integer stuid) throws Exception {
        model.addAttribute("studt", studentService.findStudentbyId(stuid));
        return "edit";
    }


    @ModelAttribute("itmap")
    public Map<String,String> getClassMapa(){
        Map<String,String> map=new HashMap<String,String>();
        map.put("1","一班");
        map.put("2","二班");
        map.put("3","三班");
        map.put("4","四班");
        return  map;
    }
    /*ModelAttribute设置对象参数在显示页面request域中的key，
    还可以将方法返回值放到所有请求的request域中，并且设置key值
     */
    @RequestMapping(value = "/editsub", method = {RequestMethod.POST})
    public String editsubmit(@ModelAttribute("studt") @Validated Student student, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            List<ObjectError> allerror=bindingResult.getAllErrors();
            for(ObjectError objectError:allerror){
                String mess=objectError.getDefaultMessage();
            }
            return "edit";
        }
        return "redirect:stus.action";
    }


    @RequestMapping(value = "/editStus", method = {RequestMethod.POST})
    public String editStus(Model model, StuIds stuIds) throws Exception {
        if (stuIds != null ) {
            List<Integer> ids=stuIds.getIds();
            if (ids != null && ids.size()> 0) {
                model.addAttribute("students", studentService.findStusByids(stuIds));
                return "edits";
            }
        }
        return "redirect:stus.action";
    }

    /*自定义类型参数绑定必须保证自定义类型的参数名和input标签中提交的name属性值一致,并且如果含有日期类型，必须自定义参数转换器*/
    @RequestMapping(value = "/editsubmit", method = {RequestMethod.POST})
    public String editStuSubmit( StuIds stuIds) throws Exception {
        studentService.changeStudents(stuIds);
        return "redirect:stus.action";
    }
    /*
    *数组类型的参数必须保证input标签中提交的name属性和数组参数名一致
    */
    @RequestMapping(value = "/deletestu", method = {RequestMethod.POST})
    public String deleteStus(StuIds stuIds) throws Exception {
        studentService.deleteStudents(stuIds);
        return "redirect:stus.action";
    }
    @RequestMapping(value = "/findstu")
    public String findstu(){
        return "jsontest";
    }

}
