package com.exodiashop.shop.Controller;


import com.exodiashop.shop.Model.Comment;
import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.Seller;
import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Service.CommentService;
import com.exodiashop.shop.Service.ProductService;
import com.exodiashop.shop.Service.SellerService;
import com.exodiashop.shop.Service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @Autowired
    SellerService sellerService;

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/product/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView viewProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) {
        ModelAndView mav = null;

        String loggedUsername = request.getParameter("loggedUsername");
        System.out.println("in pr cont");
        System.out.println(loggedUsername);
        User loggedUser = userService.getUserByUserName(loggedUsername);
        Product product = productService.getProductByID(id);

        List<Comment> commentList = commentService.getCommentsByProductID(product.getId());
        System.out.println("in pr co comment");
        for (Comment c :commentList)
            System.out.println(c.getText());

        if (product != null) {
            mav = new ModelAndView("product");
            mav.addObject("product", product);
            mav.addObject("loggedUser", loggedUser);
            mav.addObject("loggedUsername", loggedUsername);
            mav.addObject("commentList", commentList);
        }
        else{
            mav = new ModelAndView("404");
        }

        return mav;
    }


    @RequestMapping(value = "/categories/{category_name}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView viewCategory(HttpServletRequest request, HttpServletResponse response, @PathVariable String category_name) {
        ModelAndView mav = null;

        List<Product> product_list = productService.getProductByCategory(category_name);

        System.out.println("in pro: " + request.getParameter("loggedUsername"));
        User loggedUser = userService.getUserByUserName(request.getParameter("loggedUsername"));


        if (product_list != null) {
            mav = new ModelAndView("category");
            mav.addObject("product_list", product_list);
            mav.addObject("category_name", category_name);
            mav.addObject("loggedUser", loggedUser);

        }
        else{
            mav = new ModelAndView("404");
        }

        return mav;
    }

    @RequestMapping("/deleteProduct/{id}")
    public ModelAndView deleteProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable String id){
        productService.deleteProductByID(Integer.parseInt(id));

        String loggedUsername = request.getParameter("loggedUsername");
        User loggedUser = userService.getUserByUserName(loggedUsername);

        ModelAndView mav = new ModelAndView("../redirections/to_profile_product");

        mav.addObject("loggedUser", loggedUser);
        mav.addObject("loggedUsername", loggedUsername);
        return mav;
    }

    @RequestMapping("/addProduct/{loggedUsername}")
    public ModelAndView addProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable String loggedUsername) {
        String arr[] = loggedUsername.split("\\.");

        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");
        String type = request.getParameter("type");
        String category = request.getParameter("category");
        String size = request.getParameter("size");
        String price = request.getParameter("price");
        String total = request.getParameter("total");
        String img_path = request.getParameter("img_path");
        Seller s = sellerService.getSellerById(Integer.parseInt(arr[0]));

        productService.addProduct(s, name, gender,brand,color,type, category, size, price, total, img_path);

        ModelAndView mav = new ModelAndView("../redirections/to_profile_product");

        User loggedUser = userService.getUserByUserName(loggedUsername);
        mav.addObject("loggedUser", loggedUser);
        mav.addObject("loggedUsername", loggedUser.getUsername());

        return mav;
    }

    @RequestMapping("/editProduct/{productID}")
    public ModelAndView ediProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable int productID){
        ModelAndView mav = new ModelAndView("../redirections/to_profile");

        String loggedUsername = request.getParameter("loggedUsername");

        System.out.println("in pro cont");
        System.out.println(request.getParameter("newName"));
        System.out.println(request.getParameter("newTotal"));
        System.out.println(request.getParameter("newPrice"));

        String newName = request.getParameter("newName");
        int newTotal = Integer.parseInt(request.getParameter("newTotal"));
        float newPrice = Float.parseFloat(request.getParameter("newPrice"));

        mav.addObject("loggedUsername", loggedUsername);

        productService.updateProduct(productID, newName, newTotal, newPrice);

        return mav;
    }

    @RequestMapping("/addLocation/{productID}")
    public ModelAndView addLocation (HttpServletRequest request, HttpServletResponse response, @PathVariable int productID) throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("user");
        String newLocation = request.getParameter("newLocation");

        String current_location = productService.getLocationByID(productID);

        if (current_location == null || current_location.equals("")){
            productService.updateLocation2Product(productID, newLocation);
        }
        else{
            newLocation = current_location + "," + newLocation;
            productService.updateLocation2Product(productID, newLocation);
        }

        mav = userService.userPage(mav, request.getParameter("loggedUsername"));

        request.setAttribute("alertMsg", "Location is added");
        RequestDispatcher rd=request.getRequestDispatcher("user");
        rd.include(request, response);
        return mav;
    }

    @RequestMapping("/deleteLocation/{productID}")
    public ModelAndView deleteLocation (HttpServletRequest request, HttpServletResponse response, @PathVariable int productID) throws ServletException, IOException {
        ModelAndView mav = new ModelAndView("user");

        String deletedLocation = request.getParameter("deletedLocation");
        String current_location = productService.getLocationByID(productID);

        String new_location = "";
        boolean is_deleted_any = false;
        String [] location_strings = current_location.split(",");
        for (int i=0;i<location_strings.length;i++){
            String s = location_strings[i];

            if (!s.equals(deletedLocation))
                new_location += s + ",";
            else
                is_deleted_any = true;
        }

        String final_loc = "";
        String [] arr = new_location.split(",");
        for(int i=0;i<arr.length; i++){
            if(i != arr.length-1)
                final_loc += arr[i] + ",";
        }
        final_loc+= arr[arr.length-1];

        if (is_deleted_any)
            productService.updateLocation2Product(productID, final_loc);
        else{
            request.setAttribute("alertMsg", "There is no location: '" + deletedLocation + "'");
            RequestDispatcher rd=request.getRequestDispatcher("user");
            rd.include(request, response);
        }

        mav = userService.userPage(mav, request.getParameter("loggedUsername"));

        return mav;
    }

}
