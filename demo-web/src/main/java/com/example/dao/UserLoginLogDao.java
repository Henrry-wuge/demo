package com.example.dao;

import com.example.model.UserLoginLog;
import com.example.model.UserLoginLogVO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserLoginLogDao extends HibernateDaoSupport {

    public void add(UserLoginLog userLoginLog) {
        this.getHibernateTemplate().save(userLoginLog);
    }

    public List<UserLoginLogVO> list() {
        String hql = "select new com.example.model.UserLoginLogVO(u.id, u.userName, ull.loginTime, ull.loginIp) from UserLoginLog ull left join User u on ull.userId = u.id";

        List<UserLoginLogVO> userLoginLogVOS = (List<UserLoginLogVO>) this.getHibernateTemplate().find(hql);

        return userLoginLogVOS;
    }

    @Autowired
    public void setSessionFactory1(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
}
