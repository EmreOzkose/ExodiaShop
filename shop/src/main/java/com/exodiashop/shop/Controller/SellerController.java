package com.exodiashop.shop.Controller;

import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.Seller;
import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Service.ProductService;
import com.exodiashop.shop.Service.SellerService;
import com.exodiashop.shop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/sellers")
    public List<Seller> getAllSellers() {
        return sellerService.getSellerList();
    }

    @RequestMapping("/sellers/{id}")
    public Seller getSellerById(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
        try{
            return sellerService.getSellerById(Integer.parseInt(id));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/sellers/updateSellerProfile/{username}")
    public ModelAndView updateSellerProfile(HttpServletRequest request, HttpServletResponse response, @PathVariable String username) {
        ModelAndView mav = new ModelAndView("user");

        try{
            User seller = userService.getUserByUserName(username);
            System.out.println(username);
            String id = username.split("\\.")[0];

            String name = request.getParameter("newName");
            String locations = sellerService.getSellerById(Integer.parseInt(id)).getLocations();
            String password = request.getParameter("newPassword");

            String message = sellerService.updateSellerProfile(id, name, locations, password);
            request.setAttribute("alertMsg", message);
            RequestDispatcher rd=request.getRequestDispatcher("user");
            rd.include(request, response);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

        mav.addObject("isEdit", 0);
        mav.addObject("loggedUser", userService.getUserByUserName(username));
        mav.addObject("loggedUsername", username);

        return mav;
    }

    @RequestMapping("/sellers/addSeller")
    public boolean addSeller(HttpServletRequest request, HttpServletResponse response) {
        try{
            String name = request.getParameter("name");
            String locations = request.getParameter("locations");
            String password = request.getParameter("password");
            return sellerService.addSeller( name, locations, password);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("/sellers/deleteSeller/{id}")
    public boolean deleteSeller(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
        try{
            return sellerService.deleteSeller(id);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    @RequestMapping("/sellerView")
    public ModelAndView sellerView (HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("sellerView");

        User u = userService.getUserByUserName(request.getParameter("loggedUsername"));
        String  arr[]= u.getUsername().split("\\.");
        int seller_id = sellerService.getSellerById(Integer.parseInt(arr[0])).getId();

        mav.addObject("loggedUser", u);
        mav.addObject("product_list", productService.getProductBySellerId(seller_id));
        return mav;
    }

}
