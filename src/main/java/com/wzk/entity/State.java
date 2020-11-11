package com.wzk.entity;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: TODO
 * @date 2020/11/11 20:16
 */
public class State {
    int stateId;
    String StateName;

    public State() {
    }

    public State(int stateId, String stateName) {
        this.stateId = stateId;
        StateName = stateName;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    @Override
    public String toString() {
        return "State{" +
                "stateId=" + stateId +
                ", StateName='" + StateName + '\'' +
                '}';
    }
}
