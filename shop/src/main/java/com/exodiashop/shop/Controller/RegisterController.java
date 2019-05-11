package com.exodiashop.shop.Controller;

import com.exodiashop.shop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @RequestMapping("register")
    public String index() {
        return "register";
    }

    @RequestMapping("registerProcess")
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = null;

        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String password = request.getParameter("password");
        String dateofbirth = request.getParameter("dateofbirth");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phonenumber = request.getParameter("phonenumber");

        boolean correct = checkCorrectInfoForUser(username, name, surname, password, dateofbirth, gender, email, address, phonenumber);



        return mav;
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
