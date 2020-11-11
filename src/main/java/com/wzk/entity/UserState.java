package com.wzk.entity;

import java.util.Date;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: TODO
 * @date 2020/11/11 20:18
 */
public class UserState {
    int uId;
    int stateId;
    Date loginTime;
    String loginIP;
    Date logoutTime;

    public UserState() {
    }

    public UserState(int uId, int stateId, Date loginTime, String loginIP, Date logoutTime) {
        this.uId = uId;
        this.stateId = stateId;
        this.loginTime = loginTime;
        this.loginIP = loginIP;
        this.logoutTime = logoutTime;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    @Override
    public String toString() {
        return "UserState{" +
                "uId=" + uId +
                ", stateId=" + stateId +
                ", loginTime=" + loginTime +
                ", loginIP='" + loginIP + '\'' +
                ", logoutTime=" + logoutTime +
                '}';
    }
}
