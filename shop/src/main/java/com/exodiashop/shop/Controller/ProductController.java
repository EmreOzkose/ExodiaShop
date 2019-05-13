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
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public String index(){
        List<Product> productList = productService.getProductList();
        for (Product p : productList)
            System.out.println(p.getName());

        return "";
    }

/*
    @RequestMapping("/product/{id}")
    public ModelAndView viewProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) {
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
*/
/*
    @RequestMapping("/categories/{category_name}")
    public ModelAndView viewCategory(HttpServletRequest request, HttpServletResponse response, @PathVariable String category_name) {
        ModelAndView mav = null;

        List<Product> product_list = productService.getProductByCategory(category_name);

        if (product_list != null) {
            mav = new ModelAndView("category");
            mav.addObject("product_list", product_list);
            mav.addObject("category_name", category_name);
        }
        else{
            mav = new ModelAndView("404");
        }

        return mav;
    }
*/
}
