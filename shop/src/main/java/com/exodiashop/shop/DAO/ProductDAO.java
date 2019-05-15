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

    public List<Product> getAllProducts() {
        String sql = "select * from product";
        List<Product> product_list = getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper(Product.class));

        return product_list;
    }

    public Product getProductByID(int id){
        String sql = "select * from product where id = '"+id+"'";
        List<Product> product_list = getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper(Product.class));

        return product_list.get(0);
    }

    public List<Product> getProductByCategory(String category){
        String sql = "select * from product where category = '"+category+"'";
        List<Product> product_list = getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper(Product.class));

        return product_list;
    }

    public int addProduct(String name, String gender, String brand, String color, String type, String category
            , String size, double price, int total, String img_path, String seller) {
        try {
            String sql = "insert into product (name, gender, brand, color, type, category, size, price, total, img_path, seller)" +
                    "values (?,?,?,?,?,?,?,?,?,?,?)";
            getJdbcTemplate().update(sql, name, gender, brand, color, type, category, size, price, total, img_path, seller);
            List<Product> products = getAllProducts();

            return products.get(products.size()).getId();
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public boolean deleteProduct( int productID) {
        String sql = "delete from product where id='"+productID+"'";
        getJdbcTemplate().update(sql);
        return true;
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