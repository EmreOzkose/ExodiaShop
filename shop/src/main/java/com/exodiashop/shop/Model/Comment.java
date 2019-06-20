package com.exodiashop.shop.Model;

import com.exodiashop.shop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


public class Comment {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String Commentator;
    private String Text;
    private int ProductID;
    private Date Date;
    private String Star;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentator() {
        return Commentator;
    }

    public void setCommentator(String commentator) {
        Commentator = commentator;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public String getStar() {
        return Star;
    }

    public void setStar(String star) {
        Star = star;
    }
}
