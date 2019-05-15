package com.exodiashop.shop.Controller;

import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.Seller;
import com.exodiashop.shop.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class SellerController {
    @Autowired
    private SellerService sellerService;


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

    @RequestMapping("/sellers/listProducts/{id}")
    public List<Product> listProducts(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
        try{
            return sellerService.listProductsById(Integer.parseInt(id));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/sellers/updateSellerProfile/{id}")
    public String updateSellerProfile(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
        try{
            String name = request.getParameter("name");
            String locations = request.getParameter("locations");
            String password = request.getParameter("password");
            return sellerService.updateSellerProfile(id, name, locations, password);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
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

    @RequestMapping("/sellers/addProduct/{id}")
    public boolean addProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
        try{
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
            return sellerService.addProduct(id, name, gender,brand,color,type, category, size, price, total, img_path);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("/sellers/deleteProduct/{id}")
    public boolean deleteProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
        try{
            String productId = request.getParameter("productId");
            return sellerService.deleteProduct(id, productId);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



/*
    @RequestMapping("/sellers/{id}")
    public ModelAndView viewUser(HttpServletRequest request, HttpServletResponse response, @PathVariable String id){
        ModelAndView mav = null;

        List<Product> products = sellerService.listProductsById(Integer.parseInt(id));

        mav = new ModelAndView("products");
        mav.addObject("product_list", products);
        return mav;
    }
*/




/*    @RequestMapping(method = RequestMethod.POST, value = "/sellers")
    public void addUser(@RequestBody Seller user){
        sellerService.addSeller(user);
    }*/


}
