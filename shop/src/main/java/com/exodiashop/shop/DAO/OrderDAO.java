package com.exodiashop.shop.DAO;

import com.exodiashop.shop.Model.Order;
import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.Seller;
import com.exodiashop.shop.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDAO extends JdbcDaoSupport{

    @Autowired
    DataSource datasource;

    /*
    customer process
     */
    public void placeAnOrder(String username, String shoppingCart){
        //int added_order_ind = Integer.parseInt(getJdbcTemplate().queryForObject("SELECT id FROM order ORDER BY id DESC LIMIT 1;", new Object[] {}, String.class));

        String sql = "insert into `order` (Customer, ProductIDs) values (?,?)";
        getJdbcTemplate().update(sql, username, shoppingCart);
    }

    /*
    Admin process
     */
    public List<Order> getUnconfirmedOrderList(){
        String sql = "select * from `order` where isConfirmed=0";
        List<Order> orderList = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Order.class));


        return orderList;
    }

    /*
    admin process
     */
    public void confirmOrder(int orderID){
        String sql = "update `order` set isConfirmed=1 where id = ?";
        getJdbcTemplate().update(sql, orderID);
    }

    /*
    customer process
     */
    public List<Order> getOrdersByUsername(String username){
        String sql = "select * from `order` where Customer='" + username + "'";
        List<Order> orderList = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Order.class));

        return orderList;
    }

}

class OrderMapper implements RowMapper<Order> {

    public Order mapRow(ResultSet rs, int arg1) throws SQLException {
        Order o = new Order();


        return o;
    }
}