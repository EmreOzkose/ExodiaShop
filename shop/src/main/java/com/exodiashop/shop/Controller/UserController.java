package com.exodiashop.shop.Controller;


import com.exodiashop.shop.Model.Order;
import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Service.OrderService;
import com.exodiashop.shop.Service.ProductService;
import com.exodiashop.shop.Service.SellerService;
import com.exodiashop.shop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private OrderService orderService;


    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userService.getUserList();
    }

    @RequestMapping("/users/{username}")
    public ModelAndView viewUser(HttpServletRequest request, HttpServletResponse response, @PathVariable String username){
        ModelAndView mav = new ModelAndView("user");

        User user = userService.getUserByUserName(username);

        mav.addObject("loggedUser", user);
        mav.addObject("isEdit", 0);

        if (user.getRole().equals("seller")) {
            String arr[] = user.getUsername().split("\\.");
            int seller_id = sellerService.getSellerById(Integer.parseInt(arr[0])).getId();
            mav.addObject("product_list", productService.getProductBySellerId(seller_id));
        }
        else if (user.getRole().equals("admin")){
            mav.addObject("user_list", userService.getUserList());
            mav.addObject("product_list", productService.getProductList());
            mav.addObject("orderList", orderService.getUnconfirmedOrderList());
        }
        else if (user.getRole().equals("customer")){
            mav.addObject("orderList", orderService.getOrdersByUsername(username));
            for (Order o : orderService.getOrdersByUsername(username))
                System.out.println("id: " + o.getId() +"bool:"+o.isConfirmed());
        }

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
