package com.exodiashop.shop.Controller;


import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Service.ProductService;
import com.exodiashop.shop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.Cookie;

@Controller
public class UserController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userService.getUserList();
    }

    @RequestMapping("/users/{username}")
    public ModelAndView viewUser(HttpServletRequest request, HttpServletResponse response, @PathVariable String username){
        ModelAndView mav = null;

        User user = userService.getUserByUserName(username);

        mav = new ModelAndView("user");
        mav.addObject("loggedUser", user);
        mav.addObject("isEdit", 0);
        mav.addObject("product_list", productService.getProductList());
        for(User u:userService.getUserList())
            System.out.println(u.getUsername());
        mav.addObject("user_list", userService.getUserList());
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }


    @RequestMapping("/adminView")
    public ModelAndView adminView(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = null;

        User loggedUser = userService.getUserByUserName(request.getParameter("loggedUsername"));

        mav = new ModelAndView("adminView");
        mav.addObject("loggedUser", loggedUser);
        mav.addObject("isEdit", 0);

        return mav;
    }

    /*import java.io.File;
    File dir = new File("./src/main/webapp/WEB-INF/pages/");
    File[] filesList = dir.listFiles();
        for (File file : filesList) {
        if (file.isFile()) {
            System.out.println(file.getName());
        }
    }*/



}
