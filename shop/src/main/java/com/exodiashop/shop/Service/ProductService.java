package com.exodiashop.shop.Service;

import com.exodiashop.shop.DAO.ProductDAO;
import com.exodiashop.shop.DAO.UserDAO;
import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    ProductDAO productDAO;

    public ProductService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Module.xml");
        this.productDAO = (ProductDAO) context.getBean("productDAO");
    }

    public List<Product> getProductList(){
        return productDAO.getAllProducts();
    }


    public Product getProductByID(int id){
        return new Product();
    }
/*
    public List<Product> getProductByCategory(String category_name){
        return getProductList().stream().filter(t -> (t.getCategory_name().equals(category_name))).collect(Collectors.toList());
    }

    public List<Product> getProductByContainInName(String criteria){
        return getProductList().stream().filter(t -> (t.getCategory_name().contains(criteria))).collect(Collectors.toList());
    }
*/


}
