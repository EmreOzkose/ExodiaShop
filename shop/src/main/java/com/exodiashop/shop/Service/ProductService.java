package com.exodiashop.shop.Service;

import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> productList = new ArrayList<Product>( Arrays.asList(
                    new Product(1, "black shoes", 154, "/img/products/accessory/1.jpg", 14),
                    new Product(2, "blue shoes", 462, "/img/products/accessory/2.jpg", 53),
                    new Product(3, "crazy clothe", 56, "/img/products/clothes/1.jpeg", 8)
            )
    );

    public List<Product> getProductList(){
        return productList;
    }


    public Product getProductByID(int id){
        return getProductList().stream().filter(t -> (t.getId() == id)).findFirst().get();
    }


}
