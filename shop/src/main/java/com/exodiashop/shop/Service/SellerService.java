package com.exodiashop.shop.Service;

import com.exodiashop.shop.DAO.SellerDAO;
import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.Seller;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@Service
public class SellerService {

    SellerDAO sellerDAO;

    public SellerService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Module.xml");
        this.sellerDAO = (SellerDAO) context.getBean("sellerDAO");
    }

    public List<Seller> getSellerList() { return sellerDAO.getAllSellers(); }
    public Seller getSellerById(int id) { return  sellerDAO.getSellerById(id);}
    public Seller getSellerByName(int id) { return  sellerDAO.getSellerById(id);}
    public List<Product> listProductsById(int id) { return  sellerDAO.listProductsById(id); }
    public String updateSellerProfile(String id, String name, String locations, String password){
        return  sellerDAO.updateSellerProfile(id, name, locations, password);
    }
    public boolean addSeller(String name, String locations, String password){ return sellerDAO.addSeller(name,locations,password);}
    public boolean deleteSeller(String id){return sellerDAO.deleteSeller(id);}

}
