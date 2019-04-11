package com.exodia.dao;

import com.exodia.model.Login;
import com.exodia.model.Customer;

public interface CustomerDao {

  void register(Customer customer);

  Customer validateUser(Login login);
}
