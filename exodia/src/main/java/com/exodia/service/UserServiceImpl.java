package com.exodia.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.exodia.model.Login;
import com.exodia.model.User;
import com.exodia.dao.UserDao;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  @Override
  public void register(User user) {
    userDao.register(user);
  }

  @Override
  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }
  
  @Override
  public Boolean check_username(String username) {
    return userDao.check_username(username);
  }
  
  @Override
  public Boolean check_email(String email){
      return userDao.check_email(email);
  }
  @Override
  public Boolean check_pnumber(String pnumber){
      return userDao.check_pnumber(pnumber);
  }

}
