package com.exodia.dao;

import com.exodia.model.Login;
import com.exodia.model.User;

public interface UserDao {

  void register(User user);

  User validateUser(Login login);
}
