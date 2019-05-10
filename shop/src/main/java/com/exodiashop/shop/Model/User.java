package com.exodiashop.shop.Model;


import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String username;
    private int age;
    private String surname;
    private String email;
    /**
     * 0: admin
     * 1: customer
     * 2: seller
     */
    private int userType;
    /**
     * 0: male
     * 1: female
     */
    private int gender;
    private List<Product> shopping_cart;
    private String profilePhoto;

    public User(){

    }

    public User(String name, String surname, String email, String username, int age, int gender, int userType, String profilePhoto){
        this.name = name;
        this.username = username;
        this.age = age;
        this.surname = surname;
        this.email = email;
        this.userType = userType;
        this.gender = gender;
        this.profilePhoto = profilePhoto;
        this.shopping_cart = new ArrayList<>();

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public List<Product> getShopping_cart() {
        return shopping_cart;
    }

    public void setShopping_cart(List<Product> shopping_cart) {
        this.shopping_cart = shopping_cart;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
}
