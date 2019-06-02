package com.exodiashop.shop.Controller;

import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.Seller;
import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Service.ProductService;
import com.exodiashop.shop.Service.SellerService;
import com.exodiashop.shop.Service.UserService;
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



    // Mağaza(store) bilgisinde değişiklij yapılacaksa burada ki location bilgisi değiştirilmemeli

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
            User u = userService.getUserByUserName(request.getParameter("loggedUsername"));
            String  arr[]= u.getUsername().split("\\.");
            int seller_id = sellerService.getSellerById(Integer.parseInt(arr[0])).getId();
            return sellerService.deleteSeller(seller_id);
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

    @RequestMapping("/addStore")
    public boolean addStore (HttpServletRequest request, HttpServletResponse response, @PathVariable String id){
        String store = request.getParameter("locations");
        User u = userService.getUserByUserName(request.getParameter("loggedUsername"));
        String  arr[]= u.getUsername().split("\\.");
        int seller_id = sellerService.getSellerById(Integer.parseInt(arr[0])).getId();
        return  sellerService.addStore(seller_id, store);
    }
    @RequestMapping("/deleteStore")
    public boolean deleteStore (HttpServletRequest request, HttpServletResponse response, @PathVariable String id){
        try {
            String store = request.getParameter("store");
            User u = userService.getUserByUserName(request.getParameter("loggedUsername"));
            String arr[] = u.getUsername().split("\\.");
            int seller_id = sellerService.getSellerById(Integer.parseInt(arr[0])).getId();
            return  sellerService.deleteStore(seller_id, store);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

                                        ////////////// OLD CODES////////////

/*    @RequestMapping("/sellers/deleteProduct/{id}")
    public boolean deleteProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
        try{
            String productId = request.getParameter("productId");
            return sellerService.deleteProduct(id, productId);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }*/

/*    @RequestMapping("/sellers/listProducts/{id}")
    public List<Product> listProducts(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
        try{
            return sellerService.listProductsById(Integer.parseInt(id));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            return null;
        }
    }*/

/*    @RequestMapping("/editProduct")
    public ModelAndView editProduct (HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("sellerView");
        User u = userService.getUserByUserName(request.getParameter("loggedUsername"));
        String  arr[]=  u.getUsername().split("\\.");
        int seller_id = sellerService.getSellerById(Integer.parseInt(arr[0])).getId();
*//*        mav.addObject("loggedUser", u);
        mav.addObject("product_list", productService.getProductBySellerId(seller_id));*//*
        return mav;
    }*/
/*
    @RequestMapping("/editProduct/{id}")
    public ModelAndView editProduct (HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("sellerView");

        User u = userService.getUserByUserName(request.getParameter("loggedUsername"));
        int seller_id = sellerService.getSellerById(Integer.parseInt(u.getUsername().split(".")[0])).getId();


        mav.addObject("loggedUser", u);
        mav.addObject("product_list", sellerService.listProductsById(seller_id));

        return mav;
    }
*/

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
