package com.exodiashop.shop.Controller;

import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Service.ProductService;
import com.exodiashop.shop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @RequestMapping("/search")
    public ModelAndView viewSearhResults(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = null;

        String criteria = request.getParameter("criteria");
        User loggedUser = userService.getUserByUserName(request.getParameter("loggedUsername"));
        List<Product> product_list = productService.getProductByContainInName(criteria);

        System.out.println("a: " + loggedUser);

        mav = new ModelAndView("search");
        mav.addObject("product_list", product_list);
        mav.addObject("loggedUser", loggedUser);



        return mav;
    }


}
