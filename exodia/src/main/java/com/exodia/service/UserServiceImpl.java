package com.exodia.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.exodia.model.Login;
import com.exodia.model.User;
import com.exodia.dao.UserDao;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public void register(User user) {
    userDao.register(user);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

}
