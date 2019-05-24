package com.exodiashop.shop.Controller;

import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Service.UserService;
import com.exodiashop.shop.Validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    public UserService userService;
    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new User());

        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView addUser(@Valid @ModelAttribute("user")  User user, BindingResult bindingResult) {
        ModelAndView mav = null;

        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());

            mav = new ModelAndView("register");
            mav.addObject( "error_message", "Something went wrong ! Please try again");
            return mav;
        }

        userService.register(user);
        mav =new ModelAndView("../redirections/to_dashboard");
        mav.addObject( "loggedUsername", user.getName());
        return mav;
    }

}
