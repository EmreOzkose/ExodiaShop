package com.exodiashop.shop.Controller;


import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/product/{id}")
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) {
        ModelAndView mav = null;

        Product product = productService.getProductByID(id);

        if (product != null) {
            mav = new ModelAndView("product");
            mav.addObject("product", product);
        }
        else{
            mav = new ModelAndView("404");
        }

        return mav;
    }

}
