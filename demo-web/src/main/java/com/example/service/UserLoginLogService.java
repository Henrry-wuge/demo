package com.example.service;

import com.example.dao.UserLoginLogDao;
import com.example.model.UserLoginLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginLogService {

    @Autowired
    private UserLoginLogDao userLoginLogDao;

    public List<UserLoginLogVO> list() {
        return userLoginLogDao.list();
    }
}
