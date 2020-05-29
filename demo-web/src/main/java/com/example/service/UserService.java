package com.example.service;

import com.example.base.MD5Util;
import com.example.dao.UserDao;
import com.example.dao.UserLoginLogDao;
import com.example.model.User;
import com.example.model.UserLoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserLoginLogDao userLoginLogDao;

    @Transactional
    public boolean add(User user) {
        User u = userDao.getUserByUserName(user.getUserName());
        if (null != u) {
            return false;
        }
        userDao.add(user);
        return true;
    }

    @Transactional
    public User login(String username, String password, String ip) {

        User u = userDao.getUserByUserName(username);
        if (null == u) {
            return null;
        }

        String p = MD5Util.md5(password + "@" + u.getSalt());

        if (p.equals(u.getPassword())) {
            UserLoginLog userLoginLog = new UserLoginLog();
            userLoginLog.setLoginIp(ip);
            userLoginLog.setLoginTime(new Date());
            userLoginLog.setUserId(u.getUserId());
            userLoginLogDao.add(userLoginLog);
            return u;
        } else {
            return null;
        }
    }

}
