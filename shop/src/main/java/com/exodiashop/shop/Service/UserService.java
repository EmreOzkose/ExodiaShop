package com.exodiashop.shop.Service;

import com.exodiashop.shop.DAO.UserDAO;
import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void updateUser(String username, String newUsername, String newName, String newSurname, String newEmail, String newPassword){
        userDao.updateUser(username, newUsername, newName, newSurname, newEmail, newPassword);
    }

    /*
    Shopping cart comes as a string (ex: "productID0,productID1")
    return : as a list of Product object
     */
    public List<Product> getShoppingCartByUsername(String username){
        List<Product> shopping_cart = new ArrayList<>();
        String shopping_cart_s = userDao.getShoppingCartByUsername(username);

        if (shopping_cart_s.contains(",")) {
            String[] splitted = shopping_cart_s.split(",");
            for (String s : splitted)
                shopping_cart.add(productService.getProductByID(Integer.parseInt(s)));
        }
        else if(!shopping_cart_s.equals("") && shopping_cart_s != null) {
            try{
                int productID = Integer.parseInt(shopping_cart_s);
                shopping_cart.add(productService.getProductByID(productID));
            } catch (Exception e){ /*Something is wrong, Do nothing*/ }
        }

        return shopping_cart;
    }

    public void add2cart(String username, String productID){
        userDao.add2cart(username, productID);
    }
    public void deleteFromShoppingCart(String username, String productID){
            userDao.deleteFromShoppingCart(username, productID);
     }

    public User validateUser(String username,String password) {
        return userDao.validateUser(username,password);
    }

    public boolean check_username(String username) {
        return userDao.check_username(username);
    }

    public boolean check_email(String email){
        return userDao.check_email(email);
    }

    public void register(User user) {
        userDao.register(user);
    }

    public String deleteUser(String username, String password) {return userDao.deleteUser(username,password);}

/*
    public void add2cart(String username, int productID){
        Product product = productService.getProductByID(productID);
        getUserList().stream().filter(t -> t.getUsername().equals(username)).findFirst().get().getShoppingCart().add(product);
    }


 */
}
