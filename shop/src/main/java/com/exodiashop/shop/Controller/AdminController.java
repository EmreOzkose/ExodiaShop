package com.exodiashop.shop.Controller;


import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.Seller;
import com.exodiashop.shop.Model.User;
import com.exodiashop.shop.Model.Order;

import com.exodiashop.shop.Service.OrderService;
import com.exodiashop.shop.Service.ProductService;
import com.exodiashop.shop.Service.UserService;
import com.exodiashop.shop.Validator.ProductValidator;
import com.exodiashop.shop.Validator.UserValidator;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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


    @RequestMapping(value = "/DeleteUser", method = RequestMethod.POST)
    public ModelAndView DeleteUserProcess(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("../redirections/to_profile");

        String deletedUser = request.getParameter("deletedUser");
        String loggedUsername = request.getParameter("loggedUsername");

        userService.deleteUser(deletedUser);
        userService.userPage(mav, loggedUsername);

        return mav;
    }

    @RequestMapping(value = "/generateSaleReport", method = RequestMethod.POST)
    public ModelAndView GenerateSaleReport(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("../redirections/to_profile");
        Document document = new Document();

        response.setContentType("application/pdf");

        try{
            if(true){
                response.setContentType("application/pdf");
                PdfWriter.getInstance(document,response.getOutputStream());
            }
            List<Order> list1= orderService.getOrderlist();
            document.open();

            /* new paragraph instance initialized and add function write in pdf file*/
            document.add(new Paragraph("---------------------------------------------------------REPORT---------------------------------------------------------\n\n"));
            document.add(new Paragraph("                              CREATED REPORT BY-ADMIN\n\n"));
            document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------"));
            document.addCreationDate();

            for (Order var: list1) {
                document.add(new Paragraph("ORDERID ::"+var.getId()+"\nCUSTOMER :"+var.getCustomer()+"\nPRODUCTID :"+var.getProductIDs()+"\nISCONFİRMED :"+var.isConfirmed()+"\nISFINISHED ::"+var.isFinished()+"\n\n"));
            }
            document.add(new Paragraph("---------------------------------------------------------PAGE NO::"+document.getPageNumber()+"------------------------------------------------------"));

            document.close();

        } catch (DocumentException e)
        {
            e.printStackTrace();
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mav;
    }

    @RequestMapping(value = "/ListOrders", method = RequestMethod.POST)
    public ModelAndView ListOrdersProcess(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("AdminPage");
        mav.addObject(orderService.getOrderlist());
        return mav;
    }

}