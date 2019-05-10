package com.exodiashop.shop.Service;

import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    List<Product> productList = new ArrayList<Product>( Arrays.asList(
                    new Product(1, "black accessory", 154, "accessory", "/img/products/accessory/1.jpg", 14),
                    new Product(2, "blue accessory", 462, "accessory","/img/products/accessory/2.jpg", 53),
                    new Product(3, "crazy clothe", 56, "clothes","/img/products/clothes/1.jpeg", 8)
            )
    );

    public List<Product> getProductList(){
        return productList;
    }


    public Product getProductByID(int id){
        return getProductList().stream().filter(t -> (t.getId() == id)).findFirst().get();
    }

    public List<Product> getProductByCategory(String category_name){
        return getProductList().stream().filter(t -> (t.getCategory_name().equals(category_name))).collect(Collectors.toList());
    }

    public void add2cart(){

    }


}
