package com.exodiashop.shop.DAO;

import com.exodiashop.shop.Model.Product;
import com.exodiashop.shop.Model.Seller;
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
import java.util.regex.*;
public class SellerDAO  extends  JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @Autowired
    ProductDAO productDAO;

    public List<Seller> getAllSellers() {
        String sql = "select * from seller";
        List<Seller> seller_list = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Seller.class));

        for (Seller s : seller_list)
            System.out.println(s.getName());

        return seller_list;

    }

    public Seller getSellerById(int id) {

        String sql = "select * from seller where id='" + id + "'";
        List<Seller> seller_list = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Seller.class));

        return seller_list.size() > 0 ? seller_list.get(0) : null;

    }

    public List<Product> listProductsById(int id) {

        Seller s = getSellerById(id);
        List<Product> productList = new ArrayList<Product>();
        String products;
        if (s != null) {
            products = s.getProducts();
            if(products != null && !products.isEmpty()){
                String arr[] = products.split(",");
                for (int i = 0; i < arr.length; i++) {
                    productList.add(productDAO.getProductByID(Integer.parseInt(arr[i])));
                }
            }
        }
        return productList;
    }

    public String updateSellerProfile(String id, String name, String locations, String password){
        String result = "";
        if (Pattern.matches("\\w", name) && Pattern.matches("\\w", password) && password.length() >= 8 ) {
            Seller s = getSellerById(Integer.parseInt(id));
            if(s != null){
                s.setName(name);
                s.setLocations(locations);
                s.setPassword(password);
                result = "Updated";
            }
        }
        if (!Pattern.matches("\\w", name)){
            result = "Format of the name is not correct!";
        }
        if(!Pattern.matches("\\w", password)){
            result = "Format of the password is not correct!";
        }
        if(password.length() < 8){
            result = "Length of the password is too short!";
        }
        return result;
    }
    public boolean addSeller(String name, String locations, String password) {
        if (Pattern.matches("\\w", name) && Pattern.matches("\\w", password)) {
            String sql = "insert into seller (name, locations, password)" + "values (?,?,?)";
            getJdbcTemplate().update(sql,name, locations, password );
            return true;
        }
        return false;

    }
    public boolean deleteSeller(String id) {
            String sql = "delete from seller where id='" + Integer.parseInt(id) + "'";
            getJdbcTemplate().update(sql);
            return true;
    }

    public boolean deleteProduct(String SellerId, String productID) {
        try {
            Seller s = getSellerById(Integer.parseInt(SellerId));
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
            s.setProducts(productlist);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}

class SellerMapper implements RowMapper<Seller> {

    public Seller mapRow(ResultSet rs, int arg1) throws SQLException {
        Seller s = new Seller();
        s.setName(rs.getString("name"));
        s.setPassword(rs.getString("password"));
        s.setLocations(rs.getString("locations"));
        s.setProducts(rs.getString("products"));
        return s;
    }
}