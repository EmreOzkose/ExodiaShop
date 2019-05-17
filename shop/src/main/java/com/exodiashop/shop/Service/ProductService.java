package com.exodiashop.shop.Service;

import com.exodiashop.shop.DAO.ProductDAO;
import com.exodiashop.shop.DAO.UserDAO;
import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.Seller;
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
        return productDAO.getProductByID(id);
    }

    public List<Product> getProductByCategory(String category_name){
        return productDAO.getProductByCategory(category_name);
    }

    public List<Product> getProductByContainInName(String criteria){
        return productDAO.getAllProducts().stream().filter(t -> (t.getName().toLowerCase().contains(criteria))).collect(Collectors.toList());
    }

    public List<Product> getProductBySellerId(int seller_id){
        System.out.println("in service: "+seller_id);
        return productDAO.getProductBySellerId(seller_id);
    }

    public void  addProduct(Seller s , String name, String gender, String brand, String color, String type, String category
            , String size, String price, String total, String img_path) {
        productDAO.addProduct(s,name, gender, brand, color, type, category, size, price, total, img_path);

    }

    public void deleteProductByID(int id){
        boolean return_val = productDAO.deleteProduct(id);
    }

}
