/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exodia.service;

import com.exodia.dao.ProductDao;
import com.exodia.model.Product;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author MSI
 */
public class ProductServiceImpl implements ProductService {
  @Autowired
  public ProductDao productDao;
    @Override
    public ArrayList<Product> productlist() {
        return productDao.productlist();
    }
    
}
