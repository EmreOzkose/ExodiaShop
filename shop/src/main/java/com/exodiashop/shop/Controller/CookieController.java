package com.exodiashop.shop.Controller;

import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Service.CookieService;
import com.exodiashop.shop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CookieController {

    @Autowired
    UserService userService;

    CookieService cookieService = new CookieService();

    @RequestMapping(value = "/setLang/{lang}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView setLang(HttpServletRequest request, HttpServletResponse response, @PathVariable String lang){
        ModelAndView mav = new ModelAndView("../redirections/to_dashboard");

        request.setAttribute("lang", lang);

        String loggedUsername = request.getParameter("loggedUsername");
        User loggedUser = userService.getUserByUserName(loggedUsername);

        List<Product> product_list = userService.getShoppingCartByUsername(loggedUsername);
        mav.addObject("product_list", product_list);

        if (null != loggedUser) {
            mav.addObject("loggedUser", loggedUser);
            mav.addObject("loggedUsername", loggedUsername);
        }
        mav.addObject("lang", lang);

        return mav;
    }
}
