package com.exodiashop.shop.Controller;


import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.Seller;
import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Service.ProductService;
import com.exodiashop.shop.Service.SellerService;
import com.exodiashop.shop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Autowired
    SellerService sellerService;

    @RequestMapping(value = "/product/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView viewProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) {
        ModelAndView mav = null;

        String loggedUsername = request.getParameter("loggedUsername");
        System.out.println("in pr cont");
        System.out.println(loggedUsername);
        User loggedUser = userService.getUserByUserName(loggedUsername);
        Product product = productService.getProductByID(id);

        if (product != null) {
            mav = new ModelAndView("product");
            mav.addObject("product", product);
            mav.addObject("loggedUser", loggedUser);
            mav.addObject("loggedUsername", loggedUsername);
        }
        else{
            mav = new ModelAndView("404");
        }

        return mav;
    }


    @RequestMapping(value = "/categories/{category_name}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView viewCategory(HttpServletRequest request, HttpServletResponse response, @PathVariable String category_name) {
        ModelAndView mav = null;

        List<Product> product_list = productService.getProductByCategory(category_name);

        System.out.println("in pro: " + request.getParameter("loggedUsername"));
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

        String loggedUsername = request.getParameter("loggedUsername");
        User loggedUser = userService.getUserByUserName(loggedUsername);

        ModelAndView mav = new ModelAndView("../redirections/to_profile_product");

        mav.addObject("loggedUser", loggedUser);
        mav.addObject("loggedUsername", loggedUsername);
        return mav;
    }

    @RequestMapping("/addProduct/{loggedUsername}")
    public ModelAndView addProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable String loggedUsername) {
        String arr[] = loggedUsername.split("\\.");

        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");
        String type = request.getParameter("type");
        String category = request.getParameter("category");
        String size = request.getParameter("size");
        String price = request.getParameter("price");
        String total = request.getParameter("total");
        String img_path = request.getParameter("img_path");
        Seller s = sellerService.getSellerById(Integer.parseInt(arr[0]));

        productService.addProduct(s, name, gender,brand,color,type, category, size, price, total, img_path);

        ModelAndView mav = new ModelAndView("../redirections/to_profile_product");

        User loggedUser = userService.getUserByUserName(loggedUsername);
        mav.addObject("loggedUser", loggedUser);
        mav.addObject("loggedUsername", loggedUser.getUsername());

        return mav;
    }

}
