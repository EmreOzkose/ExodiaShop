package com.exodiashop.shop.Controller;


import com.exodiashop.shop.Model.User;

import com.exodiashop.shop.Service.ProductService;
import com.exodiashop.shop.Service.UserService;
import com.exodiashop.shop.Validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    @Autowired
    UserValidator userValidator;

    @RequestMapping(value = "/adminview")
    public ModelAndView AddUserProcess(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = null;

        mav =new ModelAndView("AdminPage");
        mav.addObject("user_list", userService.getUserList());
        mav.addObject("product_list", productService.getProductList());
        return mav;

    }

    @RequestMapping(value = "/AddUser", method = RequestMethod.POST)
    public ModelAndView AddUserProcess(HttpServletRequest request, HttpServletResponse response, @Valid User user, BindingResult bindingResult) {
        ModelAndView mav = null;
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors() == true) {
            /*adminpage degiscek*/
            mav = new ModelAndView("AdminPage");
            return mav;
        }else{
            userService.addUser(user);
            /*adminpage degiscek*/
            mav =new ModelAndView("AdminPage");
            return mav;
        }

    }
    @RequestMapping(value = "/ListUser", method = RequestMethod.POST)
    public String ListUserProcess(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute(userService.getUserList());

        return "ListUser";

    }
    @RequestMapping(value = "/UpdateUser", method = RequestMethod.POST)
    public String UpdateUserProcess(HttpServletRequest request, HttpServletResponse response) {
        userService.updateUser(request.getParameter("username") , request.getParameter("newUsername") ,request.getParameter("newName") , request.getParameter("newSurname") , request.getParameter("newEmail") , request.getParameter("newPassword") );
        return "UpdateUser";
    }
    /*@RequestMapping(value = "/DeleteUser", method = RequestMethod.POST)
    public String DeleteUserProcess(Model model ,HttpServletRequest request, HttpServletResponse response) {
        return userService.deleteUser(request.getParameter("username"),request.getParameter("password"));
    }*/

    @RequestMapping(value = "/AddProduct", method = RequestMethod.POST)
    public ModelAndView AddProductProcess(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = null;
        //productService.addproduct();
        return mav;
    }

    @RequestMapping(value = "/ListProduct", method = RequestMethod.POST)
    public String ListProductProcess(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute(productService.getProductList());
        return "ListProduct";
    }

    @RequestMapping(value = "/UpdateProduct", method = RequestMethod.POST)
    public String UpdateProductProcess(Model model,HttpServletRequest request, HttpServletResponse response) {
        //userService.updateUser(request.getParameter("username") , request.getParameter("newUsername") ,request.getParameter("newName") , request.getParameter("newSurname") , request.getParameter("newEmail") , request.getParameter("newPassword") );
        //productService.updateProduct();
        return "UpdateUser";
    }
    @RequestMapping(value = "/DeleteProduct", method = RequestMethod.POST)
    public String DeleteProductProcess(HttpServletRequest request, HttpServletResponse response) {
        return "deleted";
        //return userService.deleteUser(request.getParameter("username"),request.getParameter("password"));
    }

    @RequestMapping(value = "/ListOrders", method = RequestMethod.POST)
    public ModelAndView ListOrdersProcess(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = null;
        return mav;
    }
    @RequestMapping(value = "/CancelOrders", method = RequestMethod.POST)
    public ModelAndView CancelOrdersProcess(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = null;
        return mav;
    }
}
