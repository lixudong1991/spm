package cn.lxd.ctr;

import cn.lxd.entity.Logstatus;
import cn.lxd.entity.User;
import cn.lxd.entity.Users;
import cn.lxd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomcat on 2017/9/25.
 */
@Controller
@RequestMapping("/log")
public class LoginCtr {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    @ResponseBody
    public Logstatus login(User user, HttpSession httpSession) throws Exception {
        User user1 = userService.getUserByNameAndPass(user);
        Logstatus logstatus = new Logstatus();
        logstatus.setLogsuccess(false);
        logstatus.setLogmessage("用户不存在");
        if (user1 != null) {
            logstatus.setLogsuccess(true);
            logstatus.setLogmessage("登录成功");
            httpSession.setAttribute("user", user1);
        }
        return logstatus;
    }

    @RequestMapping(value = "/logout.action")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().removeAttribute("user");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @RequestMapping(value = "/reg.action",method = RequestMethod.POST)
    @ResponseBody
    public Logstatus reg(User user) throws Exception {
        Logstatus logstatus = new Logstatus();
        logstatus.setLogsuccess(true);
        User user1 = userService.getUserByName(user.getUsername());
        if (user1 != null) {
            logstatus.setLogmessage("用户名已存在");
            logstatus.setLogsuccess(false);
            return logstatus;
        }
        user.setAuth(0);
        Users users = new Users();
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        users.setUserList(userList);
        userService.addUsers(users);
        return logstatus;
    }

    @RequestMapping(value = "/isregUsername.action",method = RequestMethod.POST)
    @ResponseBody
    public Logstatus isregUsername(String username) throws Exception {
        Logstatus logstatus = new Logstatus();
        logstatus.setLogsuccess(false);
        if (username == null || username.equals("")) {
            logstatus.setLogmessage("用户名不能为空");
            return logstatus;
        }
        User user = userService.getUserByName(username);
        logstatus.setLogmessage("用户名已存在");
        if (user == null) {
            logstatus.setLogmessage("用户名可以使用");
            logstatus.setLogsuccess(true);
        }
        return logstatus;
    }


}
