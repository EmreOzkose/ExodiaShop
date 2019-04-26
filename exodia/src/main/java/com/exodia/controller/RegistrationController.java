package com.exodia.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exodia.model.User;
import com.exodia.service.UserService;
import com.exodia.validator.UserValidator;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;


@Controller
public class RegistrationController {
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
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors() == true) {
          return new ModelAndView("register");
        }
        userService.register(user);
        ModelAndView mav =new ModelAndView("mainbeforelogin");
        return mav.addObject( "name", user.getName());
    }
}
