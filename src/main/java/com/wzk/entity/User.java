package com.wzk.entity;

import java.util.Date;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: TODO
 * @date 2020/11/11 20:07
 */
public class User {
    int uId;
    String uName;
    String password;
    int sex;
    String tel;
    String email;
    String address;
    int type;
    Date birthday;
    int stateId;

    public User() {
    }


    public User(int uId, String uName, String password, int sex, String tel, String email, String address, int type, Date birthday, int stateId) {
        this.uId = uId;
        this.uName = uName;
        this.password = password;
        this.sex = sex;
        this.tel = tel;
        this.email = email;
        this.address = address;
        this.type = type;
        this.birthday = birthday;
        this.stateId = stateId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", tel=" + tel +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", type=" + type +
                ", birthday=" + birthday +
                ", stateId=" + stateId +
                '}';
    }
}
