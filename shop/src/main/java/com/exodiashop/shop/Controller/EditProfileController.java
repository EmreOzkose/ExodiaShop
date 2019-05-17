package com.exodiashop.shop.Controller;

import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class EditProfileController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/users/{username}/editProfile")
    public ModelAndView editProfile(HttpServletRequest request, HttpServletResponse response, @PathVariable String username){
        ModelAndView mav = new ModelAndView("user");

        User user = userService.getUserByUserName(username);

        mav.addObject("isEdit", 1);
        mav.addObject("loggedUser", user);

        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/{username}/editProfileProcess")
    public ModelAndView editProfileProcess(HttpServletRequest request, HttpServletResponse response, @PathVariable String username){
        ModelAndView mav = new ModelAndView("../redirections/to_profile");

        String newUsername = request.getParameter("newUsername");
        String newName = request.getParameter("newName");
        String newSurname = request.getParameter("newSurname");
        String newEmail = request.getParameter("newEmail");
        String newPassword = request.getParameter("newPassword");
        String newPasswordVal = request.getParameter("newPasswordVal");
        userService.updateUser(username, newUsername, newName, newSurname, newEmail, newPassword);

        mav.addObject("isEdit", 0);
        mav.addObject("loggedUser", userService.getUserByUserName(newUsername));
        mav.addObject("loggedUsername", newUsername);

        return mav;
    }
}
