package cn.lxd.service.impl;

import cn.lxd.dao.UserDao;
import cn.lxd.entity.User;
import cn.lxd.entity.Users;
import cn.lxd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tomcat on 2017/9/25.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByNameAndPass(User user) throws Exception {
        if (user != null & user.getUsername() != null)
            return userDao.getUserByNameAndPass(user);
        return null;
    }

    @Override
    public User getUserByName(String username) throws Exception {
        if (username == null || username.equals(""))
            return null;
        return userDao.getUserByName(username);
    }

    @Override
    public void addUsers(Users users) throws Exception {
        if (users != null && users.getUserList() != null && users.getUserList().size() != 0)
            userDao.addUsers(users);
    }
}
