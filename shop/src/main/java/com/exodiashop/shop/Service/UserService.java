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

    List<User> userList = new ArrayList<>( Arrays.asList(
            new User()
            )
    );

    public List<User> getUserList(){
        return userList;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


    public User getUserByUserName(String username){
        return getUserList().stream().filter(t -> t.getUsername().equals(username)).findFirst().get();
    }

    public void addUser(User user){
        userList.add(user);
    }

    public void updateUser(User user, String username){
        for (int i=0; i<userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username)) {
                userList.set(i, user);
                break;
            }
        }
    }

    public void add2cart(String username, int productID){
        Product product = productService.getProductByID(productID);
        getUserList().stream().filter(t -> t.getUsername().equals(username)).findFirst().get().getShoppingCart().add(product);
    }

}
