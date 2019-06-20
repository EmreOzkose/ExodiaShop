package com.exodiashop.shop.Service;

import com.exodiashop.shop.DAO.UserDAO;
import com.exodiashop.shop.Model.Order;
import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.Seller;
import com.exodiashop.shop.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Service
public class UserService {

    @Autowired
    private ProductService productService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private OrderService orderService;

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

    public List<Integer> getShoppingCartByUsernameInteger(String username){
        List<Product> shopping_cart = this.getShoppingCartByUsername(username);
        List<Integer> shopping_cart_int = new ArrayList<>();
        for (Product p : shopping_cart)
            shopping_cart_int.add(p.getId());
        return shopping_cart_int;
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

    public Boolean check_username(String username) {
        return userDao.check_username(username);
    }

    public Boolean check_email(String email){
        return userDao.check_email(email);
    }

    public void register(User user) {
        userDao.register(user);
    }

    public void cleanShoppingCart(String username){
        userDao.cleanShoppingCart(username);
    }

    /* View Functions */
    public ModelAndView userPage(ModelAndView mav, String username){
        User user = getUserByUserName(username);

        mav.addObject("loggedUser", user);
        mav.addObject("isEdit", 0);

        if (user.getRole().equals("seller")) {
            String arr[] = user.getUsername().split("\\.");
            int seller_id = sellerService.getSellerById(Integer.parseInt(arr[0])).getId();
            mav.addObject("product_list", productService.getProductBySellerId(seller_id));

            Seller seller = sellerService.getSellerById(seller_id);
            mav.addObject("seller", seller);

        }
        else if (user.getRole().equals("admin")){
            mav.addObject("user_list", getUserList());
            mav.addObject("product_list", productService.getProductList());
            mav.addObject("orderList", orderService.getUnconfirmedOrderList());
        }
        else if (user.getRole().equals("customer")){
            mav.addObject("orderList", orderService.getOrdersByUsername(username));
            for (Order o : orderService.getOrdersByUsername(username))
                System.out.println("id: " + o.getId() +"bool:"+o.isConfirmed());
        }

        mav.addObject("loggedUsername", username);

        return mav;
    }

    public String deleteUser(String username) {return userDao.deleteUser(username);}

}
