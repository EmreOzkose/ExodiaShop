package com.exodiashop.shop.DAO;

import com.exodiashop.shop.Model.Order;
import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO extends JdbcDaoSupport{

    @Autowired
    DataSource datasource;

    public void placeAnOrder(String username, String shoppingCart){
        //int added_order_ind = Integer.parseInt(getJdbcTemplate().queryForObject("SELECT id FROM order ORDER BY id DESC LIMIT 1;", new Object[] {}, String.class));

        String sql = "insert into `order` (Customer, ProductIDs) values (?,?)";
        getJdbcTemplate().update(sql, username, shoppingCart);
    }

}

class OrderMapper implements RowMapper<Order> {

    public Order mapRow(ResultSet rs, int arg1) throws SQLException {
        Order o = new Order();


        return o;
    }
}