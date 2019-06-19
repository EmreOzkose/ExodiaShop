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
        String checkPass = passCheck(password);
        if (Pattern.matches("\\w+", name) && Pattern.matches("\\w+", locations)
                && checkPass.equalsIgnoreCase("Password is valid.") ) {
            Seller s = getSellerById(Integer.parseInt(id));
            if(s != null){
                getJdbcTemplate().update("update seller set name = ?, locations = ?, password = ? where id = ?", name, locations, password, s.getId());
                result = "Updated";
            }
        }
        else {
            if(checkPass.equalsIgnoreCase("Password is valid.")){
                if((Pattern.matches("\\w+", name))) {
                    result = "Please enter a location correct in format(Ankara, Istanbul etc.)";
                }
                else result =  "Please enter valid name!";
            }
            else result = checkPass;
        }
        return result;
    }
    public static String  passCheck(String password){
        System.out.println("ghtrehgdsfgds");
        boolean valid = true;
        String result = "";
        if(password.length() < 8){
            System.out.println("Password is not eight characters long.");
            result = "Password is not eight characters long.";
            valid = false;
        }
        String upperCase = "(.*[A-Z].*)";
        if(!password.matches(upperCase)){
            System.out.println("Password must contain at least one capital letter.");
            result = "Password must contain at least one capital letter.";
            valid = false;
        }
        String numbers = "(.*[0-9].*)";
        if(!password.matches(numbers)){
            System.out.println("Password must contain at least one number.");
            result = "Password must contain at least one number.";
            valid = false;
        }
        String specialChars = "(.*[ ! # @ $ % ^ & * ( ) - _ = + [ ] ; : ' \" , < . > / ?].*)";
        if(!password.matches(specialChars)){
            System.out.println("Password must contain at least one special character.");
            result = "Password must contain at least one special character.";
            valid = false;
        }
        String space = "(.*[   ].*)";
        if(password.matches(space)){
            System.out.println("Password cannot contain a space.");
            result = "Password cannot contain a space.";
            valid = false;
        }
        if(password.startsWith("?")){
            System.out.println("Password cannot start with '?'.");
            result = "Password cannot start with '?'.";
            valid = false;

        }
        if(password.startsWith("!")){
            System.out.println("Password cannot start with '!'.");
            result = "Password cannot start with '!'.";
            valid = false;
        }
        if(valid){
            System.out.println("Password is valid.");
            result = "Password is valid.";
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


    public String id2Name(int id){
        String sql = "select * from `seller` where id='" + id + "'";
        List<Seller> seller_list = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Seller.class));

        String name = "";
        if (seller_list.size() > 0)
            name = seller_list.get(0).getName();

        return name;
    }

    public void add2wallet(int id, float amount){
        String sql = "select * from `seller` where id='" + id + "'";
        List<Seller> seller_list = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Seller.class));
        Seller seller = seller_list.get(0);
        float currentWallet = seller.getWallet();

        String sql2 = "update `seller` set wallet=? where id = ?";
        getJdbcTemplate().update(sql2, (currentWallet + amount), id);

    }

    public boolean deleteStore(int id, String store) {
        try {
            if (Pattern.matches("\\w+", store)) {
                Seller s = getSellerById(id);
                if (s != null) {
                    if (s.getLocations().isEmpty()) {
                        return false;
                    }
                    else {
                        String locations ="";
                        String arr[] =  s.getLocations().split(",");
                        for(int i=0; i<arr.length;i++){
                            if(!arr[i].equalsIgnoreCase(store)) {
                                if(i==0) {
                                    i++;
                                    locations += arr[i];
                                }
                                else locations+= "," + arr[i];
                            }
                        }
                        getJdbcTemplate().update("update seller set locations = ? where id = ?", locations, s.getId());
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;

    }
}

class SellerMapper implements RowMapper<Seller> {

    public Seller mapRow(ResultSet rs, int arg1) throws SQLException {
        Seller s = new Seller();
        s.setName(rs.getString("name"));
        s.setPassword(rs.getString("password"));
        s.setLocations(rs.getString("locations"));
        s.setProducts(rs.getString("products"));
        s.setWallet(rs.getFloat("wallet"));
        return s;
    }
}
