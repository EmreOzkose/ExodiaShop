package com.exodiashop.shop.Controller;

import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView index(){

        ModelAndView mav = null;

        mav = new ModelAndView("login");
        mav.addObject("message", "Username or Password is wrong!!");

        return mav;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = null;

        // TODO: user validation

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Boolean is_valid_user = true;

        if (is_valid_user) {
            mav = new ModelAndView("dashboard");
            mav.addObject("username", username);
        }
        else{
            mav = new ModelAndView("login");
            mav.addObject("message", "Username or Password is wrong!!");
        }

        return mav;
    }

}
