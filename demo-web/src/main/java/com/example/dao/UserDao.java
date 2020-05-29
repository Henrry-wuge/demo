package com.example.dao;

import com.example.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends HibernateDaoSupport {

    public void add(User user) {
        this.getHibernateTemplate().save(user);
    }

    public User getUserByUserName(String userName) {
        List<User> userList = (List<User>) this.getHibernateTemplate().find("from User where userName = ?0", userName);
        if (null != userList && 0 < userList.size()) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        List<User> userList = (List<User>) this.getHibernateTemplate().find("from User where userName = ?0 and password = ?1", username, password);
        if (null != userList && 0 < userList.size()) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    @Autowired
    public void setSessionFactory1(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
}
