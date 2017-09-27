package cn.lxd.dao;

import cn.lxd.entity.User;
import cn.lxd.entity.Users;

/**
 * Created by Tomcat on 2017/9/25.
 */
public interface UserDao {
    User getUserByNameAndPass(User user) throws Exception;
    User getUserByName(String username) throws Exception;
    void addUsers(Users users)throws Exception;
}
