package com.exodiashop.shop.Controller;


import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Service.ProductService;
import com.exodiashop.shop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String index(){

        return "dashboard";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView listItems(HttpServletRequest request, HttpServletResponse response) {
        User user = userService.getUserList().get(0);
        List<Product> product_list = productService.getProductList();

        ModelAndView mav = null;

        if (null != user) {
            mav = new ModelAndView("dashboard");
            mav.addObject("name", user.getName());
            mav.addObject("product_list", product_list);

        } else {
            mav = new ModelAndView("dashboard");
            mav.addObject("message", "Username or Password is wrong!!");
        }

        return mav;

    }


}
