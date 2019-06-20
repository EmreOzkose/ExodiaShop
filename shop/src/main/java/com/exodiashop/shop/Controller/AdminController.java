package com.exodiashop.shop.Controller;


import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.Seller;
import com.exodiashop.shop.Model.User;

import com.exodiashop.shop.Service.OrderService;
import com.exodiashop.shop.Service.ProductService;
import com.exodiashop.shop.Service.UserService;
import com.exodiashop.shop.Validator.ProductValidator;
import com.exodiashop.shop.Validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;
    @Autowired
    UserValidator userValidator;
    @Autowired
    ProductValidator productValidator;


    @RequestMapping(value = "/DeleteUser", method = RequestMethod.POST)
    public ModelAndView DeleteUserProcess(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("../redirections/to_profile");

        String deletedUser = request.getParameter("deletedUser");
        String loggedUsername = request.getParameter("loggedUsername");

        userService.deleteUser(deletedUser);
        userService.userPage(mav, loggedUsername);

        return mav;
    }

    @RequestMapping(value = "/ListOrders", method = RequestMethod.POST)
    public ModelAndView ListOrdersProcess(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("AdminPage");
        mav.addObject(orderService.getOrderlist());
        return mav;
    }

}