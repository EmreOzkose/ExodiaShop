package com.exodiashop.shop.DAO;

import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductDAO extends JdbcDaoSupport{

    @Autowired
    DataSource datasource;

    JdbcTemplate jdbcTemplate;

    /*
    public void addProduct(User user) {
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[] {user.getId(), user.getUsername(), user.getPassword(), user.getName(),user.getSurname(),user.getDateofbirth(),user.getGender(), user.getEmail(), user.getAddress(), user.getPhonenumber() , "user"});
    }

     */

    public List<Product> getAllProducts() {
        String sql = "select * from product";
        List<Product> product_list = getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper(Product.class));

        for (Product p : product_list)
            System.out.println(p.getName());

        return product_list;
    }


}

class ProductMapper implements RowMapper<Product> {

    public Product mapRow(ResultSet rs, int arg1) throws SQLException {
        Product p = new Product();
        /*galiba jsp den gelen yazılar*/

        p.setName(rs.getString("name"));
        p.setGender(rs.getString("gender"));
        p.setBrand(rs.getString("brand"));
        p.setColor(rs.getString("color"));
        p.setType(rs.getString("type"));
        p.setCategory(rs.getString("category"));
        p.setSize(rs.getString("size"));
        p.setPrice(rs.getDouble("price"));
        p.setStock_number(rs.getInt("total"));
        p.setImg_path(rs.getString("img_path"));
        p.setSeller(rs.getString("seller"));

        return p;
    }
}