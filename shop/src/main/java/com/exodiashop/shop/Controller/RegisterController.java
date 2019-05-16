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
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("User") @Valid User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors() == true) {
            return new ModelAndView("register");
        }
        userService.register(user);
        ModelAndView mav =new ModelAndView("dashboard");
        return mav.addObject( "name", user.getName());
    }
    /**
     *
     * @param username
     * @param name
     * @param surname
     * @param password
     * @param dateofbirth
     * @param gender
     * @param email
     * @param address
     * @param phonenumber
     * @return true if all information are convenient, else false
     */
    public boolean checkCorrectInfoForUser(String username, String name, String surname, String password, String dateofbirth, String gender, String email, String address, String phonenumber){

        return true;
    }

    public boolean checkEmail(){
        return true;
    }
}
