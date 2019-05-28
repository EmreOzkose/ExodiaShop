package com.exodiashop.shop.Controller;


import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.Seller;
import com.exodiashop.shop.Model.User;

import com.exodiashop.shop.Service.OrderService;
import com.exodiashop.shop.Service.ProductService;
import com.exodiashop.shop.Service.UserService;
import com.exodiashop.shop.Validator.ProductValidator;
import com.exodiashop.shop.Validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;
    @Autowired
    UserValidator userValidator;
    @Autowired
    ProductValidator productValidator;


    @RequestMapping(value = "/AddUser", method = RequestMethod.POST)
    public ModelAndView AddUserProcess(HttpServletRequest request, HttpServletResponse response, @Valid User user, BindingResult bindingResult) {
        ModelAndView mav;
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors() == true) {
            /*adminpage degiscek*/
            mav = new ModelAndView("AdminPage");
        }else{
            userService.addUser(user);
            /*adminpage degiscek*/
            mav =new ModelAndView("AdminPage");
        }
        return mav;
    }
    /*Ana Sayfaya yonlendirip sayfayi tablo ile doldurup ekrana yansitir*/
    @RequestMapping(value = "/ListUser", method = RequestMethod.POST)
    public ModelAndView ListUserProcess(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("AdminPage");
        mav.addObject(userService.getUserList());
        return mav;
    }
    /*kullanicinin bilgilerini aldıktan sonra guncellenmis listuser sayfasina gitsin,ui dan dolayı burasi degisebilir*/
    @RequestMapping(value = "/UpdateUser", method = RequestMethod.POST)
    public ModelAndView UpdateUserProcess(HttpServletRequest request, HttpServletResponse response) {
        /*checking input , eger hata olursa hata yazısı bastırılır liste sıralanır , burdaki kod sayfa yapısına göre degisebilir*/
        if(userService.check_username(request.getParameter("newUsername")) == true || userService.check_email(request.getParameter("newEmail")) == true){
            /*metodu cagırmak istedim illa mapping vari bise lazımsa degisir*/

            /*degiscek*/
            System.out.println("give an error");
        }
        else{
            userService.updateUser(request.getParameter("username") , request.getParameter("newUsername") ,request.getParameter("newName") , request.getParameter("newSurname") , request.getParameter("newEmail") , request.getParameter("newPassword") );
            /*metodu cagırmak istedim illa mapping vari bise lazımsa degisir*/

        }
        return ListUserProcess(request,response);
    }
    @RequestMapping(value = "/DeleteUser", method = RequestMethod.POST)
    public ModelAndView DeleteUserProcess(HttpServletRequest request, HttpServletResponse response) {
        userService.deleteUser(request.getParameter("username"),request.getParameter("password"));
        return ListUserProcess(request,response);
    }

    @RequestMapping(value = "/AddProduct", method = RequestMethod.POST)
    public ModelAndView AddProductProcess(HttpServletRequest request, HttpServletResponse response, @Valid Product product, BindingResult bindingResult) {
        ModelAndView mav;
        productValidator.validate(product,bindingResult);

        if (bindingResult.hasErrors() == true) {
            /*degiscek*/
            System.out.println("give an error");
        }else{
            /*parametre öylesine yazıldı uiden nasıl geldigini bilmiyorum*/
            /*(Seller s , String name, String gender, String brand, String color, String type, String category, String size, String price, String total, String img_path)*/
            /*casting var iptal edilebilinir*/
            productService.addProduct((Seller) request.getAttribute("Seller"),request.getParameter("name"),request.getParameter("gender"),request.getParameter("brand"),request.getParameter("color"),request.getParameter("type"),request.getParameter("category"),request.getParameter("size"),request.getParameter("price"),request.getParameter("total"),request.getParameter("imgpath"));
        }
        return ListProductProcess(request,response);
    }
    @RequestMapping(value = "/ListProduct", method = RequestMethod.POST)
    public ModelAndView ListProductProcess(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("AdminPage");
        mav.addObject(productService.getProductList());
        return mav;
    }
    @RequestMapping(value = "/UpdateProduct", method = RequestMethod.POST)
    public ModelAndView UpdateProductProcess(HttpServletRequest request, HttpServletResponse response) {
        /*checking input , eger hata olursa hata yazısı bastırılır liste sıralanır , burdaki kod sayfa yapısına göre degisebilir*/
        /*productDao doldurulacak ondan sonra bura düzenlencek*/
        if(true){
            /*degiscek*/
            System.out.println("give an error");
        }
        else{
            //productService.updateProduct();
            System.out.println("updated");
        }
        return ListProductProcess(request, response);
    }
    @RequestMapping(value = "/DeleteProduct", method = RequestMethod.POST)
    public ModelAndView DeleteProductProcess(HttpServletRequest request, HttpServletResponse response) {
        //productService.deleteProductByID();
        return ListProductProcess(request, response);
    }

    @RequestMapping(value = "/ListOrders", method = RequestMethod.POST)
    public ModelAndView ListOrdersProcess(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("AdminPage");
        //mav.addObject(orderService.getAllProduct());
        return mav;
    }
    @RequestMapping(value = "/CancelOrders", method = RequestMethod.POST)
    public ModelAndView CancelOrdersProcess(HttpServletRequest request, HttpServletResponse response) {
        //orderService.delete();
        return  ListOrdersProcess(request, response);
    }
}