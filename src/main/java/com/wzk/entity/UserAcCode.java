package com.wzk.entity;

import java.util.Date;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: TODO
 * @date 2020/11/11 20:18
 */
public class UserAcCode {
    int uId;
    String acCode;
    Date exTime;

    public UserAcCode() {
    }

    public UserAcCode(int uId, String acCode, Date exTime) {
        this.uId = uId;
        this.acCode = acCode;
        this.exTime = exTime;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getAcCode() {
        return acCode;
    }

    public void setAcCode(String acCode) {
        this.acCode = acCode;
    }

    public Date getExTime() {
        return exTime;
    }

    public void setExTime(Date exTime) {
        this.exTime = exTime;
    }

    @Override
    public String toString() {
        return "UserAcCode{" +
                "uId=" + uId +
                ", acCode='" + acCode + '\'' +
                ", exTime=" + exTime +
                '}';
    }
}
