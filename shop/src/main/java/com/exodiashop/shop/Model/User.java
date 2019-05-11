package com.exodiashop.shop.Model;





import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "user", schema = "exodiadb")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "dateofbirth")
    private Date dateOfBirth;

    @Column(name = "email", nullable = false)
    private String email;

    /**
     * 0: admin
     * 1: customer
     * 2: seller
     */
    @Column(name = "userType", nullable = false)
    private int userType;
    /**
     * 0: male
     * 1: female
     */
    @Column(name = "gender", nullable = false)
    private int gender;
    @Column(name = "shopping_cart")
    private String shopping_cart;
    @Column(name = "profilePhoto")
    private String profilePhoto;

    public User(){}
  /*  public User(String name, String surname, String email, String username, String password, int gender, int userType, String profilePhoto, String shopping_cart){
        this.name = name;
        this.username = username;
        this.password = password;
        this.surname = surname;
        this.email = email;
        this.userType = userType;
        this.gender = gender;
        this.profilePhoto = profilePhoto;
        this.shopping_cart = shopping_cart;


  }
 */
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


    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShopping_cart() {
        return shopping_cart;
    }

    public void setShopping_cart(String shopping_cart) {
        this.shopping_cart = shopping_cart;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
