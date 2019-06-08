package com.exodiashop.shop.Controller;

import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Service.CookieService;
import com.exodiashop.shop.Service.OrderService;
import com.exodiashop.shop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
public class OrderController {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    CookieService cookieService = new CookieService();

    @RequestMapping("/confirmOrder/{orderID}")
    public ModelAndView confirmOrder(HttpServletRequest request, HttpServletResponse response, @PathVariable int orderID){
        ModelAndView mav = new ModelAndView("../redirections/to_profile.jsp");

        String loggedUsername = request.getParameter("loggedUser");
        User loggedUser = userService.getUserByUserName(loggedUsername);

        mav.addObject("loggedUsername", loggedUsername);
        mav.addObject("loggedUser", loggedUser);

        orderService.confirmOrder(orderID);

        return mav;
    }

    @RequestMapping("/finishOrder/{orderID}")
    public ModelAndView finishOrder(HttpServletRequest request, HttpServletResponse response, @PathVariable int orderID){
        ModelAndView mav = new ModelAndView("../redirections/to_profile");
        orderService.finisOrder(orderID);

        return mav;
    }

}
