package com.exodia.service;

import com.exodia.model.Login;
import com.exodia.model.User;

public interface UserService {

  void register(User user);

  User validateUser(Login login);
}
