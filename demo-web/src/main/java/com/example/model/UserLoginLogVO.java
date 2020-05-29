package com.example.model;

import java.util.Date;

public class UserLoginLogVO {

    private Long userId;

    private String userName;

    private Date loginTime;

    private String loginIp;

    public UserLoginLogVO(Long userId, String userName, Date loginTime, String loginIp) {
        this.userId = userId;
        this.userName = userName;
        this.loginTime = loginTime;
        this.loginIp = loginIp;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
}
