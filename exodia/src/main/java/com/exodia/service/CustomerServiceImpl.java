package com.exodia.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.exodia.model.Login;
import com.exodia.model.Customer;
import com.exodia.dao.CustomerDao;

public class CustomerServiceImpl implements CustomerService {

  @Autowired
  public CustomerDao customerDao;

  @Override
  public void register(Customer customer) {
    customerDao.register(customer);
  }

  @Override
  public Customer validateUser(Login login) {
    return customerDao.validateUser(login);
  }

}
