package cn.lxd.ctr;

import cn.lxd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tomcat on 2017/9/22.
 */
@Controller("students1")
public class HttpCtr implements HttpRequestHandler {
    @Autowired
    private StudentService studentService;

    @Override
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
            /*使用此方法可以通过修改response，设置响应的数据格式，例如json串*/
        httpServletRequest.setAttribute("students", studentService.findAllStudent());
        httpServletRequest.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(httpServletRequest, httpServletResponse);

    }
}
