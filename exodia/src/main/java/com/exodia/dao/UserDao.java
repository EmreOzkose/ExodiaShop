package com.exodia.dao;

import com.exodia.model.Login;
import com.exodia.model.User;

public interface UserDao {

  void register(User user);

  User validateUser(Login login);
  
  Boolean check_username(String username);
  
  Boolean check_email(String email);
  
  Boolean check_pnumber(String pnumber);
}
