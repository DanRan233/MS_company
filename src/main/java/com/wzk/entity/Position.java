package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: 职位信息实体类
 * @date 2020/11/29 10:23
 */
public class Position {
    private Integer posId; // 职位ID
    private String posNo;  // 职位编号
    private String posName; // 职位名称

    public Position(Integer posId, String posNo, String posName) {
        this.posId = posId;
        this.posNo = posNo;
        this.posName = posName;
    }

    public Position(Integer posId, String posName) {
        this.posId = posId;
        this.posName = posName;
    }

    public Position() {
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public String getPosNo() {
        return posNo;
    }

    public void setPosNo(String posNo) {
        this.posNo = posNo;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    @Override
    public String toString() {
        return "Position{" +
                "posId=" + posId +
                ", posNo='" + posNo + '\'' +
                ", posName='" + posName + '\'' +
                '}';
    }
}
