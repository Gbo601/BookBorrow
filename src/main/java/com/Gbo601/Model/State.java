package com.Gbo601.Model;

/**
 * @author Gbo601
 * @create 2021-05-22 10:11
 */
public class State {
    private int id;
    private String userID;
    private int num;
    private double money;
    private int state;

    public State() {
    }

    public State(int id, String userID, int num, double money, int state) {

        this.userID = userID;
        this.num = num;
        this.money = money;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", userID='" + userID + '\'' +
                ", num=" + num +
                ", money=" + money +
                ", state=" + state +
                '}';
    }
}
