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
import java.io.UnsupportedEncodingException;
import java.util.List;


@Controller
public class DashboardController {

    @Autowired
    UserService userService;

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

    @RequestMapping(value = "/dashboard", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView listItems(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        String loggedUserName = request.getParameter("loggedUsername");
        //String loggedUserName = "2.yetkili";
        User loggedUser = userService.getUserByUserName(loggedUserName);
        List<Product> product_list = productService.getProductList();

        ModelAndView mav = null;
        mav = new ModelAndView("dashboard");
        mav.addObject("product_list", product_list);

        if (null != loggedUser) {
            mav.addObject("loggedUser", loggedUser);
            mav.addObject("loggedUsername", loggedUser.getUsername());
        }

        return mav;

    }

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
