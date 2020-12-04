package com.wzk.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;


/**
 * @author DanRan233
 * @projectName MS_company
 * @description: TODO
 * @date 2020/11/29 10:19
 */
public class Staff {
    int sId;
    String sNo;
    String sName;
    String tel;
    int age;
    String address;
    String birthday;
    String depId;
    String posId;
    float salary;

    public Staff() {
    }

    public Staff(int sId, String sNo, String sName, String tel, int age, String address, String birthday, String depId, String posId, float salary) {
        this.sId = sId;
        this.sNo = sNo;
        this.sName = sName;
        this.tel = tel;
        this.age = age;
        this.address = address;
        this.birthday = birthday;
        this.depId = depId;
        this.posId = posId;
        this.salary = salary;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "sId=" + sId +
                ", sNo='" + sNo + '\'' +
                ", sName='" + sName + '\'' +
                ", tel='" + tel + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", depId='" + depId + '\'' +
                ", posId='" + posId + '\'' +
                ", salary=" + salary +
                '}';
    }
}
