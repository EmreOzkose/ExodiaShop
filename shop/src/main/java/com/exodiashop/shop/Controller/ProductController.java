package com.exodiashop.shop.Controller;


import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Service.ProductService;
import com.exodiashop.shop.Service.UserService;
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

    @Autowired
    UserService userService;


    @RequestMapping("/product/{id}")
    public ModelAndView viewProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) {
        ModelAndView mav = null;

        Product product = productService.getProductByID(id);

        if (product != null) {
            mav = new ModelAndView("product");
            mav.addObject("product", product);
            mav.addObject("loggedUser", request.getParameter("loggedUser"));
        }
        else{
            mav = new ModelAndView("404");
        }

        return mav;
    }


    @RequestMapping("/categories/{category_name}")
    public ModelAndView viewCategory(HttpServletRequest request, HttpServletResponse response, @PathVariable String category_name) {
        ModelAndView mav = null;

        List<Product> product_list = productService.getProductByCategory(category_name);

        User loggedUser = userService.getUserByUserName(request.getParameter("loggedUsername"));


        if (product_list != null) {
            mav = new ModelAndView("category");
            mav.addObject("product_list", product_list);
            mav.addObject("category_name", category_name);
            mav.addObject("loggedUser", loggedUser);

        }
        else{
            mav = new ModelAndView("404");
        }

        return mav;
    }

    @RequestMapping("/deleteProduct/{id}")
    public ModelAndView deleteProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable String id){
        productService.deleteProductByID(Integer.parseInt(id));

        ModelAndView mav = new ModelAndView("../redirections/to_sellerView");

        User loggedUser = userService.getUserByUserName(request.getParameter("loggedUsername"));
        mav.addObject("loggedUser", loggedUser);
        return mav;
    }

}
