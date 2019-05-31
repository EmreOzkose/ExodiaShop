package com.exodiashop.shop.DAO;

import com.exodiashop.shop.Model.Order;
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

    public List<Order> getAllOrder() {
        String sql = "select * from order";
        List<Order> order_list = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Order.class));

        return order_list;
    }

    public void placeAnOrder(String username, String shoppingCart){
        //int added_order_ind = Integer.parseInt(getJdbcTemplate().queryForObject("SELECT id FROM order ORDER BY id DESC LIMIT 1;", new Object[] {}, String.class));

        String sql = "insert into `order` (Customer, ProductIDs) values (?,?)";
        getJdbcTemplate().update(sql, username, shoppingCart);
    }

    public String changeconfirm(String customer,String productid,boolean isconfirmed) {
        String sql = "Update order set isconfirmed = ? where customer = ? and where productid = ?";
        int result = getJdbcTemplate().update(sql,isconfirmed,customer,productid);
        if (result == 0) {
            return "Failed";
        } else {
            return "SUCCESS";
        }
    }
}
/*    public void update(Integer id, Integer age){
      String SQL = "update Student set age = ? where id = ?";
      jdbcTemplateObject.update(SQL, age, id);
      System.out.println("Updated Record with ID = " + id );
      return;
   }*/

class OrderMapper implements RowMapper<Order> {

    public Order mapRow(ResultSet rs, int arg1) throws SQLException {
        Order o = new Order();
        o.setCustomer(rs.getString("customer"));
        o.setProductIDs(rs.getString("productid"));
        o.setConfirmed(rs.getBoolean("confirmed"));
        o.setFinished(rs.getBoolean("finished"));

        return o;
    }
}