package com.example.rodri.vcatcher.model;

/**
 * Created by rodri on 11/6/2016.
 */

public class UserLevel {

    private long id;
    private long userId;
    private int num;
    private int currentExperience;

    public UserLevel() {}

    public UserLevel(long id, long userId, int num, int currentExperience) {
        this.id = id;
        this.userId = userId;
        this.num = num;
        this.currentExperience = currentExperience;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCurrentExperience() {
        return currentExperience;
    }

    public void setCurrentExperience(int currentExperience) {
        this.currentExperience = currentExperience;
    }
}
