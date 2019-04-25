package com.exodia.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.exodia.model.Login;
import com.exodia.model.Customer;
import com.exodia.dao.CustomerDao;

public class CustomerServiceImpl implements CustomerService {

  @Autowired
  public CustomerDao customerDao;

<<<<<<< HEAD
  @Override
=======
>>>>>>> parent of 3098006... product
  public void register(Customer customer) {
    customerDao.register(customer);
  }

<<<<<<< HEAD
  @Override
=======
>>>>>>> parent of 3098006... product
  public Customer validateUser(Login login) {
    return customerDao.validateUser(login);
  }

}
