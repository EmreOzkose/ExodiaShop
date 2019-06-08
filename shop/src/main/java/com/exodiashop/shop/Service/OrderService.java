package com.exodiashop.shop.Service;

import com.exodiashop.shop.DAO.OrderDAO;
import com.exodiashop.shop.Model.Order;
import com.exodiashop.shop.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    OrderDAO orderDAO;

    public OrderService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Module.xml");
        this.orderDAO = (OrderDAO) context.getBean("orderDAO");
    }

    public void placeAnOrder(String username){
        // get shopping cart
        List<Product> shoppingCart_list = userService.getShoppingCartByUsername(username);

        // shopping cart list to string
        String shoppingCart = shoppingCartList2String(shoppingCart_list);

        orderDAO.placeAnOrder(username, shoppingCart);
    }

    public String shoppingCartList2String(List<Product> shoppingCart){

        if (shoppingCart.size() == 0)
            return "";

        if (shoppingCart.size() == 1)
            return Integer.toString(shoppingCart.get(0).getId());

        String shoppingCart_s = "";
        for (int i=0; i<shoppingCart.size();i++){
            if(i==0)
                shoppingCart_s = Integer.toString(shoppingCart.get(i).getId());
            else
                shoppingCart_s += ',' + Integer.toString(shoppingCart.get(i).getId());
        }
        return shoppingCart_s;
    }

    public void decreaseStock(List<Integer> productIds){
        for (int id : productIds){
            this.decreaseStock(id);
        }
    }

    public void decreaseStock(int productId){
        productService.decreaseStock(productId);
    }

    public List<Order> getUnconfirmedOrderList(){
        return orderDAO.getUnconfirmedOrderList();
    }

    public void confirmOrder(int orderID){
        orderDAO.confirmOrder(orderID);
    }

    public void finisOrder(int orderID){
        orderDAO.finisOrder(orderID);
    }

    public List<Order> getOrdersByUsername(String username){
        List<Order> orderList = orderDAO.getOrdersByUsername(username);
        return orderList;
    }

}
