package com.exodiashop.shop.Service;

import com.exodiashop.shop.DAO.UserDAO;
import com.exodiashop.shop.DAO.UserDAO;
import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.context.ApplicationContext;

@Service
public class UserService {

    @Autowired
    ProductService productService;

    UserDAO userDao;

    public UserService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Module.xml");
        this.userDao = (UserDAO) context.getBean("userDAO");
    }

    public List<User> getUserList(){
        return userDao.getAllUsers();
    }

    public User getUserByUserName(String username){
        return userDao.getUserByUsername((username));
    }

    public void addUser(User user){
        getUserList().add(user);
    }

    public void updateUser(String username, String newUsername){
        userDao.updateUser(username, newUsername);
    }
/*
    public void add2cart(String username, int productID){
        Product product = productService.getProductByID(productID);
        getUserList().stream().filter(t -> t.getUsername().equals(username)).findFirst().get().getShoppingCart().add(product);
    }


 */
}
