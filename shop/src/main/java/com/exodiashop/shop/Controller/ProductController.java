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
       // productService.deleteProductByID(Integer.parseInt(id));

        int seller_id = Integer.parseInt(productService.getProductByID(Integer.parseInt(id)).getSeller());
        productService.deleteProduct(sellerService.getSellerById(seller_id), id);

        ModelAndView mav = new ModelAndView("../redirections/to_sellerView");

        User loggedUser = userService.getUserByUserName(request.getParameter("loggedUsername"));
        mav.addObject("loggedUser", loggedUser);
        return mav;
    }
    @RequestMapping("/addProduct/{loggedUsername}")
    public boolean addProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable String loggedUsername) {
        String arr[] = loggedUsername.split("\\.");
        try{
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
            Seller s = sellerService.getSellerById(Integer.getInteger(arr[0]));
            productService.addProduct(s, name, gender,brand,color,type, category, size, price, total, img_path);


            ModelAndView mav = new ModelAndView("../redirections/to_sellerView");

            User loggedUser = userService.getUserByUserName(request.getParameter("loggedUsername"));
            mav.addObject("loggedUser", loggedUser);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
