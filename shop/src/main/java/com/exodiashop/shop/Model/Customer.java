package com.exodiashop.shop.Model;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Customer extends User{

    private List<Product> shopping_cart;

    public Customer(){
        shopping_cart = new ArrayList<>();

    }
}
