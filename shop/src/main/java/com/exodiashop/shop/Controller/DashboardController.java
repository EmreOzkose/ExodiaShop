package com.exodiashop.shop.Controller;


import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Service.ProductService;
import com.exodiashop.shop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private UserService userService;

    @Autowired
    ProductService productService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        List<Product> product_list = productService.getProductList();
        ModelAndView mav = null;

        mav = new ModelAndView("dashboard");
        mav.addObject("product_list", product_list);

        return mav;
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView listItems(HttpServletRequest request, HttpServletResponse response) {
        //User loggedUser = userService.getUserByUserName(request.getParameter("loggedUserName"));
        User loggedUser = userService.getUserByUserName("yunusemre123");
        List<Product> product_list = productService.getProductList();

        ModelAndView mav = null;

        if (null != loggedUser) {
            mav = new ModelAndView("dashboard");
            mav.addObject("loggedUser", loggedUser);
            mav.addObject("product_list", product_list);

        } else {
            mav = new ModelAndView("dashboard");
            mav.addObject("message", "Username or Password is wrong!!");
        }

        return mav;

    }
/*
    @RequestMapping("/add2cart")
    public String add2cart(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String productID = request.getParameter("productID");

        userService.add2cart(username, Integer.parseInt(productID));

        return "../redirections/to_dashboard";
    }


 */
    @RequestMapping(method = RequestMethod.GET, value = "/checkout/{username}")
    public ModelAndView checkout(HttpServletRequest request, HttpServletResponse response, @PathVariable String username){
        ModelAndView mav = new ModelAndView("checkout");

        mav.addObject("username", username);

        User user =  userService.getUserByUserName(username);
        List<Product> product_list = user.getShoppingCart();
        mav.addObject("product_list", product_list);

        return mav;
    }

}
