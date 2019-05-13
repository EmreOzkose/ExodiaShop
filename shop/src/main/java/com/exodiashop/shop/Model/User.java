package com.exodiashop.shop.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;


public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 4, max = 50)
    private String username;
    @NotNull
    @Size(min = 8, max = 32)
    private String password;
    @NotNull
    @Size(min = 8, max = 32)
    private String passwordconfirm;
    @NotNull
    @Size(min = 3, max =60)
    @Pattern(regexp="[a-zA-Z][a-zA-Z ]+", message="Name can only consist of letters")
    private String name;
    @NotNull
    @Size(min = 3, max =60)
    @Pattern(regexp="[a-zA-Z][a-zA-Z ]+", message="Surname can only consist of letters")
    private String surname;
    @Past
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateofbirth;
    @NotNull
    private String gender;
    @NotNull
    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", message="uygun degil")
    private String email;
    private String address;
    private String phonenumber;
    private String role;

    // remove initial value later
    private String shoppingCart = "1,2,3,4,5";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPasswordconfirm() {
        return passwordconfirm;
    }

    public void setPasswordconfirm(String passwordconfirm) {
        this.passwordconfirm = passwordconfirm;
    }


    public List<Product> getShoppingCart() {
        List<Product> productList = new ArrayList<>();

        return productList;
    }

    // Update with string-list switch
    public void setShoppingCart(String shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
