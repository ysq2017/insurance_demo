package com.dafy.drools.dao;

public class User {

    private String name;// 姓名

    private int level;// 用户级别

    public User(){

    }

    public User(String name, int level){
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
