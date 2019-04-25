/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exodia.dao;

import com.exodia.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


/**
 *
 * @author MSI
 */
public class ProductDaoImpl implements ProductDao{
    
  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

    @Override
    public ArrayList<Product> productlist() {
         String sql = "select * from product";
       ArrayList list = new ArrayList<Product>();
       List<Product> products = jdbcTemplate.query(sql, new ProductMapper());
       if(products.size() > 0){
           for(int i=0; i<9;i++){
               if(products.get(i) != null){
                   list.add(products.get(i));
               }
              
               }
           
            return list;
        }
        else{
            return null;
        }
    }
 }   
class ProductMapper implements RowMapper<Product> {

  public Product mapRow(ResultSet rs, int arg1) throws SQLException {
    Product product = new Product();
    /*galiba jsp den gelen yazılar*/
    
    product.setName(rs.getString("name"));
    product.setGender(rs.getString("gender"));
    product.setBrand(rs.getString("brand"));
    product.setCategory(rs.getString("category"));
    product.setColor(rs.getString("color"));
    product.setImage(rs.getString("image"));
    product.setPrice(rs.getDouble("price"));
    product.setSize(rs.getString("size"));
    product.setTotal(rs.getInt("total"));
    product.setType(rs.getString("type"));
    product.setSeller(rs.getString("seller"));
    

    return product;
  }
}

