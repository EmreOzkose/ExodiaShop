/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exodia.controller;

import com.exodia.model.Login;
import com.exodia.model.Product;
import com.exodia.service.ProductService;
import com.exodia.service.UserService;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MSI
 */
public class ProductController {
  @Autowired
  ProductService productService;

  @RequestMapping(value = "/listItem", method = RequestMethod.GET)
  public ModelAndView listItem(HttpServletRequest request, HttpServletResponse response) {
    ArrayList<Product> products = productService.productlist();
    ModelAndView mav = new ModelAndView("mainbeforelogin");
    String name = products.get(0).getName();
    System.out.println(name);
        //for(int i=0; i<products.size(); i++){
            mav.addObject("name", products.get(0).getName());
            mav.addObject("price", String.valueOf(products.get(0).getPrice()));
        //}
    return mav;
  }
    
    
    
}
