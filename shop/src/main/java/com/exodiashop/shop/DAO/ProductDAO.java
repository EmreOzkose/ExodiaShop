package com.exodiashop.shop.DAO;

import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.Seller;
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
import java.util.regex.Pattern;

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
        System.out.println("in: "+id);
        String sql = "select * from product where id='" + id + "'";
        List<Product> product_list = getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper(Product.class));

        return product_list.size() > 0 ? product_list.get(0) : null;
    }

    public List<Product> getProductBySellerId(int id){
        System.out.println("in: "+id);
        String sql = "select * from product where seller='" + id + "'";
        List<Product> product_list = getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper(Product.class));

        System.out.println(product_list);
        System.out.println(product_list.size());
        return product_list.size() > 0 ? product_list : null;
    }

    public List<Product> getProductByCategory(String category){
        String sql = "select * from product where category = '"+category+"'";
        List<Product> product_list = getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper(Product.class));

        return product_list;
    }



    public void addProduct(Seller s , String name, String gender, String brand, String color, String type, String category
            , String size, String price, String total, String img_path) {
        if(s != null) {
            int seller_id = s.getId();
            if (Pattern.matches("\\w", name) && Pattern.matches("\\w", brand)
                    && Pattern.matches("\\w", type) && Pattern.matches("\\w", category)) {
                try {
                    Double cost = Double.parseDouble(price);
                    int stock = Integer.parseInt(total);
                    String sql = "insert into product (name, gender, brand, color, type, category, size, price, total, img_path, seller)" +
                            "values (?,?,?,?,?,?,?,?,?,?,?)";
                    getJdbcTemplate().update(sql, name, gender, brand, color, type, category, size, cost, stock, img_path, seller_id);
                    String products = s.getProducts();
                    if(!products.isEmpty() && products != null) {
                        products += products+ "," + seller_id;
                    }
                    else products = seller_id+"";

                    getJdbcTemplate().update("update seller set products = ? where id = ?", products, seller_id);
                    return ;

                } catch (Exception e) {
                    e.printStackTrace();
                    return ;
                }

            }
        }
        return ;
    }
    public boolean deleteProductByID( int productID) {
        String sql = "delete from product where id='"+productID+"'";
        getJdbcTemplate().update(sql);
        return true;
    }
    public boolean deleteProduct(Seller s, String productID) {
        try {
            String sql = "delete from product where id='"+productID+"'";
            getJdbcTemplate().update(sql);
            String products = s.getProducts();
            String arr[] = products.split(",");
            String productlist="";
            for(int i=0;i< arr.length; i++){
                if(arr[i].equalsIgnoreCase(productID)){continue;}
                else {
                    if(i==0){ productlist += arr[i]; }
                    else{
                        productlist +=",";
                        productlist += arr[i];
                    }
                }
            }
            getJdbcTemplate().update("update seller set products = ? where id = ?", productlist, s.getId());
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
    public boolean editProduct(Seller s ,String id, String name, String gender, String brand, String color, String type, String category
            , String size, String price, String total, String img_path) {
        if(s != null) {
            if (Pattern.matches("\\w", name) && Pattern.matches("\\w", brand)
                    && Pattern.matches("\\w", type) && Pattern.matches("\\w", category)) {
                try {
                    Double cost = Double.parseDouble(price);
                    int stock = Integer.parseInt(total);
                    String products = s.getProducts();
                    String arr[] = products.split(",");
                    boolean hasProduct = false;
                    for(int i=0;i< arr.length; i++){
                        if(arr[i].equalsIgnoreCase(id)){
                            hasProduct=true;
                        }
                    }
                    if(hasProduct){
                        getJdbcTemplate().update("update product set name = ?, gender = ?, brand = ?, color = ?, type = ?, category = ? " +
                                ", size = ?, price = ?, total = ?, img_path = ? where id = ?", name, gender, brand, color, type, category,
                                size, cost, stock, img_path, s.getId());
                        return true;
                    }
                    else return false;

                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }

            }
        }
        return false;
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