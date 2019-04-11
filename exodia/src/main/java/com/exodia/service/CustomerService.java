package com.exodia.service;

import com.exodia.model.Login;
import com.exodia.model.Customer;

public interface CustomerService {

  void register(Customer customer);

  Customer validateUser(Login login);
}
