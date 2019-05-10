package com.exodiashop.shop.Model;


public class User {

    private String name;
    private String username;
    private int age;

    public User(){

    }

    public User(String name, String username, int age){
        this.name = name;
        this.username = username;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
