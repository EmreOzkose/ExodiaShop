package com.exodiashop.shop.Controller;

import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Service.OrderService;
import com.exodiashop.shop.Service.ProductService;
import com.exodiashop.shop.Service.SellerService;
import com.exodiashop.shop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ShoppingController {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    SellerService sellerService;

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/shoppingCart", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView viewShoppingCart(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("shoppingCart");

        String loggedUsername = request.getParameter("loggedUsername");
        User loggedUser = userService.getUserByUserName(loggedUsername);

        List<Product> product_list = userService.getShoppingCartByUsername(loggedUsername);
        mav.addObject("product_list", product_list);
        float total  = 0;
        for (Product p : product_list)
            total += p.getPrice();
        mav.addObject("total", total);

        if (null != loggedUser) {
            mav.addObject("loggedUser", loggedUser);
            mav.addObject("loggedUsername", loggedUsername);
        }

        return mav;
    }

    @RequestMapping(value = "/add2cart", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView add2cart(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("../redirections/to_dashboard");

        String loggedUsername = request.getParameter("loggedUsername");
        User loggedUser = userService.getUserByUserName(loggedUsername);
        String productID = request.getParameter("productID");

        if (null != loggedUser) {
            mav.addObject("loggedUser", loggedUser);
            mav.addObject("loggedUsername", loggedUsername);
        }

        userService.add2cart(loggedUsername, productID);

        return mav;
    }

    @RequestMapping(value = "/deleteFromShoppingCart", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView deleteFromShoppingCart(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("../redirections/to_shoppingCart");

        String loggedUsername = request.getParameter("loggedUsername");
        User loggedUser = userService.getUserByUserName(loggedUsername);
        String productID = request.getParameter("productID");

        if (null != loggedUser) {
            mav.addObject("loggedUser", loggedUser);
            mav.addObject("loggedUsername", loggedUsername);
        }

        userService.deleteFromShoppingCart(loggedUsername, productID);

        return mav;
    }

    @RequestMapping(value = "/payment", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView payment(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("payment");
        User loggedUser = userService.getUserByUserName(request.getParameter("loggedUsername"));
        mav.addObject("loggedUsername", request.getParameter("loggedUsername"));
        mav.addObject("loggedUser", loggedUser);

        return mav;
    }

    @RequestMapping(value = "/paymentProcess", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView paymenProcess(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("../redirections/to_dashboard");

        String loggedUsername = request.getParameter("loggedUsername");
        User loggedUser = userService.getUserByUserName(loggedUsername);

        String cvv = request.getParameter("cvv");
        String expyear = request.getParameter("expyear");
        String expmonth = request.getParameter("expmonth");
        String cardnumber = request.getParameter("cardnumber");
        String cardname = request.getParameter("cardname");

        // TODO: Card Validation
        // - Check user's mony is enough or not
        // - etc ..

        // place an order
        orderService.placeAnOrder(loggedUsername);

        // decrease stock from "product" table
        List<Integer> productIds = userService.getShoppingCartByUsernameInteger(loggedUsername);
        orderService.decreaseStock(productIds);

        // clean shopping cart of "user"
        userService.cleanShoppingCart(loggedUsername);

        // add price to seller wallet
        for (int productID : productIds){
            System.out.println(productID);
            Product p = productService.getProductByID(productID);
            System.out.println(p.getName());
            System.out.println(p.getPrice());
            sellerService.add2wallet(Integer.parseInt(p.getSeller()), (float)p.getPrice());
        }

        mav.addObject("loggedUsername", request.getParameter("loggedUsername"));
        mav.addObject("loggedUser", loggedUser);
        mav.addObject("lang", request.getParameter("lang"));

        return mav;
    }

    @RequestMapping("/shoppingHistory")
    public ModelAndView viewShoppingHistory(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("shoppingHistory");

        String loggedUsername = request.getParameter("loggedUsername");
        User loggedUser = userService.getUserByUserName(loggedUsername);

        mav.addObject(loggedUsername);
        mav.addObject(loggedUser);

        return mav;
    }

}
