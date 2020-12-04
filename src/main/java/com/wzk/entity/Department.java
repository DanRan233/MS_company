package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: 部门信息实体类。
 * @date 2020/11/29 10:28
 */
public class Department {
    private Integer depId;//部门ID
    private String depNo;//部门编号
    private String depName;//部门名称

    public Department(Integer depId, String depNo, String depName) {
        this.depId = depId;
        this.depNo = depNo;
        this.depName = depName;
    }

    public Department(Integer depId, String depName) {
        this.depId = depId;
        this.depName = depName;
    }

    public Department() {
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepNo() {
        return depNo;
    }

    public void setDepNo(String depNo) {
        this.depNo = depNo;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", depNo='" + depNo + '\'' +
                ", depName='" + depName + '\'' +
                '}';
    }
}
