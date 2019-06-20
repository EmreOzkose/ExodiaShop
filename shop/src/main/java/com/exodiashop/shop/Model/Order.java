package com.exodiashop.shop.Model;

import com.exodiashop.shop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Order {

    @Autowired
    ProductService productService;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String Customer;
    private String ProductIDs;
    private int isConfirmed;
    private int isFinished;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public String getProductIDs() {
        return ProductIDs;
    }

    public void setProductIDs(String productIDs) {
        ProductIDs = productIDs;
    }

    public int isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(int confirmed) {
        isConfirmed = confirmed;
    }

    public int isFinished() {
        return isFinished;
    }

    public void setFinished(int finished) {
        isFinished = finished;
    }
}
